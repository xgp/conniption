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

	public MarketQuote(String symbol) throws UtilityException
	{
		TradeKingForeman foreman = new TradeKingForeman();
		XMLHandler handler = new XMLHandler();
		connectForeman(foreman);
		map = handler.parseMarketQuote(foreman.makeAPICall(MarketBuilder.getQuotes(ResponseFormat.XML, symbol.trim().toUpperCase())));

	}

	public MarketQuote(String symbol, MarketQuotesResponseField... fields) throws UtilityException
	{
		XMLHandler handler = new XMLHandler();
		TradeKingForeman foreman = new TradeKingForeman();
		connectForeman(foreman);
		map = handler.parseMarketQuote(foreman.makeAPICall(MarketBuilder.getQuotes(ResponseFormat.XML, new String[] { symbol.trim().toUpperCase() }, fields)));
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
