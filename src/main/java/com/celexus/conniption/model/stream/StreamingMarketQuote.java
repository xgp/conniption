package com.celexus.conniption.model.stream;

import oauth.signpost.OAuthConsumer;
import oauth.signpost.jetty.JettyOAuthConsumer;

import org.mortbay.jetty.client.ContentExchange;
import org.mortbay.jetty.client.HttpClient;
import org.scribe.model.Verb;

import com.celexus.conniption.foreman.ForemanConstants;
import com.celexus.conniption.foreman.util.APICall;
import com.celexus.conniption.foreman.util.ResponseFormat;

public class StreamingMarketQuote
{

	public ContentExchange stream(ContentExchange ex, String... symbols) throws Exception
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

	private String getParameters(String[] symbols)
	{
		StringBuilder sb = new StringBuilder("?symbols=");
		for (String sym : symbols)
		{
			sb.append(sym).append(",");
		}

		return sb.toString().replaceAll(",$", "");
	}
}
