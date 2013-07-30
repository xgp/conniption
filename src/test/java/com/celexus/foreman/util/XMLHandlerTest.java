package com.celexus.foreman.util;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Map;

import org.junit.Test;

import com.celexus.foreman.ForemanException;
import com.celexus.foreman.TradeKingForeman;
import com.celexus.foreman.util.builder.AccountsBuilder;
import com.celexus.foreman.util.builder.MarketBuilder;
import com.celexus.model.util.AccountsField;
import com.celexus.model.util.MarketClockField;
import com.celexus.model.util.MarketQuotesResponseField;

public class XMLHandlerTest
{
	TradeKingForeman foreman = new TradeKingForeman();

	@Test
	public void parseAccountTest()
	{
		XMLHandler handler = new XMLHandler();
		connectForeman();
		Map<AccountsField, String> map = null;
		try
		{
			 map = handler.parseAccount(foreman.makeAPICall(AccountsBuilder.getAccount("38580744", ResponseFormat.XML)));
		}
		catch (UtilityException e)
		{
			fail();
		}
		assertTrue("Response failed to get results",!map.isEmpty());
		assertNotNull("Response did not include expected results",map.get(AccountsField.ACCOUNT_NUMBER));
	}
	
	@Test
	public void marketClockTest()
	{
		XMLHandler handler = new XMLHandler();
		connectForeman();
		Map<MarketClockField, String> map = null;
		try
		{
			map = handler.parseMarketClock(foreman.makeAPICall(MarketBuilder.getClock(ResponseFormat.XML)));
		}
		catch (UtilityException e)
		{
			fail();
		}	
		assertTrue("Response failed to get results",!map.isEmpty());
		assertNotNull("Response did not include expected results",map.get(MarketClockField.CURRENT));
	}

	@Test
	public void marketQuoteTest()
	{
		XMLHandler handler = new XMLHandler();
		connectForeman();
		Map<MarketQuotesResponseField, String> map = null;
		
		try
		{
			map = handler.parseMarketQuote(foreman.makeAPICall(MarketBuilder.getQuotes(ResponseFormat.XML, "SIRI")));
		}
		catch (UtilityException e)
		{
			fail();
		}
		
		assertTrue("Response failed to get results",!map.isEmpty());
		assertNotNull("Response did not include expected results",map.get(MarketQuotesResponseField.SYMBOL));
	}
	private void connectForeman()
	{
		try
		{
			foreman.connect();
		}
		catch (ForemanException e)
		{
			fail();
		}
	}

}
