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
package com.celexus.conniption.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.celexus.conniption.foreman.ForemanException;
import com.celexus.conniption.foreman.TradeKingForeman;
import com.celexus.conniption.foreman.util.ResponseFormat;
import com.celexus.conniption.foreman.util.UtilityException;
import com.celexus.conniption.foreman.util.XMLHandler;
import com.celexus.conniption.foreman.util.builder.MarketBuilder;
import com.celexus.conniption.model.util.MarketQuotesResponseField;

public class MarketQuote implements Serializable
{
	private static final long serialVersionUID = 3574007890139251515L;
	private Map<MarketQuotesResponseField, String> map = new HashMap<MarketQuotesResponseField, String>();

	public MarketQuote(String symbol, boolean streaming) throws UtilityException
	{
		TradeKingForeman foreman = new TradeKingForeman();
		XMLHandler handler = new XMLHandler();
		connectForeman(foreman);
		if (streaming)
		{
			handleStream(foreman.makeAPICallStream(MarketBuilder.getStreamingQuotes(ResponseFormat.XML, new String[] { symbol.trim().toUpperCase() })));
		}
		else
		{
			map = handler.parseMarketQuote(foreman.makeAPICall(MarketBuilder.getQuotes(ResponseFormat.XML, symbol.trim().toUpperCase())));

		}
	}

	private void handleStream(final BufferedReader reader)
	{
		new Thread(new Runnable()
		{

			public void run()
			{
				String line;
				try
				{
					while (true)
					{
						line = reader.readLine();
						if(line != null)
						{
						}
					}
				}
				catch (IOException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}).start();

	}

	public MarketQuote(String symbol, boolean streaming, MarketQuotesResponseField... fields) throws UtilityException
	{
		XMLHandler handler = new XMLHandler();
		TradeKingForeman foreman = new TradeKingForeman();
		connectForeman(foreman);
		if (streaming)
		{

		}
		else
		{
			map = handler.parseMarketQuote(foreman.makeAPICall(MarketBuilder.getQuotes(ResponseFormat.XML, new String[] { symbol.trim().toUpperCase() }, fields)));
		}
	}

	public boolean hasField(MarketQuotesResponseField f)
	{
		return map.containsKey(f);
	}

	public String getField(MarketQuotesResponseField f)
	{
		return map.get(f);

	}

	private void connectForeman(TradeKingForeman foreman) throws UtilityException
	{
		try
		{
			foreman.connect();
		}
		catch (ForemanException e)
		{
			throw new UtilityException("Unable to connect to the TradekingForeman", e);
		}
	}
}
