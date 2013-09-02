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
import java.util.Map;

import com.celexus.conniption.foreman.ForemanException;
import com.celexus.conniption.foreman.TKResponse;
import com.celexus.conniption.foreman.TradeKingForeman;
import com.celexus.conniption.foreman.util.ResponseFormat;
import com.celexus.conniption.foreman.util.UtilityException;
import com.celexus.conniption.foreman.util.XMLHandler;
import com.celexus.conniption.foreman.util.builder.OrdersBuilder;
import com.celexus.conniption.model.util.OrderPreviewField;
import com.celexus.conniption.model.util.fixml.FIXMLBuilder;

public class MarketPreviewOrder implements Serializable
{

	private static final long serialVersionUID = -3555216843532994045L;
	private Map<OrderPreviewField, String> map;
	private TKResponse response;
	private Account a;
	private FIXMLBuilder b;

	public MarketPreviewOrder(Account a, FIXMLBuilder b) throws ModelException
	{
		update();
	}

	public boolean hasField(OrderPreviewField f)
	{
		return map.containsKey(f);
	}

	public String getField(OrderPreviewField f)
	{
		return map.get(f);

	}

	public TKResponse getTKResponse()
	{
		return response;
	}

	public void update() throws ModelException
	{
		TradeKingForeman foreman = new TradeKingForeman();
		XMLHandler handler = new XMLHandler();
		try
		{
			response = foreman.makeAPICall(OrdersBuilder.preview(a.getId(), b.build().toString(), ResponseFormat.XML));
		}
		catch (ForemanException | UtilityException e)
		{
			throw new ModelException("Make API Call", e);
		}

		try
		{
			map = handler.parseMarketOrderPreview(response.toString());
		}
		catch (UtilityException e)
		{
			throw new ModelException("", e);
		}
	}

}
