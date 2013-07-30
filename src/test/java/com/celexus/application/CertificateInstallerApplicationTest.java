package com.celexus.application;

import static org.junit.Assert.fail;

import org.junit.Test;

public class CertificateInstallerApplicationTest
{

	@Test
	public void test()
	{
		try
		{
			CertificateInstallerApplication.main(null);
		}
		catch (ApplicationException e)
		{
			fail("Error thrown");
		}
	}

}
