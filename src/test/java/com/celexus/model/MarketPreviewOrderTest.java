package com.celexus.model;

import com.celexus.conniption.model.Account;
import com.celexus.conniption.model.MarketPreviewOrder;
import com.celexus.conniption.model.ModelException;
import com.celexus.conniption.model.util.OrderPreviewField;
import com.celexus.conniption.model.util.fixml.FIXMLBuilder;
import com.celexus.conniption.model.util.fixml.MarketSideField;
import com.celexus.conniption.model.util.fixml.PriceType;
import com.celexus.conniption.model.util.fixml.SecurityType;
import com.celexus.conniption.model.util.fixml.TimeInForceField;

public class MarketPreviewOrderTest {

//	@Test
    public void test() throws ModelException {
        Account a = new Account();
        FIXMLBuilder builder = new FIXMLBuilder(a);
        builder.timeInForce(TimeInForceField.DAY_ORDER);
        builder.symbol("OCQLF");
        builder.priceType(PriceType.LIMIT);
        builder.securityType(SecurityType.STOCK);
        builder.quantity(1);
        builder.executionPrice(.01);
        builder.side(MarketSideField.BUY);
        MarketPreviewOrder order = new MarketPreviewOrder(new Account(), builder);
        for (OrderPreviewField f : OrderPreviewField.values()) {
            if (order.hasField(f)) {
                String value = order.getField(f);
                System.out.println(f + " " + value);
            }
        }
    }

}
