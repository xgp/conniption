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
package com.celexus.foreman.util;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.dom4j.tree.DefaultElement;

import com.celexus.model.util.AccountsField;
import com.celexus.model.util.MarketClockField;
import com.celexus.model.util.MarketQuotesResponseField;
import com.celexus.model.util.OrderField;
import com.celexus.model.util.OrderPreviewField;

public class XMLHandler
{

	public XMLHandler()
	{
	}

	public Map<AccountsField, String> parseAccount(String response) throws UtilityException
	{
		Document doc = getDocument(response);
		return getAccountPaths(doc);
	}

	public Map<MarketClockField, String> parseMarketClock(String response) throws UtilityException
	{
		Document doc = getDocument(response);
		return getMarketClockPaths(doc);
	}

	public Map<MarketQuotesResponseField, String> parseMarketQuote(String response) throws UtilityException
	{
		Document doc = getDocument(response);
		return getMarketQuotePaths(doc);
	}

	public Map<OrderPreviewField, String> parseMarketOrderPreview(String response) throws UtilityException
	{
		Document doc = getDocument(response);
		return getMarketPreviewOrderPaths(doc);
	}

	public Map<OrderField, String> parseMarketOrder(String response) throws UtilityException
	{
		Document doc = getDocument(response);
		return getMarketOrderPaths(doc);
	}

	@SuppressWarnings("unchecked")
	private Map<OrderField, String> getMarketOrderPaths(Document doc)
	{
		Map<OrderField, String> toReturn = new HashMap<OrderField, String>();
		for (OrderField f : OrderField.values())
		{
			String path = f.getPath();
			if (path != null)
			{
				List<DefaultElement> list = doc.selectNodes(path);

				for (Iterator<DefaultElement> iter = list.iterator(); iter.hasNext();)
				{
					DefaultElement attribute = iter.next();
					String url = attribute.getText();
					toReturn.put(f, url);
				}
			}
		}
		return toReturn;
	}

	@SuppressWarnings("unchecked")
	private Map<OrderPreviewField, String> getMarketPreviewOrderPaths(Document doc) throws UtilityException
	{
		Map<OrderPreviewField, String> toReturn = new HashMap<OrderPreviewField, String>();
		for (OrderPreviewField f : OrderPreviewField.values())
		{
			String path = f.getPath();
			if (f.equals(OrderPreviewField.ERROR))
			{
				if (path != null)
				{
					List<DefaultElement> list = doc.selectNodes(path);

					for (Iterator<DefaultElement> iter = list.iterator(); iter.hasNext();)
					{
						DefaultElement attribute = iter.next();
						String url = attribute.getText();
						throw new UtilityException(url);
					}

				}
			}
			if (path != null)
			{
				List<DefaultElement> list = doc.selectNodes(path);

				for (Iterator<DefaultElement> iter = list.iterator(); iter.hasNext();)
				{
					DefaultElement attribute = iter.next();
					String url = attribute.getText();
					toReturn.put(f, url);
				}

			}
		}

		return toReturn;
	}

	@SuppressWarnings("unchecked")
	private Map<AccountsField, String> getAccountPaths(Document doc) throws UtilityException
	{
		Map<AccountsField, String> toReturn = new HashMap<AccountsField, String>();
		for (AccountsField f : AccountsField.values())
		{
			String path = f.getPath();
			if (f.equals(AccountsField.ERROR))
			{
				if (path != null)
				{
					List<DefaultElement> list = doc.selectNodes(path);

					for (Iterator<DefaultElement> iter = list.iterator(); iter.hasNext();)
					{
						DefaultElement attribute = iter.next();
						String url = attribute.getText();
						throw new UtilityException(url);
					}

				}
			}
			if (path != null)
			{
				List<DefaultElement> list = doc.selectNodes(path);

				for (Iterator<DefaultElement> iter = list.iterator(); iter.hasNext();)
				{
					DefaultElement attribute = iter.next();
					String url = attribute.getText();
					toReturn.put(f, url);
				}

			}
		}

		return toReturn;

	}

	@SuppressWarnings("unchecked")
	private Map<MarketQuotesResponseField, String> getMarketQuotePaths(Document doc) throws UtilityException
	{
		Map<MarketQuotesResponseField, String> toReturn = new HashMap<MarketQuotesResponseField, String>();
		for (MarketQuotesResponseField f : MarketQuotesResponseField.values())
		{
			String path = f.getPath();
			if (f.equals(MarketQuotesResponseField.ERROR))
			{
				if (path != null)
				{
					List<DefaultElement> list = doc.selectNodes(path);

					for (Iterator<DefaultElement> iter = list.iterator(); iter.hasNext();)
					{
						DefaultElement attribute = iter.next();
						String url = attribute.getText();
						throw new UtilityException(url);
					}

				}
			}
			if (path != null)
			{
				List<DefaultElement> list = doc.selectNodes(path);

				for (Iterator<DefaultElement> iter = list.iterator(); iter.hasNext();)
				{
					DefaultElement attribute = iter.next();
					String url = attribute.getText();
					toReturn.put(f, url);
				}

			}
		}
		return toReturn;
	}

	@SuppressWarnings("unchecked")
	public Map<MarketClockField, String> getMarketClockPaths(Document doc) throws UtilityException
	{
		Map<MarketClockField, String> toReturn = new HashMap<MarketClockField, String>();
		for (MarketClockField f : MarketClockField.values())
		{
			String path = f.getPath();
			if (f.equals(MarketClockField.ERROR))
			{
				if (path != null)
				{
					List<DefaultElement> list = doc.selectNodes(path);

					for (Iterator<DefaultElement> iter = list.iterator(); iter.hasNext();)
					{
						DefaultElement attribute = iter.next();
						String url = attribute.getText();
						throw new UtilityException(url);
					}

				}
			}
			if (path != null)
			{
				List<DefaultElement> list = doc.selectNodes(path);

				for (Iterator<DefaultElement> iter = list.iterator(); iter.hasNext();)
				{
					DefaultElement attribute = iter.next();
					String url = attribute.getText();
					toReturn.put(f, url);
				}

			}
		}

		return toReturn;
	}

	private Document getDocument(String response) throws UtilityException
	{
		SAXReader reader = new SAXReader();
		Document document;
		try
		{
			document = reader.read(new ByteArrayInputStream(response.getBytes()));
		}
		catch (DocumentException e)
		{
			throw new UtilityException("Parse response failed", e);
		}
		return document;
	}
}
