package com.celexus.conniption.model.util.stream;

import com.celexus.conniption.foreman.ForemanConstants;
import com.celexus.conniption.foreman.TKResponse;
import com.celexus.conniption.foreman.util.APICall;
import com.celexus.conniption.foreman.util.ResponseFormat;
import com.celexus.conniption.model.quotes.Quote;
import com.celexus.conniption.model.util.JAXBUtils;
import com.ning.http.client.AsyncHandler;
import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.AsyncHttpClientConfig;
import com.ning.http.client.HttpResponseBodyPart;
import com.ning.http.client.HttpResponseHeaders;
import com.ning.http.client.HttpResponseStatus;
import com.ning.http.client.ListenableFuture;
import com.ning.http.client.oauth.ConsumerKey;
import com.ning.http.client.oauth.OAuthSignatureCalculator;
import com.ning.http.client.oauth.RequestToken;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A representation of TradeKing's Market Quote that permits streaming
 * @author xgp (rewritten with Ning AsyncHttpClient)
 */
public class StreamingQuote {
    static private final Logger log = LoggerFactory.getLogger(StreamingQuote.class);

    private final AsyncHttpClient client;

    public StreamingQuote() {
	AsyncHttpClientConfig.Builder builder = new AsyncHttpClientConfig.Builder()
	    .setConnectTimeout(60*60*1000)
	    .setRequestTimeout(60*60*1000)
	    .setMaxConnectionsPerHost(500)
	    .setExecutorService(Executors.newCachedThreadPool()); //TODO dangerous. 250 in cam's code
	this.client = new AsyncHttpClient(builder.build());
    }

    /**
     */
    public ListenableFuture<List<Quote>> stream(final StreamHandler<Quote> handler, String... symbols) {
	ConsumerKey consumer =
	    new ConsumerKey(ForemanConstants.API_KEY.toString(), ForemanConstants.API_SECRET.toString());
	RequestToken user =
	    new RequestToken(ForemanConstants.ACCESS_TOKEN.toString(), ForemanConstants.ACCESS_TOKEN_SECRET.toString());
	OAuthSignatureCalculator calc = new OAuthSignatureCalculator(consumer, user);

	ListenableFuture<List<Quote>> response = client
	    .prepareGet(APICall.getStreamingQuote(ResponseFormat.XML) + getParameters(symbols))
	    .setSignatureCalculator(calc)
	    .execute(new AsyncHandler<List<Quote>>() {
		    private List<Quote> quotes = new ArrayList<Quote>();
 
		    @Override public AsyncHandler.STATE onStatusReceived(HttpResponseStatus s) throws Exception {
			// TODO bad status check?
			// return AsyncHandler.STATE.CONTINUE or AsyncHandler.STATE.ABORT
			return AsyncHandler.STATE.CONTINUE;
		   }
 
		    @Override public AsyncHandler.STATE onHeadersReceived(HttpResponseHeaders bodyPart) throws Exception {
			return AsyncHandler.STATE.CONTINUE;
		    }

		    @Override public AsyncHandler.STATE onBodyPartReceived(HttpResponseBodyPart bodyPart) throws Exception {
			String q = new String(bodyPart.getBodyPartBytes());
			log.info("onBodyPartReceived {}", q);
			if (q.equals("<status>connected</status>")) { //TODO make more robust
			    return AsyncHandler.STATE.CONTINUE;
			}

			Quote quote = JAXBUtils.getElement("com.celexus.conniption.model.quotes",
							   q, null, Quote.class);

			handler.handle(quote);
			quotes.add(quote);

			return AsyncHandler.STATE.CONTINUE;
		    }
 
		    @Override public List<Quote> onCompleted() throws Exception {
			return quotes;
		    }
 
		    @Override public void onThrowable(Throwable t) {
			log.warn("onThrowable", t);
		    }
		});
	return response;
    }

    private String getParameters(String[] symbols) {
        StringBuilder sb = new StringBuilder("?symbols=");
        for (String sym : symbols) {
            sb.append(sym.toString().replace("^", "%5E")).append(",");
        }
        return sb.toString().replaceAll(",$", "");
    }

}
