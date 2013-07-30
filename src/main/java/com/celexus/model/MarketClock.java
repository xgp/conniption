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
package com.celexus.model;

import java.util.HashMap;
import java.util.Map;

import com.celexus.foreman.ForemanException;
import com.celexus.foreman.TradekingForeman;
import com.celexus.foreman.util.ResponseFormat;
import com.celexus.foreman.util.UtilityException;
import com.celexus.foreman.util.XMLHandler;
import com.celexus.foreman.util.builder.MarketBuilder;
import com.celexus.model.util.MarketClockField;

public class MarketClock
{
	private Map<MarketClockField, String> map = new HashMap<MarketClockField, String>();
	private TradekingForeman foreman = new TradekingForeman();

	public MarketClock() throws UtilityException
	{
		XMLHandler handler = new XMLHandler();
		connectForeman();
		map = handler.parseMarketClock(foreman.makeAPICall(MarketBuilder.getClock(ResponseFormat.XML)));
	}

	public MarketClock(Map<MarketClockField, String> fields)
	{
		this.map = fields;
	}

	public boolean hasField(MarketClockField f)
	{
		return map.containsKey(f);
	}

	public String getField(MarketClockField f)
	{
		return map.get(f);

	}

	private void connectForeman() throws UtilityException
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
