package com.celexus.foreman;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.celexus.conniption.foreman.ForemanConstants;

public class ForemanConstantsTest {

    @Test
    public void test() {
        assertTrue(!ForemanConstants.API_KEY.toString().isEmpty());
        assertTrue(!ForemanConstants.API_SECRET.toString().isEmpty());
        assertTrue(!ForemanConstants.ACCESS_TOKEN.toString().isEmpty());
        assertTrue(!ForemanConstants.ACCESS_TOKEN_SECRET.toString().isEmpty());
    }

}
