package com.celexus.application;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.celexus.foreman.ForemanException;

public class ApplicationExceptionTest
{

	@Test
	public void test()
	{
		boolean exceptionThrown = false;
		try
		{
			throw new ApplicationException(new ForemanException(""));
		}
		catch (ApplicationException e)
		{
			exceptionThrown = true;
		}
		assertTrue(exceptionThrown);
	}

}
