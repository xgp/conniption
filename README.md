### NOTICE
Fork of Ccook's [Conniption](https://github.com/Ccook/conniption) project. This is now significantly departed. We now use xjc to automatically build Java classes for the model with [XSD](https://github.com/Ccook/conniption/blob/master/conniption-model/src/main/xsd/) built by hand from TradeKing's XML examples. Full FIXML parsing is also now supported using Java classes built from the [FIX Protocol](www.fixprotocol.org/) [FIXML](https://github.com/xgp/fixml) schemas.

Conniption
==========

The missing TradeKing API for Java.

## Getting an API Key from TradeKing

* [Visit the TradeKing Developers Website](https://developers.tradeking.com/applications/)  
* Fill in their info and you will get 4 important values needed for [OAuth](http://oauth.net/)
    * An API Key
    * An API Secret Key
    * An Access Token
    * A Secret Access Token
* [Go over the TradeKing API Docs](https://developers.tradeking.com/documentation/getting-started) 

## Installing

Keys and tokens given to you by TradeKing can be stored as environment variables (via System.getEnv()) or as system properties (via System.getProperty()). System properties take precedence.

### Keys

    TK_ACCOUNT_NO
    API_KEY
    API_SECRET
    ACCESS_TOKEN
    ACCESS_TOKEN_SECRET

For environment variables, put these lines in */etc/environment* or */etc/profile* (Linux) or */etc/launchd.conf* (Mac, requires restart).

## Building from souurce

Use the maven clean install directive to compile and make sure everythng works. I highly recommend you do not use -DskipTests. The tests will check your connection to TradeKing

## Maven 

```xml
<dependency>
    <groupId>com.celexus</groupId>
    <artifactId>conniption</artifactId>
    <version>1.1.0</version>
</dependency>
```

## Usage

#### [TradeKing](https://github.com/Ccook/conniption/blob/master/src/main/java/com/celexus/conniption/api/TradeKing.java)

This is the main entry point to using the API. The other classes you should care about are all in [model](https://github.com/Ccook/conniption/blob/master/connption-model/). Usage is pretty straightforward:

```java
TradeKing tk = new TradeKing(new TradeKingForeman());

// get the market clock https://developers.tradeking.com/documentation/market-clock-get
ClockResponse c = tk.clock();

// get your account https://developers.tradeking.com/documentation/accounts-get
AccountsResponse a = tk.accounts();

// get some market quotes https://developers.tradeking.com/documentation/market-ext-quotes-get-post
QuotesResponse q = tk.quotes("TWTR", "FB");

// stream market quotes https://developers.tradeking.com/documentation/streaming-market-quotes-get-post
Future f = tk.quotes(new StreamHandler<Quote>() {
    public void handle(Quote quote) {
            System.out.println(quote.toString());
        }
    }, "TWTR", "FB");

// place a non-executing, preview order
FIXMLBuilder builder = new FIXMLBuilder()
    .id(ForemanConstants.TK_ACCOUNT_NO.toString())
    .timeInForce(TimeInForceField.DAY_ORDER)
    .symbol("TWTR")
    .priceType(PriceType.LIMIT)
    .securityType(SecurityType.STOCK)
    .quantity(1)
    .executionPrice(18.01)
    .side(MarketSideField.BUY);
OrderResponse p = tk.preview(ForemanConstants.TK_ACCOUNT_NO, builder.build().toString());

// place a real order
OrderResponse o = tk.order(ForemanConstants.TK_ACCOUNT_NO, builder.build().toString());

// check the status of your orders
OrdersResponse os = tk.orders(ForemanConstants.TK_ACCOUNT_NO);
```
## Warnings

Conniption assumes the most simpliest of Accounts. Don't use if you're doing complex shit. I also haven't implemented options functionality yet. Use at your own risk.

## License, Attribution, etc

Conniption is licensed under the Apache License, version 2. It is in no way associated with TradeKing or TradeKing Group, Inc.

Please read TradeKing's documentation carefully! Use only as they suggest.
