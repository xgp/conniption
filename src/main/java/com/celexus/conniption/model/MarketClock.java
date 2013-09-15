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
import com.celexus.conniption.foreman.TKResponse;
import com.celexus.conniption.foreman.TradeKingForeman;
import com.celexus.conniption.foreman.util.ResponseFormat;
import com.celexus.conniption.foreman.util.UtilityException;
import com.celexus.conniption.foreman.util.XMLHandler;
import com.celexus.conniption.foreman.util.builder.MarketBuilder;
import com.celexus.conniption.model.util.MarketClockField;

/**
 * A representation of TradeKing's Market Clock
 * 
 * @author cam
 * 
 */
public class MarketClock implements Serializable
{
	private static final long serialVersionUID = 4825597509929315969L;
	private Map<MarketClockField, String> map = new HashMap<MarketClockField, String>();
	private TKResponse response;

	public MarketClock() throws UtilityException
	{
		update();
	}

	public boolean hasField(MarketClockField f)
	{
		return map.containsKey(f);
	}

	public String getField(MarketClockField f)
	{
		return map.get(f);

	}

	public TKResponse getTKResponse()
	{
		return response;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (obj == null)
		{
			return false;
		}
		if (obj instanceof MarketClock)
		{
			MarketClock other = (MarketClock) obj;
			for (MarketClockField f : MarketClockField.values())
			{
				if (this.hasField(f) == other.hasField(f) && this.hasField(f))
				{
					this.getField(f).equals(other.getField(f));
				}
				else if (this.hasField(f) || other.hasField(f))
				{
					return false;
				}
			}
		}
		else
		{
			return false;
		}

		return true;
	}

	public void update() throws UtilityException
	{
		TradeKingForeman foreman = new TradeKingForeman();
		XMLHandler handler = new XMLHandler();
		try
		{
			response = foreman.makeAPICall(MarketBuilder.getClock(ResponseFormat.XML));
		}
		catch (ForemanException e)
		{
			throw new UtilityException("Make API Call", e);
		}
		map = handler.parseMarketClock(response.toString());
	}

}
