package com.celexus.foreman;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.celexus.conniption.foreman.ForemanException;

public class ForemanExceptionTest {

    @Test
    public void test() {
        boolean exceptionThrown = false;
        try {
            throw new ForemanException("");
        } catch (Exception e) {
            exceptionThrown = true;
        }

        assertTrue(exceptionThrown);
    }

}
