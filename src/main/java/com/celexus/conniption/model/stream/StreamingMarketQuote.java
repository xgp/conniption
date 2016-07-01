/**
 * Copyright 2013 Cameron Cook
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.celexus.conniption.model.stream;

import com.celexus.conniption.foreman.ForemanConstants;
import com.celexus.conniption.foreman.TKResponse;
import com.celexus.conniption.foreman.util.APICall;
import com.celexus.conniption.foreman.util.ResponseFormat;
import com.celexus.conniption.model.MarketQuote;
import com.celexus.conniption.model.ModelException;
import com.celexus.conniption.model.Symbol;
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
public class StreamingMarketQuote {
    static private final Logger log = LoggerFactory.getLogger(StreamingMarketQuote.class);

    private final AsyncHttpClient client;

    public StreamingMarketQuote() throws ModelException {
	AsyncHttpClientConfig.Builder builder = new AsyncHttpClientConfig.Builder()
	    .setConnectTimeout(60*60*1000)
	    .setRequestTimeout(60*60*1000)
	    .setMaxConnectionsPerHost(500)
	    .setExecutorService(Executors.newCachedThreadPool()); //TODO dangerous. 250 in cam's code
	this.client = new AsyncHttpClient(builder.build());
    }

    /**
     */
    public ListenableFuture<List<MarketQuote>> stream(final StreamHandler<MarketQuote> handler, Symbol... symbols) {
	ConsumerKey consumer =
	    new ConsumerKey(ForemanConstants.API_KEY.toString(), ForemanConstants.API_SECRET.toString());
	RequestToken user =
	    new RequestToken(ForemanConstants.ACCESS_TOKEN.toString(), ForemanConstants.ACCESS_TOKEN_SECRET.toString());
	OAuthSignatureCalculator calc = new OAuthSignatureCalculator(consumer, user);

	ListenableFuture<List<MarketQuote>> response = client
	    .prepareGet(APICall.getStreamingQuote(ResponseFormat.XML) + getParameters(symbols))
	    .setSignatureCalculator(calc)
	    .execute(new AsyncHandler<List<MarketQuote>>() {
		    private List<MarketQuote> quotes = new ArrayList<MarketQuote>();
 
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

			MarketQuote quote = new MarketQuote((TKResponse)null, MarketQuote.parseQuote(q));
			handler.handle(quote);
			quotes.add(quote);

			return AsyncHandler.STATE.CONTINUE;
		    }
 
		    @Override public List<MarketQuote> onCompleted() throws Exception {
			return quotes;
		    }
 
		    @Override public void onThrowable(Throwable t) {
			log.warn("onThrowable", t);
		    }
		});
	return response;
    }

    private String getParameters(Symbol[] symbols) {
        StringBuilder sb = new StringBuilder("?symbols=");
        for (Symbol sym : symbols) {
            sb.append(sym.toString().replace("^", "%5E")).append(",");
        }

        return sb.toString().replaceAll(",$", "");
    }

}
