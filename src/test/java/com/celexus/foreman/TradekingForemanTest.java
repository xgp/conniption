package com.celexus.foreman;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.celexus.foreman.util.ResponseFormat;
import com.celexus.foreman.util.builder.AccountsBuilder;
import com.celexus.foreman.util.builder.MarketBuilder;

public class TradekingForemanTest
{

	@Test
	public void connectionTest()
	{
		TradekingForeman foreman = new TradekingForeman();
		try
		{
			foreman.connect();
		}
		catch (ForemanException e)
		{
			fail();
		}

		assertTrue("Foreman does not have OAuth Service", foreman.hasOAuth());
		assertTrue("Foreman does not have Access Token", foreman.hasAccessToken());
	}

	@Test
	public void apiCallTest()
	{
		TradekingForeman foreman = new TradekingForeman();
		try
		{
			foreman.connect();
		}
		catch (ForemanException e)
		{
			fail();
		}
		assertTrue("Foreman didn't recognize API reponse",foreman.makeAPICall(MarketBuilder.getClock(ResponseFormat.XML)).contains("<message>"));
	}

//	@Test
	public void accountsTest() throws Exception
	{
		TradekingForeman forman = new TradekingForeman();
		forman.connect();
		// System.out.println(forman.makeAPICall(AccountsBuilder.getAccountBalances(ResponseFormat.XML)));
		System.out.println(forman.makeAPICall(AccountsBuilder.getAccount("38580744", ResponseFormat.XML)));
		// System.out.println(forman.makeAPICall(AccountsBuilder.getAccountBalance("38580744",ResponseFormat.XML)));
		// System.out.println(forman.makeAPICall(OrdersBuilder.getOrders("38580744", ResponseFormat.XML)));
		// System.out.println(forman.makeAPICall(MarketBuilder.getClock(ResponseFormat.XML)));
		//
		// System.out.println(forman.makeAPICall(MarketBuilder.getQuotes(ResponseFormat.XML,"APPL","MSFT")));

		// System.out.println(forman.makeAPICall(b))
	}
}
