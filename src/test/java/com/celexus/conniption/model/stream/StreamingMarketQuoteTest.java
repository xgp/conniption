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
package com.celexus.conniption.model.stream;

import com.celexus.conniption.model.MarketQuote;
import com.celexus.conniption.model.Symbol;
import java.util.List;
import java.util.concurrent.Future;
import org.junit.Ignore;
import org.junit.Test;

public class StreamingMarketQuoteTest {

    @Test @Ignore public void test() throws Exception {
        StreamingMarketQuote quote = new StreamingMarketQuote();

	StreamHandler<MarketQuote> handler = new StreamHandler<MarketQuote>() {
	    public void handle(MarketQuote quote) {
		System.out.println(quote.toString());
	    }
	};

	Future<List<MarketQuote>> future = quote.stream(handler, new Symbol("AAPL"));
	System.out.println("Quotes before close: "+future.get().size());
    }

}
