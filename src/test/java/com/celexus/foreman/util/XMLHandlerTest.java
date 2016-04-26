package com.celexus.foreman.util;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Map;

import org.junit.Test;

import com.celexus.conniption.foreman.TradeKingForeman;
import com.celexus.conniption.foreman.util.ResponseFormat;
import com.celexus.conniption.foreman.util.XMLHandler;
import com.celexus.conniption.foreman.util.builder.AccountsBuilder;
import com.celexus.conniption.foreman.util.builder.MarketBuilder;
import com.celexus.conniption.model.util.AccountsField;
import com.celexus.conniption.model.util.MarketClockField;
import com.celexus.conniption.model.util.MarketQuotesResponseField;

public class XMLHandlerTest {

    TradeKingForeman foreman = new TradeKingForeman();

    @Test
    public void parseAccountTest() {
        XMLHandler handler = new XMLHandler();
        Map<AccountsField, String> map = null;
        try {
            map = handler.parseAccount(foreman.makeAPICall(AccountsBuilder.getAccount(System.getenv("TK_ACCOUNT_NO"), ResponseFormat.XML)).toString());
        } catch (Exception e) {
            fail();
        }

        assertTrue("Response failed to get results", !map.isEmpty());
        assertNotNull("Response did not include expected results", map.get(AccountsField.ACCOUNT_NUMBER));
    }

    @Test
    public void marketClockTest() {
        XMLHandler handler = new XMLHandler();
        Map<MarketClockField, String> map = null;
        try {
            map = handler.parseMarketClock(foreman.makeAPICall(MarketBuilder.getClock(ResponseFormat.XML)).toString());
        } catch (Exception e) {

            fail();
        }
        assertTrue("Response failed to get results", !map.isEmpty());
        assertNotNull("Response did not include expected results", map.get(MarketClockField.CURRENT));
    }

    @Test
    public void marketQuoteTest() {
        XMLHandler handler = new XMLHandler();
        Map<MarketQuotesResponseField, String> map = null;

        try {
            map = handler.parseMarketQuote(foreman.makeAPICall(MarketBuilder.getQuotes(ResponseFormat.XML, "SIRI")).toString());
        } catch (Exception e) {
            fail();
        }

        assertTrue("Response failed to get results", !map.isEmpty());
        assertNotNull("Response did not include expected results", map.get(MarketQuotesResponseField.SYMBOL));
    }

}
