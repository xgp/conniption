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
	public String toString()
	{
		return symbol;
	}
}
