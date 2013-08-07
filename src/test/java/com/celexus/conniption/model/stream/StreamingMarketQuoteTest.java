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
