package com.celexus.conniption.api;

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
// import com.celexus.conniption.model.util.fixml.*;
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
	TradeKing ops = new TradeKing(new TradeKingForeman());

	Clock c = ops.clock();
	Accounts a = ops.accounts();
	Quotes q = ops.quotes("TWTR", "XIV");
	Future f = ops.quotes(handler, "TWTR", "XIV");

	log(c);
	log(a);
	log(q);

	wait(f, 5000L);
    }

    static private void log(Object o) {
	System.err.println(ReflectionToStringBuilder.toString(o, new RecursiveToStringStyle()));
    }

    static private void wait(Future f, long millis) {
	while (!f.isDone()) {
	    try {
		Thread.sleep(millis);
	    } catch (Exception e) {
		break;
	    }
	}
    }

    static private final StreamHandler<Quote> handler = new StreamHandler<Quote>() {
	public void handle(Quote quote) {
	    log(quote);
	}
    };

    /*
    FIXMLBuilder builder = new FIXMLBuilder(a);
    builder.timeInForce(TimeInForceField.DAY_ORDER);
    builder.symbol("OCQLF");
    builder.priceType(PriceType.LIMIT);
    builder.securityType(SecurityType.STOCK);
    builder.quantity(1);
    builder.executionPrice(.01);
    builder.side(MarketSideField.BUY);
    */
}