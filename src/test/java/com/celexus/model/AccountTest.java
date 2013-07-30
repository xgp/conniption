package com.celexus.model;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.celexus.foreman.util.UtilityException;
import com.celexus.model.util.AccountsField;

public class AccountTest
{

	@Test
	public void test()
	{
		try
		{
			Account acc = new Account();
			assertTrue("Expected Field not returned",acc.hasField(AccountsField.ACCOUNT_VALUE));
			String id = acc.getId();
		
		}
		catch (UtilityException e)
		{
			fail();
		}
	}

}
