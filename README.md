Conniption
==========

The missing TradeKing API for Java.

## Getting an API Key from TradeKing

* [Visit the Tradeking Developers Website](https://developers.tradeking.com/applications/)  
  * Fill in their info and you will get 4 important values needed for [OAuth](http://oauth.net/)
   * An API Key
   * An API Secret Key
   * An Access Token
   * A Secret Access Token
* [Go over the TradeKing API Docs](https://developers.tradeking.com/documentation/getting-started) 

## Installing

To avoid putting these OAuth keys in the code base, and to avoid config files. [TradeKingForeman](https://github.com/Ccook/conniption/blob/master/src/main/java/com/celexus/foreman/TradeKingForeman.java) uses [ForemanConstants](https://github.com/Ccook/conniption/blob/master/src/main/java/com/celexus/foreman/ForemanConstants.java) convience methods.
They all access System environment variables (via [System.getEnv()](http://docs.oracle.com/javase/1.5.0/docs/api/java/lang/System.html#getenv%28java.lang.String%29)). The following lines should be added to your environment variables.

### Linux

Put these lines in */etc/environment*.

    API_KEY=<YOUR API KEY HERE>
    API_SECRET=<YOUR API SECRET HERE>
    ACCESS_TOKEN=<YOUR ACCESS TOKEN HERE>
    ACCESS_TOKEN_SECRET=<YOUR SECRET ACCESS TOKEN HERE>


### Mac

Put these lines in */etc/launchd.conf*

    setenv API_KEY <YOUR API KEY HERE>
    setenv API_SECRET <YOUR API SECRET HERE>
    setenv ACCESS_TOKEN <YOUR ACCESS TOKEN HERE>
    setenv ACCESS_TOKEN_SECRET <YOUR SECRET ACCESS TOKEN HERE>
    
    
Restart your computer.

Use the maven clean install directive to compile and make sure everythng works. I highly recommend you do not use -DskipTests. The tests will check your connection to TradeKing

## Usage

If you're just here to use conniption, there are really only a couple classes you need to know about

#### [Account](https://github.com/Ccook/conniption/blob/master/src/main/java/com/celexus/model/Account.java)

Access to your TradekingAccount. You'll notice there are two constructors. One which takes your ID as a parameter, one without.
The one without assumes you only have one account attached. You can access the fields returned by using ***hasField()*** and ***getField()***


	Account acc = new Account();
	for(AccountsField f: AccountsField.values())
	{
		System.out.println(f+" "+acc.getField(f));
	}
      
will yield 

    ACCOUNT_TYPE null
    ACCOUNT_VALUE 0.0
    ACCRUED_INTEREST 0.0
    ASSET_CLASS null
    CASH 10.0
    CASH_AVAILABLE 0.0
    CASH_AVAILABLE_FOR_WITHDRAWL null
    CASH_BALANCE null
    CASH_MARKET_VALUE null
    CFI null
    ASSET_HOLDING_CHANGE null
    COST_BASIS null
    INTSTRUMENT_CUSIP null
    INSTRUMENT_DESCRIPTION null
    EQUITY_PERCENTAGE null
    INSTRUMENT_FACTOR null
    FED_CALL 0.0
    GAIN_LOSS_OVERALL null
    HOUSE_CALL 0.0
    LAST_PRICE null
    LONG_OPTIONS 0.0
    LONG_STOCKS 0.0
    MARGIN_BALANCE 0.0
    MARGIN_MARKET_VALUE null
    MARKET_VALUE null
    MARKET_VALUE_CHANGE null
    INSTRUMENT_MATURITY_DATE null
    MONEY_MARKET_FUND 0.0
    INSTRUMENT_MATURITY_YEAR_MONTH null
    INSTRUMENT_MULTIPLIER null
    OPEN_BUY_VALUE null
    TOTAL_OPTIONS_MARKET_VALUE 0.0
    OPTIONS_BUYING_POWER null
    INSTRUMENT_PRICE null
    PURCHASE_PRICE null
    PUT_CALL null
    HOLDING_QUANTITY null
    INSTRUMENT_SECURITY_TYPE null
    SHORT_BALANCE null
    SHORT_MARKET_VALUE null
    SHORT_OPTIONS_MARKET_VALUE 0.0
    SHORT_STOCKS_MARKET_VALUE 0.0
    START_OF_DAY_OPTIONS_BUYING_POWER null
    START_OF_DAY_STOCK_BUYING_POWER null
    STOCK_BUYING_POWER null
    STOCK_MARKET_VALUE 0.0
    INSTRUMENT_STRIKE_PRICE null
    INSTRUMENT_UNDERLYING_SYMBOL null
    HOLDING_UNDERLYING_SYMBOL null
    TOTAL_CASH_BALANCE 10.0
    TOTAL_MARKET_VALUE 0.0
    TOTAL_SECURITIES_MARKET_VALUE null
    UNCLEARED_DEPOSITS 10.0
    UNSETTLED_FUNDS 0.0
    YIELD 0.0
    ACCOUNT_NUMBER 12345678

You can learn more about these fields [here](https://developers.tradeking.com/documentation/accounts-get).


#### [MarketClock](https://github.com/Ccook/conniption/blob/master/src/main/java/com/celexus/model/MarketClock.java)

Access to the Market's clock. Use ***hasField()*** and ***getField*** to access these values.
  
	MarketClock clock = new MarketClock();
	for(MarketClockField f: MarketClockField.values())
	{
		if(clock.hasField(f))
		{
        		System.out.println("\t"+f.name()+"="+clock.getField(f));
		}
	}

will yield

    DATE=2013-07-29 23:05:46.773000
    CURRENT=closed
    NEXT=pre
    CHANGE_AT=08:00:00
    MESSAGE=Market is open Monday through Friday 9:30AM to 4:00PM EST
    UNIX_TIME=1375153546

#### [MarketQuote](https://github.com/Ccook/conniption/blob/master/src/main/java/com/celexus/model/MarketQuote.java)

Get information on stocks. 

	MarketQuote quote = new MarketQuote("SIRI",false);
	for(MarketQuotesResponseField f: MarketQuotesResponseField.values())
	{
		if(quote.hasField(f))
		{
			System.out.println(f.name()+"="+quote.getField(f));
		}
	}

will yield

	AVG_DAILY_PRICE_100_DAYS=3.3229
	AVG_DAILY_PRICE_200_DAYS=3.1507
	AVG_DAILY_PRICE_50_DAYS=3.4801
	AVG_DAILY_VOLUME_21_DAYS=54831360
	AVG_DAILY_VOLUME_30_DAYS=60907020
	AVG_DAILY_VOLUME_90_DAYS=59717030
	ASK_PRICE=3.7600
	ASK_TIME=19:59
	ASK_SIZE=122
	PRECISION=4
	BETA_VOLATILITY=1.064
	BID_PRICE=3.7300
	BID_TIME=19:59
	BID_SIZE=114
	BID_TICK_DIRECTION=1
	DAY_CHANGE=0.0050
	CHANGE_DIRECTION=d
	CHANGE_PLAIN_TEXT=0.0050
	PREVIOUS_CLOSE=3.7550
	CUSIP=82967N10
	DATE_OF_LAST_TRADE=2013-07-29
	DATE_TIME=2013-07-29T15:59:00-04:00
	DIVIDEND=0.0500
	DIVIDEND_EX_DATE=20121214
	DIVIDEND_PAY_DATE=20121228
	DOLLAR_VALUE=100453671
	EARNINGS_PER_SHARE=0.53
	EXCHANGE_CODE=NASD
	EXCHANGE_DESCRIPTION=NASDAQ
	HIGH_TRADE_PRICE=3.7900
	INDICATED_ANNUAL_DIVIDEND=0
	VOLUME_LAST_TRADE=733401
	LAST_TRADE_PRICE=3.7500
	LOW_TRADE_PRICE=3.7100
	COMPANY_NAME=SIRIUS XM RADIO INC
	SECURITY_HAS_OPTIONS=1
	OPEN_TRADE_PRICE=3.7400
	PERCENT_CHANGE=0.133 %
	PERCENT_CHANGE_DIRECTION=d
	PRIOR_DAY_CLOSE=3.7550
	PRICE_EARNINGS_RATIO=7.08
	PRIOR_DAY_HIGH=3.8100
	PRIOR_DAY_LOW=3.7200
	PRIOR_DAY_OPEN=3.7500
	PRIOR_AVG_DAILY_PRICE_100_DAYS=3.3174
	PRIOR_AVG_DAILY_PRICE_200_DAYS=3.1464
	PRIOR_AVG_DAILY_PRICE_50_DAYS=3.4739
	PRIOR_DATE=2013-07-26
	BOOK_VALUE_PRICE=6.410
	PRIOR_DAY_CHANGE=-0.0250
	PRIOR_DAY_TOTAL_VOLUME=41869649
	CONDITION_CODE=82
	SECURITY_CLASS=0
	TRADING_SESSION=regular
	SHARES_OUTSTANDING=6,379,260,000
	SYMBOL=SIRI
	TRADE_CONDITION_CODE=R
	TIMESTAMP=1375127940
	NUMBER_OF_TRADES=31285
	TICK_DIRECTION=d
	TICK_TREND=deeeudeued
	CULUMLATIVE_VOLUME=34194766
	ONE_YEAR_VOLATILITY=0.275102
	VOLUME_WEIGHT_AVG_PRICE=3.7478
	YEAR_HIGH=3.8100
	YEAR_HIGH_DATE=20130726
	YEAR_LOW=2.0800
	YEAR_LOW_DATE=20120726

#### [MarketOrder](https://github.com/Ccook/conniption/blob/master/src/main/java/com/celexus/model/MarketOrder.java)

You'll need a good understanding of how to use the [FIXMLBuilder](https://github.com/Ccook/conniption/blob/master/src/test/java/com/celexus/model/util/fixml/FIXMLBuilderTest.java), which uses FIXML to post orders. If you want to validate your order, use MarketOrderPreview instead.

		FIXMLBuilder builder = new FIXMLBuilder("12345678");
		builder.timeInForce(TimeInForceField.DAY_ORDER);
			.symbol("OCQLF");
			.priceType(PriceType.LIMIT);
			.securityType(SecurityType.STOCK);
			.quantity(1);
			.executionPrice(.01);
			.side(MarketSideField.BUY);
		
		MarketPreviewOrder order = new MarketPreviewOrder("12345678", builder);
		for(OrderPreviewField f: OrderPreviewField.values())
		{
			if(order.hasField(f))
			{
				String value = order.getField(f);
				System.out.println(f+" "+value);
			}
		}

## Warnings

Conniption assumes the most simpliest of Accounts. Don't use if you're doing complex shit. I also haven't implemented options functionality yet. Use at your own risk.

Streaming GET/POSTs are a work in progress. Assume broken for now.
## License, Attribution, etc


Conniption is licensed under the Apache License, version 2. It is in no way associated with TradeKing or TradeKing Group, Inc.

Please read TradeKing's documentation carefully! Use only as they suggest.


I use [scribe-java](https://github.com/fernandezpablo85/scribe-java) for OAuth. It's an awesome project. I recommend you check it out.


![Powered by TradeKing](https://developers.tradeking.com/images/logos/PB-TK-small-Blue.gif)
