package com.celexus.model;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.celexus.foreman.util.UtilityException;
import com.celexus.model.util.MarketClockField;

public class MarketClockTest
{

	@Test
	public void test()
	{
		try
		{
			MarketClock clock = new MarketClock();
			for(MarketClockField f: MarketClockField.values())
			{
				if(clock.hasField(f))
				{
					System.out.println("\t"+f.name()+"="+clock.getField(f));
				}
			}
			assertTrue("Expected field not in response",clock.hasField(MarketClockField.CURRENT));
		}
		catch (UtilityException e)
		{
			fail();
		}
	}

}
