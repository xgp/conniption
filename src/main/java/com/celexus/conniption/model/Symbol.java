package com.celexus.conniption.model;

public class Symbol
{
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
