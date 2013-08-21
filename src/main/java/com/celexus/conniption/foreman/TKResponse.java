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

import org.scribe.model.Request;
import org.scribe.model.Response;

public class TKResponse implements Serializable
{
	private static final long serialVersionUID = 1626169989303557890L;
	private String response = "";
	private int rateLimitUsed = 0;
	private long rateLimitExpire = 0;
	private int rateLimitTotal = 0;
	private int rateLimitRemaining = 0;

	public TKResponse(Request req)
	{
		Response response = req.send();
		String limitUsed = response.getHeader("X-RateLimit-Used");
		String limitExpire = response.getHeader("X-RateLimit-Expire");
		String limitTotal = response.getHeader("X-RateLimit-Limit");
		String limitRemain = response.getHeader("X-RateLimit-Remaining");
		if (limitUsed != null)
		{
			rateLimitUsed = Integer.parseInt(limitUsed);
		}
		if (limitExpire != null)
		{
			rateLimitExpire = Long.parseLong(limitExpire);
		}
		if (limitTotal != null)
		{
			rateLimitTotal = Integer.parseInt(limitTotal);
		}
		if (limitRemain != null)
		{
			rateLimitRemaining = Integer.parseInt(limitRemain);
		}
		this.response = response.getBody();
	}

	public TKResponse(String req, Integer... limits)
	{
		this.response = req;
	}

	public int getCallsUsed()
	{
		return rateLimitUsed;
	}

	public long getRateLimitExpiration()
	{
		return rateLimitExpire;
	}

	public int getTotalCallsAllowed()
	{
		return rateLimitTotal;
	}

	public int getCallsRemaining()
	{
		return rateLimitRemaining;
	}

	@Override
	public String toString()
	{
		return response;
	}
}
