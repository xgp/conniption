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
	AVG_DAILY_PRICE_100_DAYS("adp_100"),
	/**
	 * adp_200 Stock, Average Daily Price - 200 day
	 */
	AVG_DAILY_PRICE_200_DAYS("adp_200"),

	/**
	 * adp_50 Stock, Average Daily Price - 50 day
	 */
	AVG_DAILY_PRICE_50_DAYS("adp_50"),

	/**
	 * adv_21 Stock, Average Daily Volume - 21 day
	 */
	AVG_DAILY_VOLUME_21_DAYS("adv_21"),

	/**
	 * adv_30 Stock, Average Daily Volume - 30 day
	 */
	AVG_DAILY_VOLUME_30_DAYS("adv_30"),

	/**
	 * adv_90 Stock, Average Daily Volume - 90 day
	 */
	AVG_DAILY_VOLUME_90_DAYS("adv_90"),

	/**
	 * ask Stock, Option Ask price
	 */
	ASK_PRICE("ask"),

	/**
	 * ask_time Stock, Option Time of latest ask
	 */
	ASK_TIME("ask_time"),

	/**
	 * asksz Stock, Option Size of latest ask (in 100's)
	 */
	ASK_SIZE("asksz"),

	/**
	 * basis Stock, Option Reported precision (quotation decimal places)
	 */
	PRECISION("basis"),
	/**
	 * beta Stock, Beta volatility measure
	 */
	BETA_VOLATILITY("beta"),

	/**
	 * bid Stock, Option Bid price
	 */
	BID_PRICE("bid"),

	/**
	 * bid_time Stock, Option Time of latest bid
	 */
	BID_TIME("bid_time"),
	/**
	 * bidsz Stock, Option Size of latest bid (in 100's)
	 */
	BID_SIZE("bidsz"),
	/**
	 * bidtick Stock, Tick direction since last bid
	 */
	BID_TICK_DIRECTION("bidtick"),

	/**
	 * chg Stock, Option Change since prior day close (cl)
	 */
	DAY_CHANGE("chg"),

	/**
	 * chg_sign Stock, Option Change sign (e, u, d) as even, up, down
	 */
	CHANGE_DIRECTION("chg_sign"),

	/**
	 * chg_t Stock, Option change in text format
	 */
	CHANGE_PLAIN_TEXT("chg_t"),

	/**
	 * cl Stock, Option previous close
	 */
	PREVIOUS_CLOSE("cl"),

	/**
	 * contract_size Option, contract size for option
	 */
	CONTRACT_SIZE("contract_size"),

	/**
	 * cusip Stock, Cusip
	 */
	CUSIP("cusip"),

	/**
	 * date Stock, Option Trade date of last trade
	 */
	DATE_OF_LAST_TRADE("date"),

	/**
	 * datetime Stock, Option Date and time
	 */
	DATE_TIME("datetime"),

	/**
	 * days_to_expiration Option, Days until option expiration date
	 */
	DAYS_TO_EXPIRATION("days_to_expiration"),

	/**
	 * div Stock, Latest announced cash dividend
	 */
	DIVIDEND("div"),

	/**
	 * divexdate Stock, Ex-dividend date of div(YYYYMMDD)
	 */
	DIVIDEND_EX_DATE("divexdate"),

	/**
	 * divfreq Stock, Dividend frequency, A - Annual Dividend, S - Semi Annual Dividend, Q - Quarterly Dividend, M - Monthly Dividend, N - Not applicable or No Set Dividend Frequency.
	 */
	DIVIDEND_FREQUENCY("divfreq"),

	/**
	 * divpaydt Stock, Dividend pay date of last announced div
	 */
	DIVIDEND_PAY_DATE("divpaydt"),

	/**
	 * dollar_value Stock, Option Total dollar value of shares traded today
	 */
	DOLLAR_VALUE("dollar_value"),

	/**
	 * eps Stock, Earnings per share
	 */
	EARNINGS_PER_SHARE("eps"),

	/**
	 * exch Stock, Option exchange code
	 */
	EXCHANGE_CODE("exch"),

	/**
	 * exch_desc Stock, Option exchange description
	 */
	EXCHANGE_DESCRIPTION("exch_desc"),

	/**
	 * hi Stock, Option High Trade Price for the trading day
	 */
	HIGH_TRADE_PRICE("hi"),

	/**
	 * iad Stock, Indicated annual dividend
	 */
	INDICATED_ANNUAL_DIVIDEND("iad"),

	/**
	 * idelta Option, Option risk measure of delta using implied volatility
	 */
	IMPLIED_DELTA_VOLATILITY("idelta"),

	/**
	 * igamma Option, Option risk measure of gamma using implied volatility
	 */
	IMPLIED_GAMMA_VOLATILITY("igamma"),

	/**
	 * imp_volatility Option, Implied volatility of option price based current stock price
	 */
	IMPLIED_VOLATILITY("imp_volatility"),

	/**
	 * incr_vl Stock, Option Volume of last trade
	 */
	VOLUME_LAST_TRADE("incr_vl"),

	/**
	 * irho Option, Option risk measure of rho using implied volatility
	 */
	RHO("irho"),

	/**
	 * issue_desc Option, Issue description
	 */
	ISSUE_DESCRIPTION("issue_desc"),

	/**
	 * itheta Option, Option risk measure of theta using implied volatility
	 */
	THETA_VOLATILITY("itheta"),

	/**
	 * ivega Option, Option risk measure of vega using implied volatility
	 */
	VEGA_VOLATILITY("ivega"),

	/**
	 * last Stock, Option Last trade price
	 */
	LAST_TRADE_PRICE("last"),

	/**
	 * lo Stock, Option Low Trade Price for the trading day
	 */
	LOW_TRADE_PRICE("lo"),

	/**
	 * name Stock, Option Company name
	 */
	COMPANY_NAME("name"),

	/**
	 * op_delivery Option, Option Settlement Designation – S Std N – Non Std X - NA
	 */
	OPTION_SETTLEMENT_DESIGNATION("op_delivery"),

	/**
	 * op_flag Stock, Security has options (1=Yes, 0=No).
	 */
	SECURITY_HAS_OPTIONS("op_flag"),

	/**
	 * op_style Option, Option Style – values are “A” American and “E” European
	 */
	OPTION_STYLE("op_style"),

	/**
	 * op_subclass Option, Option class (0=Standard, 1=Leap, 3=Short Term)
	 */
	OPTION_CLASS("op_subclass"),

	/**
	 * openinterest Option, Open interest of option contract
	 */
	OPEN_INTEREST("openinterest"),

	/**
	 * opn Stock, Option Open trade price
	 */
	OPEN_TRADE_PRICE("opn"),

	/**
	 * opt_val Option, Estimated Option Value – via Ju/Zhong or Black-Scholes
	 */
	ESTIMATED_OPTION_VALUE("opt_val"),

	/**
	 * pchg Stock, Option percentage change from prior day close
	 */
	PERCENT_CHANGE("pchg"),

	/**
	 * pchg_sign Stock, Option prchg sign (e, u, d) as even, up, down
	 */
	PERCENT_CHANGE_DIRECTION("pchg_sign"),

	/**
	 * pcls Stock, Option Prior day close
	 */
	PRIOR_DAY_CLOSE("pcls"),

	/**
	 * pe Stock, Price earnings ratio
	 */
	PRICE_EARNINGS_RATIO("pe"),

	/**
	 * phi Stock, Option Prior day high value
	 */
	PRIOR_DAY_HIGH("phi"),

	/**
	 * plo Stock, Option Prior day low value
	 */
	PRIOR_DAY_LOW("plo"),

	/**
	 * popn Stock, Option Prior day open
	 */
	PRIOR_DAY_OPEN("popn"),

	/**
	 * pr_adp_100 Stock, Prior Average Daily Price "100"trade days
	 */
	PRIOR_AVG_DAILY_PRICE_100_DAYS("pr_adp_100"),

	/**
	 * pr_adp_200 Stock, Prior Average Daily Price "200"trade days
	 */
	PRIOR_AVG_DAILY_PRICE_200_DAYS("pr_adp_200"),

	/**
	 * pr_adp_50 Stock, Prior Average Daily Price "50"trade days
	 */
	PRIOR_AVG_DAILY_PRICE_50_DAYS("pr_adp_50"),

	/**
	 * pr_date Stock, Option Trade Date of Prior Last
	 */
	PRIOR_DATE("pr_date"),

	/**
	 * pr_openinterest Option, Prior day's open interest
	 */
	PRIOR_DAY_OPEN_INTEREST("pr_openinterest"),

	/**
	 * prbook Stock, Book Value Price
	 */
	BOOK_VALUE_PRICE("prbook"),

	/**
	 * prchg Stock, Option Prior day change
	 */
	PRIOR_DAY_CHANGE("prchg"),

	/**
	 * prem_mult Option, Option premium multiplier
	 */
	PREMIUM_MULTIPLIER("prem_mult"),

	/**
	 * put_call Option, Option type (Put or Call)
	 */
	PUT_OR_CALL("put_call"),

	/**
	 * pvol Stock, Option Prior day total volume
	 */
	PRIOR_DAY_TOTAL_VOLUME("pvol"),

	/**
	 * qcond Option, Condition code of quote
	 */
	CONDITION_CODE("qcond"),

	/**
	 * rootsymbol Option, Option root symbol
	 */
	ROOT_SYMBOL("rootsymbol"),

	/**
	 * secclass Stock, Option Security class (0=stock, 1=option)
	 */
	SECURITY_CLASS("secclass"),

	/**
	 * sesn Stock, Option Trading session as (pre, regular, &amp, post)
	 */
	TRADING_SESSION("sesn"),

	/**
	 * sho Stock, Shares Outstanding
	 */
	SHARES_OUTSTANDING("sho"),

	/**
	 * strikeprice Option, Option strike price (not extended by multiplier)
	 */
	STRIKE_PRICE("strikeprice"),

	/**
	 * symbol Stock, Option Symbol from data provider
	 */
	SYMBOL("symbol"),

	/**
	 * tcond Stock, Option Trade condition code – (H) halted or (R) resumed
	 */
	TRADE_CONDITION_CODE("tcond"),

	/**
	 * timestamp Stock, Option Timestamp
	 */
	TIMESTAMP("timestamp"),

	/**
	 * tr_num Stock, Option Number of trades since market open
	 */
	NUMBER_OF_TRADES("tr_num"),

	/**
	 * tradetick Stock, Option Tick direction from prior trade – (e,u,d) even, up, down)
	 */
	TICK_DIRECTION("tradetick"),

	/**
	 * trend Stock, Option Trend based on 10 prior ticks (e,u,d) even, up, down
	 */
	TICK_TREND("trend"),

	/**
	 * under_cusip Option, An option's underlying cusip
	 */
	UDERLYING_CUSIP("under_cusip"),

	/**
	 * undersymbol Option, An option's underlying symbol
	 */
	UNDERLYING_SYMBOL("undersymbol"),

	/**
	 * vl Stock, Option Cumulative volume
	 */
	CULUMLATIVE_VOLUME("vl"),

	/**
	 * volatility12 Stock, one year volatility measure
	 */
	ONE_YEAR_VOLATILITY("volatility12"),

	/**
	 * vwap Stock, Option Volume weighted average price
	 */
	VOLUME_WEIGHT_AVG_PRICE("vwap"),

	/**
	 * wk52hidate Stock, Option 52 week high date
	 */
	YEAR_HIGH("wk52hi"),

	/**
	 * wk52lo Stock, Option 52 week low
	 */
	YEAR_HIGH_DATE("wk52hidate"),

	/**
	 * wk52lodate Stock, Option 52 week low date
	 */
	YEAR_LOW("wk52lo"),

	/**
	 * wk52lodate Stock, Option 52 week low date
	 */
	YEAR_LOW_DATE("wk52lodate"),

	/**
	 * xdate Option, Expiration date of option in the format of (YYYYMMDD)
	 */
	FORMATTED_OPTION_EXPIRATION("xdate"),

	/**
	 * xday Option, Expiration day of option
	 */
	OPTION_DAY_EXPIRATION("xday"),

	/**
	 * xmonth Option, Expiration month of option
	 */
	OPTION_MONTH_EXPIRATION("xmonth"),

	/**
	 * xyear Option, Expiration year of option
	 */
	OPTION_YEAR_EXPIRATION("xyear"),

	/**
	 * yield Stock, Dividend yield as %
	 */
	DIVIDEND_YEILD("yield"),

	ERROR("error")
	{
		@Override
		public String toString()
		{
			return "//error";
		}

		@Override
		public String getPath()
		{
			return "//error";
		}
	};

	private String tag;
	private String path = "";

	MarketQuotesResponseField(String tag)
	{
		this.tag = tag;
		path = "//quote/" + tag;
	}

	@Override
	public String toString()
	{
		return tag;
	}

	public String getPath()
	{
		return path;
	}
}
