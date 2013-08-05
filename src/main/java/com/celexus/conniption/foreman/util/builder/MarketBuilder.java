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
package com.celexus.conniption.foreman.util.builder;

import org.scribe.model.Verb;

import com.celexus.conniption.foreman.util.APICall;
import com.celexus.conniption.foreman.util.ResponseFormat;
import com.celexus.conniption.model.util.MarketQuotesField;
import com.celexus.conniption.model.util.MarketQuotesResponseField;

public class MarketBuilder extends APIBuilder
{
	private static final long serialVersionUID = -7542591696724178699L;

	private MarketBuilder(Verb v)
	{
		this.verb = v;
	}

	public static MarketBuilder getClock(ResponseFormat format)
	{
		MarketBuilder b = new MarketBuilder(Verb.GET);
		b.resourceURL = APICall.getMarketClock(format);
		return b;
	}
	
	public static MarketBuilder getQuotes(ResponseFormat format, String ... symbols)
	{
		return getQuotes(format,symbols, new MarketQuotesResponseField[]{});
	}
	
	public static MarketBuilder getQuotes(ResponseFormat format, String[] symbols, MarketQuotesResponseField ... fields)
	{
		return getQuotes(format,symbols,fields,false);
	}
	
	public static MarketBuilder getStreamingQuotes(ResponseFormat format, String[] symbols, MarketQuotesResponseField ... fields)
	{
		return getQuotes(format,symbols,fields,true);
	}

	private static MarketBuilder getQuotes(ResponseFormat format, String[] symbols, MarketQuotesResponseField[] fields, boolean streaming)
	{
		StringBuilder sb = new StringBuilder();
		for(String sym:symbols)
		{
			sb.append(sym+" ");
		}
		StringBuilder fids = new StringBuilder();
		for(MarketQuotesResponseField f: fields)
		{
			fids.append(f.toString()+" ");
		}
		MarketBuilder b = new MarketBuilder(Verb.POST);
		if(streaming)
		{
			b.resourceURL = APICall.getStreamingQuote(format);
		}
		else
		{
			b.resourceURL = APICall.getQuote(format);
		}
		b.params.put(MarketQuotesField.SYMBOLS.toString(), sb.toString().trim().replace(" ", ","));
		b.streaming  = streaming;
		if(!fids.toString().isEmpty())
		{
			b.params.put(MarketQuotesField.FIDS.toString(), fids.toString().trim().replace(" ", ","));
		}
		return b;
	}
	
}
