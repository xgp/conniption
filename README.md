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

#### [MarketClock](https://github.com/Ccook/conniption/blob/master/src/main/java/com/celexus/model/MarketClock.java)

#### [MarketQuote](https://github.com/Ccook/conniption/blob/master/src/main/java/com/celexus/model/MarketQuote.java)

#### [MarketOrder](https://github.com/Ccook/conniption/blob/master/src/main/java/com/celexus/model/MarketOrder.java)


## Warnings



## License, Attribution, etc

