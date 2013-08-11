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

import oauth.signpost.OAuthConsumer;
import oauth.signpost.jetty.JettyOAuthConsumer;

import org.mortbay.jetty.client.ContentExchange;
import org.mortbay.jetty.client.HttpClient;
import org.scribe.model.Verb;

import com.celexus.conniption.foreman.ForemanConstants;
import com.celexus.conniption.foreman.util.APICall;
import com.celexus.conniption.foreman.util.ResponseFormat;
import com.celexus.conniption.model.Symbol;

public class StreamingMarketQuote
{

	public ContentExchange stream(ContentExchange ex, Symbol ... symbols) throws Exception
	{
		OAuthConsumer consumer = new JettyOAuthConsumer(ForemanConstants.API_KEY.toString(), ForemanConstants.API_SECRET.toString());
		consumer.setTokenWithSecret(ForemanConstants.ACCESS_TOKEN.toString(), ForemanConstants.ACCESS_TOKEN_SECRET.toString());

		ex.setMethod(Verb.GET.name());
		ex.setURL(APICall.getStreamingQuote(ResponseFormat.XML) + getParameters(symbols));

		// sign the request
		consumer.sign(ex);

		HttpClient client = new HttpClient();
		client.start();
		client.send(ex);

		return ex;
	}

	private String getParameters(Symbol[] symbols)
	{
		StringBuilder sb = new StringBuilder("?symbols=");
		for (Symbol sym : symbols)
		{
			sb.append(sym).append(",");
		}

		return sb.toString().replaceAll(",$", "");
	}
}
