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
package com.celexus.conniption.model.util;

import java.io.Serializable;

public enum MarketQuotesResponseField implements Serializable
{
	/**
	 * adp_100 Stock, Average Daily Price - 100 day
	 */
	AVG_DAILY_PRICE_100_DAYS("adp_100", "//quote/", "//trade/"),

	/**
	 * adp_200 Stock, Average Daily Price - 200 day
	 */
	AVG_DAILY_PRICE_200_DAYS("adp_200", "//quote/", "//trade/"),

	/**
	 * adp_50 Stock, Average Daily Price - 50 day
	 */
	AVG_DAILY_PRICE_50_DAYS("adp_50", "//quote/", "//trade/"),

	/**
	 * adv_21 Stock, Average Daily Volume - 21 day
	 */
	AVG_DAILY_VOLUME_21_DAYS("adv_21", "//quote/", "//trade/"),
	/**
	 * adv_30 Stock, Average Daily Volume - 30 day
	 */
	AVG_DAILY_VOLUME_30_DAYS("adv_30", "//quote/", "//trade/"),

	/**
	 * adv_90 Stock, Average Daily Volume - 90 day
	 */
	AVG_DAILY_VOLUME_90_DAYS("adv_90", "//quote/", "//trade/"),

	/**
	 * ask Stock, Option Ask price
	 */
	ASK_PRICE("ask", "//quote/", "//trade/"),

	/**
	 * ask_time Stock, Option Time of latest ask
	 */
	ASK_TIME("ask_time", "//quote/", "//trade/"),

	/**
	 * asksz Stock, Option Size of latest ask (in 100's)
	 */
	ASK_SIZE("asksz", "//quote/", "//trade/"),

	/**
	 * basis Stock, Option Reported precision (quotation decimal places)
	 */
	PRECISION("basis", "//quote/", "//trade/"),
	/**
	 * beta Stock, Beta volatility measure
	 */
	BETA_VOLATILITY("beta", "//quote/", "//trade/"),

	/**
	 * bid Stock, Option Bid price
	 */
	BID_PRICE("bid", "//quote/", "//trade/"),

	/**
	 * bid_time Stock, Option Time of latest bid
	 */
	BID_TIME("bid_time", "//quote/", "//trade/"),
	/**
	 * bidsz Stock, Option Size of latest bid (in 100's)
	 */
	BID_SIZE("bidsz", "//quote/", "//trade/"),
	/**
	 * bidtick Stock, Tick direction since last bid
	 */
	BID_TICK_DIRECTION("bidtick", "//quote/", "//trade/"),

	/**
	 * chg Stock, Option Change since prior day close (cl)
	 */
	DAY_CHANGE("chg", "//quote/", "//trade/"),

	/**
	 * chg_sign Stock, Option Change sign (e, u, d) as even, up, down
	 */
	CHANGE_DIRECTION("chg_sign", "//quote/", "//trade/"),

	/**
	 * chg_t Stock, Option change in text format
	 */
	CHANGE_PLAIN_TEXT("chg_t", "//quote/", "//trade/"),

	/**
	 * cl Stock, Option previous close
	 */
	PREVIOUS_CLOSE("cl", "//quote/", "//trade/"),

	/**
	 * contract_size Option, contract size for option
	 */
	CONTRACT_SIZE("contract_size", "//quote/", "//trade/"),

	/**
	 * cusip Stock, Cusip
	 */
	CUSIP("cusip", "//quote/", "//trade/"),

	/**
	 * date Stock, Option Trade date of last trade
	 */
	DATE_OF_LAST_TRADE("date", "//quote/", "//trade/"),

	/**
	 * datetime Stock, Option Date and time
	 */
	DATE_TIME("datetime", "//quote/", "//trade/"),

	/**
	 * days_to_expiration Option, Days until option expiration date
	 */
	DAYS_TO_EXPIRATION("days_to_expiration", "//quote/", "//trade/"),

	/**
	 * div Stock, Latest announced cash dividend
	 */
	DIVIDEND("div", "//quote/", "//trade/"),

	/**
	 * divexdate Stock, Ex-dividend date of div(YYYYMMDD)
	 */
	DIVIDEND_EX_DATE("divexdate", "//quote/", "//trade/"),

	/**
	 * divfreq Stock, Dividend frequency, A - Annual Dividend, S - Semi Annual Dividend, Q - Quarterly Dividend, M - Monthly Dividend, N - Not applicable or No Set Dividend Frequency.
	 */
	DIVIDEND_FREQUENCY("divfreq", "//quote/", "//trade/"),

	/**
	 * divpaydt Stock, Dividend pay date of last announced div
	 */
	DIVIDEND_PAY_DATE("divpaydt", "//quote/", "//trade/"),

	/**
	 * dollar_value Stock, Option Total dollar value of shares traded today
	 */
	DOLLAR_VALUE("dollar_value", "//quote/", "//trade/"),

	/**
	 * eps Stock, Earnings per share
	 */
	EARNINGS_PER_SHARE("eps", "//quote/", "//trade/"),

	/**
	 * exch Stock, Option exchange code
	 */
	EXCHANGE_CODE("exch", "//quote/", "//trade/"),

	/**
	 * exch_desc Stock, Option exchange description
	 */
	EXCHANGE_DESCRIPTION("exch_desc", "//quote/", "//trade/"),

	/**
	 * hi Stock, Option High Trade Price for the trading day
	 */
	HIGH_TRADE_PRICE("hi", "//quote/", "//trade/"),

	/**
	 * iad Stock, Indicated annual dividend
	 */
	INDICATED_ANNUAL_DIVIDEND("iad", "//quote/", "//trade/"),

	/**
	 * idelta Option, Option risk measure of delta using implied volatility
	 */
	IMPLIED_DELTA_VOLATILITY("idelta", "//quote/", "//trade/"),

	/**
	 * igamma Option, Option risk measure of gamma using implied volatility
	 */
	IMPLIED_GAMMA_VOLATILITY("igamma", "//quote/", "//trade/"),

	/**
	 * imp_volatility Option, Implied volatility of option price based current stock price
	 */
	IMPLIED_VOLATILITY("imp_volatility", "//quote/", "//trade/"),

	/**
	 * incr_vl Stock, Option Volume of last trade
	 */
	VOLUME_LAST_TRADE("incr_vl", "//quote/", "//trade/"),

	/**
	 * irho Option, Option risk measure of rho using implied volatility
	 */
	RHO("irho", "//quote/", "//trade/"),

	/**
	 * issue_desc Option, Issue description
	 */
	ISSUE_DESCRIPTION("issue_desc", "//quote/", "//trade/"),

	/**
	 * itheta Option, Option risk measure of theta using implied volatility
	 */
	THETA_VOLATILITY("itheta", "//quote/", "//trade/"),

	/**
	 * ivega Option, Option risk measure of vega using implied volatility
	 */
	VEGA_VOLATILITY("ivega", "//quote/", "//trade/"),

	/**
	 * last Stock, Option Last trade price
	 */
	LAST_TRADE_PRICE("last", "//quote/", "//trade/"),

	/**
	 * lo Stock, Option Low Trade Price for the trading day
	 */
	LOW_TRADE_PRICE("lo", "//quote/", "//trade/"),

	/**
	 * name Stock, Option Company name
	 */
	COMPANY_NAME("name", "//quote/", "//trade/"),

	/**
	 * op_delivery Option, Option Settlement Designation – S Std N – Non Std X - NA
	 */
	OPTION_SETTLEMENT_DESIGNATION("op_delivery", "//quote/", "//trade/"),

	/**
	 * op_flag Stock, Security has options (1=Yes, 0=No).
	 */
	SECURITY_HAS_OPTIONS("op_flag", "//quote/", "//trade/"),

	/**
	 * op_style Option, Option Style – values are “A” American and “E” European
	 */
	OPTION_STYLE("op_style", "//quote/", "//trade/"),

	/**
	 * op_subclass Option, Option class (0=Standard, 1=Leap, 3=Short Term)
	 */
	OPTION_CLASS("op_subclass", "//quote/", "//trade/"),

	/**
	 * openinterest Option, Open interest of option contract
	 */
	OPEN_INTEREST("openinterest", "//quote/", "//trade/"),

	/**
	 * opn Stock, Option Open trade price
	 */
	OPEN_TRADE_PRICE("opn", "//quote/", "//trade/"),

	/**
	 * opt_val Option, Estimated Option Value – via Ju/Zhong or Black-Scholes
	 */
	ESTIMATED_OPTION_VALUE("opt_val", "//quote/", "//trade/"),

	/**
	 * pchg Stock, Option percentage change from prior day close
	 */
	PERCENT_CHANGE("pchg", "//quote/", "//trade/"),

	/**
	 * pchg_sign Stock, Option prchg sign (e, u, d) as even, up, down
	 */
	PERCENT_CHANGE_DIRECTION("pchg_sign", "//quote/", "//trade/"),

	/**
	 * pcls Stock, Option Prior day close
	 */
	PRIOR_DAY_CLOSE("pcls", "//quote/", "//trade/"),

	/**
	 * pe Stock, Price earnings ratio
	 */
	PRICE_EARNINGS_RATIO("pe", "//quote/", "//trade/"),

	/**
	 * phi Stock, Option Prior day high value
	 */
	PRIOR_DAY_HIGH("phi", "//quote/", "//trade/"),

	/**
	 * plo Stock, Option Prior day low value
	 */
	PRIOR_DAY_LOW("plo", "//quote/", "//trade/"),

	/**
	 * popn Stock, Option Prior day open
	 */
	PRIOR_DAY_OPEN("popn", "//quote/", "//trade/"),

	/**
	 * pr_adp_100 Stock, Prior Average Daily Price "100"trade days
	 */
	PRIOR_AVG_DAILY_PRICE_100_DAYS("pr_adp_100", "//quote/", "//trade/"),

	/**
	 * pr_adp_200 Stock, Prior Average Daily Price "200"trade days
	 */
	PRIOR_AVG_DAILY_PRICE_200_DAYS("pr_adp_200", "//quote/", "//trade/"),

	/**
	 * pr_adp_50 Stock, Prior Average Daily Price "50"trade days
	 */
	PRIOR_AVG_DAILY_PRICE_50_DAYS("pr_adp_50", "//quote/", "//trade/"),

	/**
	 * pr_date Stock, Option Trade Date of Prior Last
	 */
	PRIOR_DATE("pr_date", "//quote/", "//trade/"),

	/**
	 * pr_openinterest Option, Prior day's open interest
	 */
	PRIOR_DAY_OPEN_INTEREST("pr_openinterest", "//quote/", "//trade/"),

	/**
	 * prbook Stock, Book Value Price
	 */
	BOOK_VALUE_PRICE("prbook", "//quote/", "//trade/"),

	/**
	 * prchg Stock, Option Prior day change
	 */
	PRIOR_DAY_CHANGE("prchg", "//quote/", "//trade/"),

	/**
	 * prem_mult Option, Option premium multiplier
	 */
	PREMIUM_MULTIPLIER("prem_mult", "//quote/", "//trade/"),

	/**
	 * put_call Option, Option type (Put or Call)
	 */
	PUT_OR_CALL("put_call", "//quote/", "//trade/"),

	/**
	 * pvol Stock, Option Prior day total volume
	 */
	PRIOR_DAY_TOTAL_VOLUME("pvol", "//quote/", "//trade/"),

	/**
	 * qcond Option, Condition code of quote
	 */
	CONDITION_CODE("qcond", "//quote/", "//trade/"),

	/**
	 * rootsymbol Option, Option root symbol
	 */
	ROOT_SYMBOL("rootsymbol", "//quote/", "//trade/"),

	/**
	 * secclass Stock, Option Security class (0=stock, 1=option)
	 */
	SECURITY_CLASS("secclass", "//quote/", "//trade/"),

	/**
	 * sesn Stock, Option Trading session as (pre, regular, &amp, post)
	 */
	TRADING_SESSION("sesn", "//quote/", "//trade/"),

	/**
	 * sho Stock, Shares Outstanding
	 */
	SHARES_OUTSTANDING("sho", "//quote/", "//trade/"),

	/**
	 * strikeprice Option, Option strike price (not extended by multiplier)
	 */
	STRIKE_PRICE("strikeprice", "//quote/", "//trade/"),

	/**
	 * symbol Stock, Option Symbol from data provider
	 */
	SYMBOL("symbol", "//quote/", "//trade/"),

	/**
	 * tcond Stock, Option Trade condition code – (H) halted or (R) resumed
	 */
	TRADE_CONDITION_CODE("tcond", "//quote/", "//trade/"),

	/**
	 * timestamp Stock, Option Timestamp
	 */
	TIMESTAMP("timestamp", "//quote/", "//trade/"),

	/**
	 * tr_num Stock, Option Number of trades since market open
	 */
	NUMBER_OF_TRADES("tr_num", "//quote/", "//trade/"),

	/**
	 * tradetick Stock, Option Tick direction from prior trade – (e,u,d) even, up, down)
	 */
	TICK_DIRECTION("tradetick", "//quote/", "//trade/"),

	/**
	 * trend Stock, Option Trend based on 10 prior ticks (e,u,d) even, up, down
	 */
	TICK_TREND("trend", "//quote/", "//trade/"),

	/**
	 * under_cusip Option, An option's underlying cusip
	 */
	UDERLYING_CUSIP("under_cusip", "//quote/", "//trade/"),

	/**
	 * undersymbol Option, An option's underlying symbol
	 */
	UNDERLYING_SYMBOL("undersymbol", "//quote/", "//trade/"),

	/**
	 * vl Stock, Option Cumulative volume
	 */
	CULUMLATIVE_VOLUME("vl", "//quote/", "//trade/"),

	/**
	 * volatility12 Stock, one year volatility measure
	 */
	ONE_YEAR_VOLATILITY("volatility12", "//quote/", "//trade/"),

	/**
	 * vwap Stock, Option Volume weighted average price
	 */
	VOLUME_WEIGHT_AVG_PRICE("vwap", "//quote/", "//trade/"),

	/**
	 * wk52hidate Stock, Option 52 week high date
	 */
	YEAR_HIGH("wk52hi", "//quote/", "//trade/"),

	/**
	 * wk52lo Stock, Option 52 week low
	 */
	YEAR_HIGH_DATE("wk52hidate", "//quote/", "//trade/"),

	/**
	 * wk52lodate Stock, Option 52 week low date
	 */
	YEAR_LOW("wk52lo", "//quote/", "//trade/"),

	/**
	 * wk52lodate Stock, Option 52 week low date
	 */
	YEAR_LOW_DATE("wk52lodate", "//quote/", "//trade/"),

	/**
	 * xdate Option, Expiration date of option in the format of (YYYYMMDD)
	 */
	FORMATTED_OPTION_EXPIRATION("xdate", "//quote/", "//trade/"),

	/**
	 * xday Option, Expiration day of option
	 */
	OPTION_DAY_EXPIRATION("xday", "//quote/", "//trade/"),

	/**
	 * xmonth Option, Expiration month of option
	 */
	OPTION_MONTH_EXPIRATION("xmonth", "//quote/", "//trade/"),

	/**
	 * xyear Option, Expiration year of option
	 */
	OPTION_YEAR_EXPIRATION("xyear", "//quote/", "//trade/"),

	/**
	 * yield Stock, Dividend yield as %
	 */
	DIVIDEND_YEILD("yield", "//quote/", "//trade/"),

	ERROR("error")
	{
		@Override
		public String toString()
		{
			return "//error";
		}

		@Override
		public String[] getPaths()
		{
			return new String[] { "//error" };
		}
	};

	private String tag;
	private String[] paths;

	MarketQuotesResponseField(String tag, String... paths)
	{
		this.tag = tag;
		this.paths = new String[paths.length];
		for (int i = 0; i < paths.length; i++)
		{
			this.paths[i] = paths[i] + tag;
		}
	}

	@Override
	public String toString()
	{
		return tag;
	}

	public String[] getPaths()
	{
		return paths;
	}

	public static MarketQuotesResponseField getFieldByName(String cq)
	{
		for (MarketQuotesResponseField f : MarketQuotesResponseField.values())
		{
			if (f.name().toLowerCase().equals(cq.toLowerCase()))
			{
				return f;
			}
		}
		return null;
	}
}
