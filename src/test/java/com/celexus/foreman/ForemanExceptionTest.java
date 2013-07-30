package com.celexus.foreman;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ForemanExceptionTest
{

	@Test
	public void test()
	{
		boolean exceptionThrown = false;
		try
		{
			throw new ForemanException("");
		}
		catch (Exception e)
		{
			exceptionThrown = true;
		}

		assertTrue(exceptionThrown);
	}

}
