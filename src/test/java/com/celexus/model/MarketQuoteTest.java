package com.celexus.model;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.celexus.foreman.util.UtilityException;
import com.celexus.model.util.MarketQuotesResponseField;

public class MarketQuoteTest
{

	@Test
	public void test()
	{
		try
		{
			MarketQuote quote = new MarketQuote("SIRI",false);
			assertTrue("Expected Field not in response",quote.hasField(MarketQuotesResponseField.DATE_TIME));
		}
		catch (UtilityException e)
		{
			fail();
		}
	}
	
	@Test
	public void streamTest()
	{
		try
		{
			MarketQuote quote = new MarketQuote("SIRI",true);
//			assertTrue("Expected Field not in response",quote.hasField(MarketQuotesResponseField.DATE_TIME));
		}
		catch (UtilityException e)
		{
			fail();
		}
	}

}
