package com.celexus.application;

import java.io.IOException;

import oauth.signpost.OAuthConsumer;
import oauth.signpost.jetty.JettyOAuthConsumer;

import org.mortbay.io.Buffer;
import org.mortbay.jetty.client.ContentExchange;
import org.mortbay.jetty.client.HttpClient;

public class Streaming {

	  public static void main(String[] args) throws Exception {
		  /**
		   * 		srv = new ServiceBuilder().provider(TradekingAPI.class).apiKey("13q69FW0DfHjkEuZm5iVaQwPWDjt2cV2CujgqcLx").apiSecret("hljBbu3eZ9anqmsUTflS2XVp6JnZqKVcGZNSLzhv").build();
		accessToken = new Token("nkqjvLLtWP3QaSWMdn9aOQs6k6eVUPRY4ze0EVPw", "rV6kPCZNSkyKmW9DtvEozePxE2fBejxnkx1qtz2v");
		   */
	        String CONSUMER_KEY = "13q69FW0DfHjkEuZm5iVaQwPWDjt2cV2CujgqcLx";
	        String CONSUMER_SECRET = "hljBbu3eZ9anqmsUTflS2XVp6JnZqKVcGZNSLzhv";
	        String ACCESS_TOKEN = "nkqjvLLtWP3QaSWMdn9aOQs6k6eVUPRY4ze0EVPw";
	        String ACCESS_TOKEN_SECRET = "rV6kPCZNSkyKmW9DtvEozePxE2fBejxnkx1qtz2v";

	        // create a consumer object and configure it with the access
	        // token and token secret obtained from the service provider
	        OAuthConsumer consumer = new JettyOAuthConsumer(CONSUMER_KEY, CONSUMER_SECRET);
	        consumer.setTokenWithSecret(ACCESS_TOKEN, ACCESS_TOKEN_SECRET);

	        // create an HTTP request to a protected resource
	        ContentExchange request = new ContentExchange(true) {
	          // tell me what kind of response code we got
	            protected void onResponseComplete() throws IOException {
	                int status = getResponseStatus();
	                if (status == 200)
	                    System.out.println("Successfully connected");
	                else
	                    System.out.println("Error Code Received: " + status);
	            }

	            // print out any response data we get along the stream
	            protected void onResponseContent(Buffer data) {
	              System.out.println(data);
	            }
	        };

	        // setup the request
	        request.setMethod("GET");
	        request.setURL("https://stream.tradeking.com/v1/market/quotes.xml?symbols=F");

	        // sign the request
	        consumer.sign(request);

	        // send the request
	        HttpClient client = new HttpClient();
	        client.start();
	        client.send(request);
	        request.waitForDone();
	  }
	}