package com.celexus.foreman.util;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.celexus.conniption.foreman.util.UtilityException;

public class UtilityExceptionTest {

    @Test
    public void test() {
        boolean exceptionThrown = false;
        try {
            throw new UtilityException("");
        } catch (UtilityException e) {
            exceptionThrown = true;
        }

        assertTrue(exceptionThrown);
    }

}
