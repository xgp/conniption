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
package com.celexus.foreman.util.builder;

import java.util.HashMap;
import java.util.Map;

import org.scribe.model.Verb;

public abstract class APIBuilder
{
	protected Verb verb;
	protected Map<String, String> params = new HashMap<String, String>();
	protected String resourceURL;
	protected String body;
	protected boolean streaming;

	public Verb getVerb()
	{
		return verb;
	}

	public Map<String, String> getParameters()
	{
		return params;
	}

	public String getResourceURL()
	{
		return resourceURL;
	}

	public String getBody()
	{
		return body;
	}
	
	public boolean isStreaming()
	{
		return streaming;
	}

}
