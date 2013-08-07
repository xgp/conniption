package com.celexus.conniption.model.stream;

import java.io.IOException;

import org.junit.Test;
import org.mortbay.io.Buffer;
import org.mortbay.jetty.client.ContentExchange;

public class StreamingMarketQuoteTest
{

//	@Test
	public void test() throws Exception
	{
		StreamingMarketQuote quote = new StreamingMarketQuote();
		
		ContentExchange ex = new ContentExchange(true)
		{
			// tell me what kind of response code we got
			protected void onResponseComplete() throws IOException
			{
				int status = getResponseStatus();
				if (status == 200)
					System.out.println("Successfully connected");
				else
					System.out.println("Error Code Received: " + status);
			}

			// print out any response data we get along the stream
			protected void onResponseContent(Buffer data)
			{
				System.out.println(data);
			}
		};
		
		ContentExchange request = quote.stream(ex, "IBM");
//		request.waitForDone();
	}

}
