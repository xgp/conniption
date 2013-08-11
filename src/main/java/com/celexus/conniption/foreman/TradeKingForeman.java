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
package com.celexus.conniption.foreman;

import java.io.Serializable;
import java.util.Map;
import java.util.Map.Entry;

import org.scribe.builder.ServiceBuilder;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Request;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.oauth.OAuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.celexus.conniption.application.ApplicationException;
import com.celexus.conniption.application.CertificateInstallerApplication;
import com.celexus.conniption.foreman.util.TradekingAPI;
import com.celexus.conniption.foreman.util.builder.APIBuilder;

public class TradeKingForeman implements Serializable
{
	private static final long serialVersionUID = 7830844282343108561L;
	private Token accessToken;
	private OAuthService srv;
	private Logger log = LoggerFactory.getLogger(TradeKingForeman.class);

	public TradeKingForeman()
	{
	}

	private void connect() throws ForemanException
	{
		log.debug("Connecting to Tradeking");
		try
		{
			CertificateInstallerApplication.main(null);
		}
		catch (ApplicationException e)
		{
			throw new ForemanException("Could not install Certificates", e);
		}
		srv = new ServiceBuilder().provider(TradekingAPI.class).apiKey(ForemanConstants.API_KEY.toString()).apiSecret(ForemanConstants.API_SECRET.toString()).build();
		log.debug("\t ... Service built!");
		accessToken = new Token(ForemanConstants.ACCESS_TOKEN.toString(), ForemanConstants.ACCESS_TOKEN_SECRET.toString());
		log.debug("\t ... Access Token built!");
		log.debug("Connection Established");
	}

	public TKResponse makeAPICall(APIBuilder b) throws ForemanException
	{
		if (!this.isConnected())
		{
			this.connect();
		}
		log.trace("Making an API Call");
		log.trace("\t ... Verb:" + b.getVerb());
		log.trace("\t ... Resource URL:" + b.getResourceURL());
		log.trace("\t ... Body:" + b.getBody());
		log.trace("\t ... Parameters:" + !b.getParameters().isEmpty());
		return sendRequest(makeRequest(b.getVerb(), b.getResourceURL(), b.getParameters(), b.getBody()));
	}

	public boolean hasOAuth()
	{
		return this.srv != null;
	}

	public boolean hasAccessToken()
	{
		return this.accessToken != null;
	}

	public boolean isConnected()
	{
		return hasOAuth() && hasAccessToken();
	}

	private Request makeRequest(Verb verb, String resourceURL, Map<String, String> parameters, String payload)
	{
		OAuthRequest request = new OAuthRequest(verb, resourceURL);
		for (Entry<String, String> entry : parameters.entrySet())
		{
			request.addBodyParameter(entry.getKey(), entry.getValue());
		}
		if (payload != null)
		{
			request.addHeader("Content-Length", Integer.toString(payload.length()));
			request.addHeader("Content-Type", "text/xml");
			request.addPayload(payload);
		}
		srv.signRequest(accessToken, request);
		return request;
	}

	private TKResponse sendRequest(Request request)
	{
		TKResponse response = new TKResponse(request);
		return response;
	}

}
