package com.celexus.conniption.api;

import com.celexus.conniption.foreman.ForemanConstants;
import com.celexus.conniption.foreman.TKResponse;
import com.celexus.conniption.foreman.TradeKingForeman;
import com.celexus.conniption.foreman.util.ResponseFormat;
import com.celexus.conniption.foreman.util.builder.AccountsBuilder;
import com.celexus.conniption.foreman.util.builder.APIBuilder;
import com.celexus.conniption.foreman.util.builder.MarketBuilder;
import com.celexus.conniption.foreman.util.builder.OrdersBuilder;
import com.celexus.conniption.model.Accounts;
import com.celexus.conniption.model.Clock;
import com.celexus.conniption.model.Order;
import com.celexus.conniption.model.Quote;
import com.celexus.conniption.model.Quotes;
import com.celexus.conniption.model.stream.StreamHandler;
import com.celexus.conniption.model.stream.StreamingQuote;
import static com.celexus.conniption.model.util.JAXBUtils.*;
import com.celexus.conniption.model.util.fixml.*;
import java.util.List;
import java.util.concurrent.Future;
import org.apache.commons.lang3.builder.RecursiveToStringStyle;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 * Main entry point for use of this library. Implements just a few methods.
 * @author xgp
 */
public class TradeKing {

    private final TradeKingForeman foreman;

    public TradeKing(TradeKingForeman foreman) {
	this.foreman = foreman;
    }

    public Clock clock() {
	return get(MarketBuilder.getClock(ResponseFormat.XML),
		   null,
		   Clock.class);
    }

    public Quotes quotes(String... symbols) {
	return get(MarketBuilder.getQuotes(ResponseFormat.XML, symbols),
		   "quotes",
		   Quotes.class);
    }

    public Future<List<Quote>> quotes(StreamHandler<Quote> handler, String... symbols) {
	return new StreamingQuote()
	    .stream(handler, symbols);
    }

    public Accounts accounts() {
	return get(AccountsBuilder.getAccounts(ResponseFormat.XML),
		   "accounts",
		   Accounts.class);
    }

    public Order preview(String accountId, String fixml) {
        return get(OrdersBuilder.preview(accountId, fixml, ResponseFormat.XML),
		   null,
		   Order.class);
    }

    public Order order(String accountId, String fixml) {
        return get(OrdersBuilder.postOrder(accountId, fixml, ResponseFormat.XML),
		   null,
		   Order.class);
    }

    public Order orders(String accountId, String fixml) {
	return get(OrdersBuilder.getOrders(accountId, ResponseFormat.XML),
		   "orderstatus",
		   Order.class);
    }

    private <T> T get(APIBuilder builder, String root, Class<T> clazz) {
	try {
	    TKResponse response = foreman
		.makeAPICall(builder);
	    return getElement(response.toString(), root, clazz);
	} catch (Exception e) {
	    throw new RuntimeException(e);
	}
    }

    static public void main(String[] argv) throws Exception {
	TradeKing tk = new TradeKing(new TradeKingForeman());

	FIXMLBuilder fixml = new FIXMLBuilder().
	    id(ForemanConstants.TK_ACCOUNT_NO.toString())
	    .timeInForce(TimeInForceField.DAY_ORDER)
	    .symbol("TWTR")
	    .priceType(PriceType.LIMIT)
	    .securityType(SecurityType.STOCK)
	    .quantity(1)
	    .executionPrice(.01)
	    .side(MarketSideField.BUY);
	System.err.println(fixml.build().toString());
	Order o = tk.preview(ForemanConstants.TK_ACCOUNT_NO.toString(),
			     fixml.build().toString());
	log(o);

	/*
	Clock c = tk.clock();
	log(c);

	Accounts a = tk.accounts();
	log(a);

	Quotes q = tk.quotes("TWTR", "XIV");
	log(q);

	Future f = tk.quotes(handler, "TWTR", "XIV");
	wait(f, 15000L);
	*/
    }

    static private void log(Object o) {
	System.err.println(ReflectionToStringBuilder.toString(o, new RecursiveToStringStyle()));
    }

    static private void wait(Future f, long millis) throws Exception {
	Thread.sleep(millis);
	if (!f.isDone()) f.cancel(true);
    }

    static private final StreamHandler<Quote> handler = new StreamHandler<Quote>() {
	public void handle(Quote quote) {
	    log(quote);
	}
    };

}