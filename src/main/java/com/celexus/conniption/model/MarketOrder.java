/**
 * Copyright 2013 Cameron Cook
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.celexus.conniption.model;

import java.io.Serializable;
import java.util.Map;
import java.util.Map.Entry;

import com.celexus.conniption.foreman.ForemanException;
import com.celexus.conniption.foreman.TKResponse;
import com.celexus.conniption.foreman.TradeKingForeman;
import com.celexus.conniption.foreman.util.ResponseFormat;
import com.celexus.conniption.foreman.util.UtilityException;
import com.celexus.conniption.foreman.util.XMLHandler;
import com.celexus.conniption.foreman.util.builder.OrdersBuilder;
import com.celexus.conniption.model.util.OrderField;
import com.celexus.conniption.model.util.fixml.FIXMLBuilder;

/**
 * A representation of a TradeKing Market Order
 *
 * @author cam
 *
 */
public class MarketOrder implements Serializable {

    private static final long serialVersionUID = -6031612547592870127L;
    private Map<OrderField, String> map;
    private TKResponse response;

    private Account account;
    private FIXMLBuilder b;

    public MarketOrder(Account account, FIXMLBuilder b) throws UtilityException {
        this.account = account;
        this.b = b;
        update();
    }

    public boolean hasField(OrderField f) {
        return map.containsKey(f);
    }

    public String getField(OrderField f) {
        return map.get(f);

    }

    public TKResponse getTKResponse() {
        return response;
    }

    public void update() throws UtilityException {
        TradeKingForeman foreman = new TradeKingForeman();
        XMLHandler handler = new XMLHandler();
        try {
            response = foreman.makeAPICall(OrdersBuilder.postOrder(account.getId(), b.build().toString(), ResponseFormat.XML));
        } catch (ForemanException e) {
            throw new UtilityException("Make API Call", e);
        }
        map = handler.parseMarketOrder(response.toString());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof MarketOrder) {
            MarketOrder other = (MarketOrder) obj;
            if (other.response.equals(this.response) && other.account.equals(this.account)) {
                for (Entry<OrderField, String> ent : map.entrySet()) {
                    if (!other.hasField(ent.getKey()) && !other.getField(ent.getKey()).equals(ent.getValue())) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }
}
