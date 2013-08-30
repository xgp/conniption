package com.celexus.conniption.model;

import java.io.Serializable;

public class Symbol implements Serializable
{
	private static final long serialVersionUID = 4066680359489718558L;
	private String symbol;

	public Symbol(String symbol)
	{
		this.symbol = symbol.trim().toUpperCase();
	}

	public String getSymbol()
	{
		return symbol;
	}

	@Override
	public boolean equals(Object o)
	{
		if (!(o instanceof Symbol))
		{
			return false;
		}
		Symbol obj = (Symbol) o;
		if (!obj.getSymbol().equals(this.getSymbol()))
		{
			return false;
		}
		return true;
	}

	@Override
	public String toString()
	{
		return symbol;
	}
}
