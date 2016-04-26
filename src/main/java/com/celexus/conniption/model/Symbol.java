package com.celexus.conniption.model;

import java.io.Serializable;

/**
 * A holder/validator for Stock Symbols returned by TradeKing
 *
 * @author cam
 *
 */
public class Symbol implements Serializable {

    private static final long serialVersionUID = 4066680359489718558L;
    private String symbol;

    public Symbol(String symbol) throws ModelException {
        if (symbol == null || symbol.matches(".*\\d.*")) {
            throw new ModelException("Not a valid symbol:" + symbol);
        }
        this.symbol = symbol.trim().toUpperCase();
    }

    public String getSymbol() {
        return symbol;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || !(o instanceof Symbol)) {
            return false;
        }
        Symbol obj = (Symbol) o;
        if (!obj.getSymbol().equals(this.getSymbol())) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return symbol;
    }
}
