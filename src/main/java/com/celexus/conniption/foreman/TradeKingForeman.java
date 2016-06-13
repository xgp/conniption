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

import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.model.OAuth1AccessToken;
import com.github.scribejava.core.model.OAuthRequest;
import com.github.scribejava.core.model.Token;
import com.github.scribejava.core.model.Verb;
import com.github.scribejava.core.oauth.OAuthService;
import com.github.scribejava.core.oauth.OAuth10aService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.celexus.conniption.foreman.util.TradekingAPI;
import com.celexus.conniption.foreman.util.builder.APIBuilder;

/**
 * A Helper to interact with the TradeKing API
 *
 * @author cam
 *
 */
public class TradeKingForeman implements Serializable {

    private static final long serialVersionUID = 7830844282343108561L;
    private OAuth1AccessToken accessToken;
    private OAuth10aService srv;
    private Logger log = LoggerFactory.getLogger(TradeKingForeman.class);

    public TradeKingForeman() {
    }

    private void connect() throws ForemanException {
        log.trace("Connecting to Tradeking");
	srv = new ServiceBuilder().apiKey(ForemanConstants.API_KEY.toString()).apiSecret(ForemanConstants.API_SECRET.toString()).build(new TradekingAPI());
        log.trace("\t ... Service built!");
        accessToken = new OAuth1AccessToken(ForemanConstants.ACCESS_TOKEN.toString(), ForemanConstants.ACCESS_TOKEN_SECRET.toString());
        log.trace("\t ... Access Token built!");
        log.trace("Connection Established");
    }

    public TKResponse makeAPICall(APIBuilder b) throws ForemanException {
        if (!isConnected()) {
            connect();
        }
        log.trace("Making an API Call");
        log.trace("\t ... Verb:" + b.getVerb());
        log.trace("\t ... Resource URL:" + b.getResourceURL());
        log.trace("\t ... Body:" + b.getBody());
        log.trace("\t ... Parameters:" + !b.getParameters().isEmpty());
        return sendRequest(makeRequest(b.getVerb(), b.getResourceURL(), b.getParameters(), b.getBody()));
    }

    public boolean hasOAuth() {
        return srv != null;
    }

    public boolean hasAccessToken() {
        return accessToken != null;
    }

    public boolean isConnected() {
        return hasOAuth() && hasAccessToken();
    }

    private OAuthRequest makeRequest(Verb verb, String resourceURL, Map<String, String> parameters, String payload) {
        OAuthRequest request = new OAuthRequest(verb, resourceURL, srv);
        for (Entry<String, String> entry : parameters.entrySet()) {
            request.addBodyParameter(entry.getKey(), entry.getValue());
        }
        if (payload != null) {
            request.addHeader("Content-Length", Integer.toString(payload.length()));
            request.addHeader("Content-Type", "text/xml");
            request.addPayload(payload);
        }
        srv.signRequest(accessToken, request);
        return request;
    }

    private TKResponse sendRequest(OAuthRequest request) {
        TKResponse response = new TKResponse(request);
        return response;
    }

}
