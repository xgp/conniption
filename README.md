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

To avoid putting these OAuth keys in the code base, and do avoid config files. [TradeKingForeman](https://github.com/Ccook/conniption/blob/master/src/main/java/com/celexus/foreman/TradeKingForeman.java) uses [ForemanConstants](https://github.com/Ccook/conniption/blob/master/src/main/java/com/celexus/foreman/ForemanConstants.java) convience methods.
They all access System environment variables (via [System.getEnv()](http://docs.oracle.com/javase/1.5.0/docs/api/java/lang/System.html#getenv%28java.lang.String%29)). The following lines should be added to your environment variables.

### Linux

Put these lines in /etc/environment.

    API_KEY=<YOUR API KEY HERE>
    API_SECRET=<YOUR API SECRET HERE>
    ACCESS_TOKEN=<YOUR ACCESS TOKEN HERE>
    ACCESS_TOKEN_SECRET=<YOUR SECRET ACCESS TOKEN HERE>


### Mac

Put these lines in /etc/launchd.conf

    setenv API_KEY <YOUR API KEY HERE>
    setenv API_SECRET <YOUR API SECRET HERE>
    setenv ACCESS_TOKEN <YOUR ACCESS TOKEN HERE>
    setenv ACCESS_TOKEN_SECRET <YOUR SECRET ACCESS TOKEN HERE>
    
    
Restart your computer.

## Usage

If you're just here to use conniption, there are really only a couple classes you need to know about

#### [Account](https://github.com/Ccook/conniption/blob/master/src/main/java/com/celexus/model/Account.java)

Access to your TradekingAccount. You'll notice there are two constructors. One which takes your ID as a parameter, one without.
The one without assumes you only have one account attached. You can access the fields returned by using ***hasField()*** and ***getField()***

Example:

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

#### [MarketOrder](https://github.com/Ccook/conniption/blob/master/src/main/java/com/celexus/model/MarketOrder.java)


## Warnings



## License, Attribution, etc

