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
package com.celexus.model.util;

public enum AccountsField
{
	/**
	 * accounttype Holdings attribute for where asset as held, "1"= cash, "2"= margin long, "5"=margin short.
	 */
	ACCOUNT_TYPE("accounttype"),
	/**
	 * accountvalue Account value
	 */
	ACCOUNT_VALUE("accountvalue", "//accountbalance/"),
	/**
	 * accruedinterest Amount of any accrued interest on the account
	 */
	ACCRUED_INTEREST("accruedinterest", "//accountbalance/money/"),
	/**
	 * assetclass Holding asset class type
	 */
	ASSET_CLASS("assetclass"),
	/**
	 * cash cash
	 */
	CASH("cash", "//accountbalance/money/"),
	/**
	 * cashavailable cash available
	 */
	CASH_AVAILABLE("cashavailable", "//accountbalance/money/"),
	/**
	 * cashavailableforwithdrawal Cash available for withdrawal (cash & margin accounts only, n/a for retirement accounts)
	 */
	CASH_AVAILABLE_FOR_WITHDRAWL("cashavailableforwithdrawal"),
	/**
	 * cashbalance cash balance
	 */
	CASH_BALANCE("cashbalance"),
	/**
	 * cashmv Value of cash market value
	 */
	CASH_MARKET_VALUE("cashmv"),
	/**
	 * cfi Put or call code(FIXML)
	 */
	CFI("cfi"),
	/**
	 * change Holding asset change for the day
	 */
	ASSET_HOLDING_CHANGE("change"),
	/**
	 * costbasis Holding cost basis
	 */
	COST_BASIS("costbasis"),
	/**
	 * cusip Instrument cusip
	 */
	INTSTRUMENT_CUSIP("cusip"),
	/**
	 * desc Instrument description
	 */
	INSTRUMENT_DESCRIPTION("desc"),
	/**
	 * equitypercentage Percentage of equity (margin accounts only)
	 */
	EQUITY_PERCENTAGE("equitypercentage"),
	/**
	 * factor Instrument factor
	 */
	INSTRUMENT_FACTOR("factor"),
	/**
	 * fedcall Value of any fed call on account
	 */
	FED_CALL("fedcall", "//accountbalance/"),
	/**
	 * gainloss Holding gain/loss overall
	 */
	GAIN_LOSS_OVERALL("gainloss"),
	/**
	 * housecall Value of any house call
	 */
	HOUSE_CALL("housecall", "//accountbalance/"),
	/**
	 * lastprice Instrument last price
	 */
	LAST_PRICE("lastprice"),
	/**
	 * longoptions Long option market value
	 */
	LONG_OPTIONS("longoptions", "//accountbalance/securities/"),
	/**
	 * longstocks Long stock market value
	 */
	LONG_STOCKS("longstocks", "//accountbalance/securities/"),
	/**
	 * marginbalance Margin balance (- indicates debit balance, + indicates credit balance)
	 */
	MARGIN_BALANCE("marginbalance", "//accountbalance/money/"),
	/**
	 * marginmv Margin market value
	 */
	MARGIN_MARKET_VALUE("marginmv"),
	/**
	 * marketvalue Holding market value
	 */
	MARKET_VALUE("marketvalue"),
	/**
	 * marketvaluechange Holding market value change
	 */
	MARKET_VALUE_CHANGE("marketvaluechange"),
	/**
	 * matdt Instrument maturity date (FIXML)
	 */
	INSTRUMENT_MATURITY_DATE("matdt"),
	/**
	 * mmf Money market fund
	 */
	MONEY_MARKET_FUND("mmf", "//accountbalance/money/"),
	/**
	 * mmy Instrument maturity year/month (FIXML)
	 */
	INSTRUMENT_MATURITY_YEAR_MONTH("mmy"),
	/**
	 * mult Instrument multiplier
	 */
	INSTRUMENT_MULTIPLIER("mult"),
	/**
	 * openbuyvalue Open buy value
	 */
	OPEN_BUY_VALUE("openbuyvalue"),
	/**
	 * options Total option market value. Path: /response/accounts/accountsummary/accountbalance/securities/
	 */
	TOTAL_OPTIONS_MARKET_VALUE("options", "//accountbalance/securities/"),
	/**
	 * options Options buying power. Path: /response/accounts/accountsummary/accountbalance/buyingpower/
	 */
	OPTIONS_BUYING_POWER("options"),
	/**
	 * price Instrument price
	 */
	INSTRUMENT_PRICE("price"),
	/**
	 * purchaseprice Holding purchase price
	 */

	PURCHASE_PRICE("purchaseprice"),
	/**
	 * putcall put or call
	 */
	PUT_CALL("putcall"),
	/**
	 * qty Holding quantity
	 */
	HOLDING_QUANTITY("qty"),
	/**
	 * sectyp Instrument security type (FIXML)
	 */
	INSTRUMENT_SECURITY_TYPE("sectyp"),
	/**
	 * shortbalance short balance (credit for sell?)
	 */
	SHORT_BALANCE("shortbalance"),
	/**
	 * shortmv short market value
	 */
	SHORT_MARKET_VALUE("shortmv"),
	/**
	 * shortoptions Short option market value
	 */
	SHORT_OPTIONS_MARKET_VALUE("shortoptions", "//accountbalance/securities/"),
	/**
	 * shortstocks Short stock market value
	 */
	SHORT_STOCKS_MARKET_VALUE("shortstocks", "//accountbalance/securities/"),
	/**
	 * sodoptions Start of day options buying power
	 */
	START_OF_DAY_OPTIONS_BUYING_POWER("sodoptions"),
	/**
	 * sodstock Start of day stock buying power
	 */
	START_OF_DAY_STOCK_BUYING_POWER("sodstock"),
	/**
	 * stock Stock buying power
	 */
	STOCK_BUYING_POWER("stock"),
	/**
	 * stocks Total stock market value
	 */
	STOCK_MARKET_VALUE("stocks", "//accountbalance/securities/"),
	/**
	 * strkpx Instrument strike price (FIXML)
	 */
	INSTRUMENT_STRIKE_PRICE("strkpx"),
	/**
	 * sym Instrument underlying symbol (FIXML)
	 */
	INSTRUMENT_UNDERLYING_SYMBOL("sym"),
	/**
	 * symbol Holding underlying symbol
	 */
	HOLDING_UNDERLYING_SYMBOL("symbol"),
	/**
	 * total Total cash balance. Path: /response/accounts/accountsummary/accountbalance/money/
	 */
	TOTAL_CASH_BALANCE("total", "//accountbalance/money/"),
	/**
	 * total Total market value (stock & option). Path: /response/accounts/accountsummary/accountbalance/securities/
	 */
	TOTAL_MARKET_VALUE("total", "//accountbalance/securities/"),
	/**
	 * totalsecurities Total account market value
	 */
	TOTAL_SECURITIES_MARKET_VALUE("totalsecurities"),
	/**
	 * uncleareddeposits uncleared deposits
	 */
	UNCLEARED_DEPOSITS("uncleareddeposits", "//accountbalance/money/"),
	/**
	 * unsettledfunds unsettled funds
	 */
	UNSETTLED_FUNDS("unsettledfunds", "//accountbalance/money/"),
	/**
	 * yield Yield
	 */
	YIELD("yield", "//accountbalance/money/"),
	/**
	 * account Account number
	 */
	ACCOUNT_NUMBER("account", "//accountbalance/"),
	
	ERROR("error","//");

	private String abbrev;
	private String path;
	private static final String REALM = "//accountbalance";

	AccountsField(String abbrev, String... path)
	{
		this.abbrev = abbrev;
		if (path.length >= 1)
		{
			this.path = path[0];
		}
	}

	@Override
	public String toString()
	{
		return abbrev;
	}

	public String getPath()
	{
		if (path != null)
		{
			return path + abbrev;
		}
		return path;
	}

	public static String getRealm()
	{
		return REALM;
	}

	public static AccountsField getFieldFromAbbreviation(String a)
	{
		for (AccountsField field : AccountsField.values())
		{
			if (field.toString().equals(a))
			{
				return field;
			}
		}
		return null;
	}

}
