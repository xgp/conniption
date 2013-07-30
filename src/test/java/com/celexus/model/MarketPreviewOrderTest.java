package com.celexus.model;

import org.junit.Test;

import com.celexus.foreman.util.UtilityException;
import com.celexus.model.util.OrderPreviewField;
import com.celexus.model.util.fixml.FIXMLBuilder;
import com.celexus.model.util.fixml.MarketSideField;
import com.celexus.model.util.fixml.PriceType;
import com.celexus.model.util.fixml.SecurityType;
import com.celexus.model.util.fixml.TimeInForceField;

public class MarketPreviewOrderTest
{

	@Test
	public void test() throws UtilityException
	{
		FIXMLBuilder builder = new FIXMLBuilder("38580744");
		builder.timeInForce(TimeInForceField.DAY_ORDER);
		builder.symbol("OCQLF");
		builder.priceType(PriceType.LIMIT);
		builder.securityType(SecurityType.STOCK);
		builder.quantity(1);
		builder.executionPrice(.01);
		builder.side(MarketSideField.BUY);
		MarketPreviewOrder order = new MarketPreviewOrder("38580744", builder);
		for(OrderPreviewField f: OrderPreviewField.values())
		{
			if(order.hasField(f))
			{
				String value = order.getField(f);
				System.out.println(f+" "+value);
			}
		}
	}

}
