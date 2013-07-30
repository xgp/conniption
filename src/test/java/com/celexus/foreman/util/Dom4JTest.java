package com.celexus.foreman.util;

import org.junit.Test;

import com.celexus.model.MarketQuote;
import com.celexus.model.util.MarketQuotesResponseField;

public class Dom4JTest
{

	@Test
	public void test() throws Exception
	{
//		MarketClock returned  = new MarketClock(ResponseFormat.XML);
//		for(MarketClockField f: MarketClockField.values())
//		{
//			if(returned.hasField(f))
//			{
//				System.out.println(f+" "+returned.getField(f));
//			}
//		}
		MarketQuote quote = new MarketQuote( "SIRI",false, MarketQuotesResponseField.SYMBOL);
		for(MarketQuotesResponseField f: MarketQuotesResponseField.values())
		{
			if (quote.hasField(f))
			{
				System.out.println(f.name() + " " + quote.getField(f));
			}
		}
	}

}
