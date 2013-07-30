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

import java.util.Map;

import com.celexus.foreman.ForemanException;
import com.celexus.foreman.TradeKingForeman;
import com.celexus.foreman.util.ResponseFormat;
import com.celexus.foreman.util.UtilityException;
import com.celexus.foreman.util.XMLHandler;
import com.celexus.foreman.util.builder.OrdersBuilder;
import com.celexus.model.util.OrderField;
import com.celexus.model.util.fixml.FIXMLBuilder;

public class MarketOrder
{

	private TradeKingForeman foreman = new TradeKingForeman();
	private Map<OrderField,String> map;
	
	public MarketOrder(String id, FIXMLBuilder b) throws UtilityException
	{
		XMLHandler handler = new XMLHandler();
		connectForeman();
		
		map = handler.parseMarketOrder(foreman.makeAPICall(OrdersBuilder.postOrder(id, b.build().toString(), ResponseFormat.XML)));
	}
	
	public boolean hasField(OrderField f)
	{
		return map.containsKey(f);
	}

	public String getField(OrderField f)
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
