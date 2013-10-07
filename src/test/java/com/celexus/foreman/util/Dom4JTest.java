package com.celexus.foreman.util;

import com.celexus.conniption.model.MarketQuote;
import com.celexus.conniption.model.Symbol;
import com.celexus.conniption.model.util.MarketQuotesResponseField;

public class Dom4JTest
{

//	@Test
	public void test() throws Exception
	{
		MarketQuote quote = new MarketQuote( new Symbol("SIRI"));
		for(MarketQuotesResponseField f: MarketQuotesResponseField.values())
		{
			if (quote.hasField(f))
			{
				System.out.println(f.name() + " " + quote.getField(f));
			}
		}
	}

}
