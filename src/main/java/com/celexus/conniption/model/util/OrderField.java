package com.celexus.conniption.model.util;

public enum OrderField
{
	CLIENT_ORDER_ID("//clientorder"),
	ORDER_STATUS("//orderstatus"),
	ERROR("//error");
	
	private String tag;
	OrderField(String tag)
	{
		this.tag = tag;
	}
	
	@Override
	public String toString()
	{
		return tag;
	}

	public String getPath()
	{
		return tag;
	}
}
