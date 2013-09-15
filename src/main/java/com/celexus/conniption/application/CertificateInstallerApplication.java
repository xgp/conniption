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
package com.celexus.conniption.application;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Installs a dummy TrustManager. This can be rather dangerous, but if you're having keytool/certificate exceptions This will solve it.
 * 
 * @author cam
 * 
 */
public class CertificateInstallerApplication
{
	private static Logger log = LoggerFactory.getLogger(CertificateInstallerApplication.class);

	public static void main(String[] args) throws ApplicationException
	{
		new CertificateInstallerApplication();
	}

	private CertificateInstallerApplication() throws ApplicationException, com.celexus.conniption.application.ApplicationException
	{
		TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager()
		{

			public java.security.cert.X509Certificate[] getAcceptedIssuers()
			{
				return null;
			}

			public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType)
			{
			}

			public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType)
			{
			}
		} };

		// Install the all-trusting trust manager
		try
		{
			SSLContext sc = SSLContext.getInstance("SSL");
			log.info("Installing Certificates...");
			sc.init(null, trustAllCerts, new java.security.SecureRandom());
			HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
			log.info("Done.");
		}
		catch (Exception e)
		{
			throw new ApplicationException(e);
		}
	}

}
