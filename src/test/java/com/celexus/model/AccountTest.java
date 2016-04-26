package com.celexus.model;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.celexus.conniption.model.Account;
import com.celexus.conniption.model.ModelException;
import com.celexus.conniption.model.util.AccountsField;

public class AccountTest {

    @Test
    public void test() {
        try {
            Account acc = new Account();
            assertTrue("Expected Field not returned", acc.hasField(AccountsField.ACCOUNT_VALUE));

        } catch (ModelException e) {
            fail();
        }
    }

}
