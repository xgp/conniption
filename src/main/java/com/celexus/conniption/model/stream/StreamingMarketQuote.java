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

import java.io.IOException;

import oauth.signpost.OAuthConsumer;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;
import oauth.signpost.jetty.JettyOAuthConsumer;

import org.mortbay.jetty.client.ContentExchange;
import org.mortbay.jetty.client.HttpClient;
import org.mortbay.thread.QueuedThreadPool;
import org.scribe.model.Verb;

import com.celexus.conniption.foreman.ForemanConstants;
import com.celexus.conniption.foreman.util.APICall;
import com.celexus.conniption.foreman.util.ResponseFormat;
import com.celexus.conniption.model.ModelException;
import com.celexus.conniption.model.Symbol;

/**
 * A representation of TradeKing's Market Quote that permits streaming
 * 
 * @author cam
 * 
 */
public class StreamingMarketQuote
{
	HttpClient client = new HttpClient();

	public StreamingMarketQuote() throws ModelException
	{
		client.setThreadPool(new QueuedThreadPool(250));
		client.setConnectorType(HttpClient.CONNECTOR_SELECT_CHANNEL);
		client.setMaxConnectionsPerAddress(500); // max 200 concurrent connections to every address
		try
		{
			client.start();
		}
		catch (Exception e)
		{
			throw new ModelException("Start HTTP Client", e);
		}
	}

	public ContentExchange stream(ContentExchange ex, Symbol... symbols) throws ModelException
	{
		OAuthConsumer consumer = new JettyOAuthConsumer(ForemanConstants.API_KEY.toString(), ForemanConstants.API_SECRET.toString());
		consumer.setTokenWithSecret(ForemanConstants.ACCESS_TOKEN.toString(), ForemanConstants.ACCESS_TOKEN_SECRET.toString());

		ex.setMethod(Verb.GET.name());
		ex.setURL(APICall.getStreamingQuote(ResponseFormat.XML) + getParameters(symbols));

		// sign the request
		try
		{
			consumer.sign(ex);
			client.send(ex);
		}
		catch (IOException | OAuthMessageSignerException | OAuthExpectationFailedException | OAuthCommunicationException e)
		{
			throw new ModelException("Sent Exchange to Client", e);
		}

		return ex;
	}

	private String getParameters(Symbol[] symbols)
	{
		StringBuilder sb = new StringBuilder("?symbols=");
		for (Symbol sym : symbols)
		{
			sb.append(sym.toString().replace("^", "%5E")).append(",");
		}

		return sb.toString().replaceAll(",$", "");
	}
}
