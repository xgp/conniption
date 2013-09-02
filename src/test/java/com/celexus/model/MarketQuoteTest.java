package com.celexus.model;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.celexus.conniption.model.MarketQuote;
import com.celexus.conniption.model.ModelException;
import com.celexus.conniption.model.Symbol;
import com.celexus.conniption.model.util.MarketQuotesResponseField;

public class MarketQuoteTest
{

	@Test
	public void test()
	{
		try
		{
			MarketQuote quote = new MarketQuote(new Symbol("SIRI"));
			for(MarketQuotesResponseField f: MarketQuotesResponseField.values())
			{
				if(quote.hasField(f))
				{
					System.out.println(f.name()+"="+quote.getField(f));
				}
			}
			assertTrue("Expected Field not in response",quote.hasField(MarketQuotesResponseField.DATE_TIME));
		}
		catch (ModelException e)
		{
			fail();
		}
	}

}
