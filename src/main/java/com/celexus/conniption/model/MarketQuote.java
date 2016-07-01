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
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.celexus.conniption.foreman.ForemanException;
import com.celexus.conniption.foreman.TKResponse;
import com.celexus.conniption.foreman.TradeKingForeman;
import com.celexus.conniption.foreman.util.ResponseFormat;
import com.celexus.conniption.foreman.util.UtilityException;
import com.celexus.conniption.foreman.util.XMLHandler;
import com.celexus.conniption.foreman.util.builder.MarketBuilder;
import com.celexus.conniption.model.util.MarketQuotesResponseField;

/**
 * A representation for TradeKing's Market Quotes
 *
 * @author cam
 *
 */
public class MarketQuote implements Serializable {

    private static final long serialVersionUID = 3574007890139251515L;
    private Map<MarketQuotesResponseField, String> map = new HashMap<MarketQuotesResponseField, String>();
    private TKResponse response;
    private Symbol symbol;
    private MarketQuotesResponseField[] fields;

    public String toString() {
	StringBuilder o = new StringBuilder();
	o.append(symbol.toString());
	for (Map.Entry<MarketQuotesResponseField, String> field : map.entrySet()) {
	    o.append("\n  ").append(field.getKey().name()).append(" => ").append(field.getValue());
	}
	return o.toString();
    }

    public MarketQuote(Symbol symbol) throws ModelException {
        this.symbol = symbol;
        update();
    }

    public MarketQuote(Symbol symbol, Map<MarketQuotesResponseField, String> map) {
        this.symbol = symbol;
        this.map = map;
        response = new TKResponse();
    }

    public MarketQuote(TKResponse response, ResponseFormat format)
            throws ModelException {
        this.response = response;
        if (!format.equals(ResponseFormat.XML)) {
            throw new ModelException("Format:" + format.name()
                    + " not supported");
        }
        map = parseQuote(response.toString());
        this.symbol = new Symbol(map.get(MarketQuotesResponseField.SYMBOL));
    }

    public MarketQuote(TKResponse response,
		       Map<MarketQuotesResponseField, String> map) throws ModelException {
        this.map = map;
        this.symbol = new Symbol(map.get(MarketQuotesResponseField.SYMBOL));
        this.response = response;
    }

    public void update() throws ModelException {
        TradeKingForeman foreman = new TradeKingForeman();
        if (fields != null) {
            try {
                response = foreman.makeAPICall(MarketBuilder.getQuotes(
                        ResponseFormat.XML,
                        new String[]{symbol.getSymbol()}, fields));
            } catch (ForemanException e) {
                throw new ModelException("Make API Call", e);
            }
        } else {
            try {
                response = foreman.makeAPICall(MarketBuilder.getQuotes(
                        ResponseFormat.XML, symbol.getSymbol()));
            } catch (ForemanException e) {
                throw new ModelException("Make API Call", e);
            }
        }
        map = parseQuote(response.toString());
    }

    static public Map<MarketQuotesResponseField, String> parseQuote(String response)
            throws ModelException {
        XMLHandler handler = new XMLHandler();
        try {
            return handler.parseMarketQuote(response.toString());
        } catch (UtilityException e) {
            throw new ModelException("", e);
        }
    }

    public boolean hasField(MarketQuotesResponseField f) {
        return map.containsKey(f);
    }

    public String getField(MarketQuotesResponseField f) {
        return map.get(f);

    }

    public Symbol getSymbol() {
        return symbol;
    }

    public TKResponse getTKResponse() {
        return response;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == null) {
            return false;
        }
        if (obj instanceof MarketQuote) {
            MarketQuote other = (MarketQuote) obj;
            for (MarketQuotesResponseField f : MarketQuotesResponseField
                    .values()) {
                if (this.hasField(f) == other.hasField(f) && this.hasField(f)) {
                    this.getField(f).equals(other.getField(f));
                } else if (this.hasField(f) || other.hasField(f)) {
                    return false;
                }
            }
        } else {
            return false;
        }

        return true;
    }

    public static MarketQuote modify(MarketQuote q,
            MarketQuotesResponseField key, String value) throws ModelException {
        Map<MarketQuotesResponseField, String> copy = new HashMap<MarketQuotesResponseField, String>();
        for (Entry<MarketQuotesResponseField, String> ent : q.map.entrySet()) {
            copy.put(ent.getKey(), ent.getValue());
        }
        copy.put(key, value);
        return new MarketQuote(q.getTKResponse(), copy);
    }

    public boolean isValid() {
        return !map.isEmpty() && symbol != null;
    }

}
