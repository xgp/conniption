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
package com.celexus.conniption.model.util;

import java.io.Serializable;

public enum OrderPreviewField implements Serializable
{
	ESTIMATED_COMISSION("estcommission"),
	MARGIN_REQUIREMENT("marginrequirement"),
	TOTAL_COST("principal"),
	SEC_FEE("secfee"),
	WARNING("warningtext"),
	ERROR("/error");
	private String tag;
	OrderPreviewField(String tag)
	{
		this.tag = tag;
	}
	
	@Override
	public String toString()
	{
		return tag;
	}

	public String getPath()
	{
		return "/"+this.toString();
	}
}
