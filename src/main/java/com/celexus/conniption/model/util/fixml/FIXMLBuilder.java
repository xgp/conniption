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
package com.celexus.conniption.model.util.fixml;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.celexus.conniption.foreman.util.UtilityException;

public class FIXMLBuilder implements Serializable
{
	private static final long serialVersionUID = 7606325661660023305L;
	private Logger log = LoggerFactory.getLogger(FIXMLBuilder.class);
	private String id;
	private String symbol;
	private int quantity = 0;
	private TimeInForceField timeInForce;
	private PriceType priceType;
	private SecurityType securityType;
	private MarketSideField side;
	private double executionPrice = 0;
	private double offset = 0;
	private Percentage percentage;
	private double stop = 0;

	public FIXMLBuilder(String id)
	{
		this.id = id;
	}

	public FIXMLBuilder symbol(String sym)
	{
		this.symbol = sym;
		return this;
	}

	public FIXMLBuilder quantity(int quantity)
	{
		this.quantity = quantity;
		return this;
	}

	public FIXMLBuilder timeInForce(TimeInForceField f)
	{
		this.timeInForce = f;
		return this;
	}

	public FIXMLBuilder priceType(PriceType type)
	{
		this.priceType = type;
		return this;
	}

	public FIXMLBuilder securityType(SecurityType type)
	{
		this.securityType = type;
		return this;
	}

	public FIXMLBuilder side(MarketSideField f)
	{
		this.side = f;
		return this;
	}

	public FIXMLBuilder executionPrice(double d)
	{
		this.executionPrice = d;
		return this;
	}

	public FIXMLBuilder executionPrice(double stop, double limit)
	{
		this.stop = stop;
		this.executionPrice = limit;
		return this;
	}

	public FIXMLBuilder offset(double d)
	{
		this.offset = d;
		return this;
	}

	public FIXMLBuilder offset(Percentage percentage)
	{
		this.percentage = percentage;
		return this;
	}

	public FIXML build() throws UtilityException
	{
		verify(side);
		verify(timeInForce);
		verify(symbol);
		verify(priceType);
		verify(quantity);
		verify(securityType);
		switch (side)
		{
		case BUY:
			if (executionPrice == 0 && offset == 0 && percentage == null)
			{
				return buy(id, symbol, quantity, timeInForce, priceType, securityType);
			}
			else if (offset != 0)
			{
				verify(offset);
				return buyAtOffset(id, symbol, quantity, timeInForce, priceType, securityType, offset);
			}
			else if (percentage != null)
			{
				verify(percentage);
				return buyAtOffset(id, symbol, quantity, timeInForce, priceType, securityType, percentage);
			}
			else
			{
				verify(executionPrice);
				return buyAtPrice(id, symbol, quantity, timeInForce, priceType, securityType, executionPrice, stop);
			}

		case SELL:
			if (executionPrice == 0 && offset == 0 && percentage == null)
			{
				return sell(id, symbol, quantity, timeInForce, priceType, securityType);
			}
			else if (offset != 0)
			{
				verify(offset);
				return sellAtOffset(id, symbol, quantity, timeInForce, priceType, securityType, offset);
			}
			else if (percentage != null)
			{
				verify(percentage);
				return sellAtOffset(id, symbol, quantity, timeInForce, priceType, securityType, percentage);
			}
			else
			{
				verify(executionPrice);
				return sellAtPrice(id, symbol, quantity, timeInForce, priceType, securityType, executionPrice, stop);
			}
		case BUY_TO_COVER:
			if (executionPrice == 0 && offset == 0 && percentage == null)
			{
				return buyToCover(id, symbol, quantity, timeInForce, priceType, securityType);
			}
			else if (offset != 0)
			{
				verify(offset);
				return buyToCoverAtOffset(id, symbol, quantity, timeInForce, priceType, securityType, offset);
			}
			else if (percentage != null)
			{
				verify(percentage);
				return buyToCoverAtOffset(id, symbol, quantity, timeInForce, priceType, securityType, percentage);
			}
			else
			{
				verify(executionPrice);
				return buyToCoverAtPrice(id, symbol, quantity, timeInForce, priceType, securityType, executionPrice, stop);
			}
		case SELL_SHORT:
			if (executionPrice == 0 && offset == 0 && percentage == null)
			{
				return sellShort(id, symbol, quantity, timeInForce, priceType, securityType);
			}
			else if (offset != 0)
			{
				verify(offset);
				return sellShortAtOffset(id, symbol, quantity, timeInForce, priceType, securityType, offset);
			}
			else if (percentage != null)
			{
				verify(percentage);
				return sellShortAtOffset(id, symbol, quantity, timeInForce, priceType, securityType, percentage);
			}
			else
			{
				verify(executionPrice);
				return sellShortAtPrice(id, symbol, quantity, timeInForce, priceType, securityType, executionPrice, stop);
			}
		default:
			break;
		}
		return null;
	}

	private void verify(Object obj) throws UtilityException
	{
		if (obj == null)
		{
			throw new UtilityException("Undefined part");
		}

	}

	private void verify(int integer) throws UtilityException
	{
		if (integer <= 0)
		{
			throw new UtilityException("Quantity invalid." + integer);
		}
	}

	private void verify(double d) throws UtilityException
	{
		if (d == 0)
		{
			throw new UtilityException("Price invalid." + d);
		}
	}

	public static FIXML buy(String id, String sym, int quantity, TimeInForceField tinf, PriceType type, SecurityType sectype)
	{
		return new FIXML(FIXMLBuilder.createSimpleOrder(id, sym, quantity, tinf, type, sectype, MarketSideField.BUY));
	}

	private FIXML buyAtPrice(String id, String sym, int quantity, TimeInForceField tinf, PriceType type, SecurityType sectype, double executionPrice, double stop)
	{
		return new FIXML(FIXMLBuilder.createOrderAtExecution(id, sym, quantity, tinf, type, sectype, MarketSideField.BUY, executionPrice, stop));
	}

	private FIXML buyAtOffset(String id2, String symbol2, int quantity2, TimeInForceField timeInForce2, PriceType priceType2, SecurityType securityType2, Percentage offset)
	{
		return new FIXML(FIXMLBuilder.createOrderAtOffset(id, symbol, quantity, timeInForce, priceType, securityType, MarketSideField.BUY, offset));
	}

	private FIXML buyAtOffset(String id2, String symbol2, int quantity2, TimeInForceField timeInForce2, PriceType priceType2, SecurityType securityType2, double offset)
	{
		return new FIXML(FIXMLBuilder.createOrderAtOffset(id, symbol, quantity, timeInForce, priceType, securityType, MarketSideField.BUY, offset));
	}

	public static FIXML sell(String id, String sym, int quantity, TimeInForceField tinf, PriceType type, SecurityType sectype)
	{
		return new FIXML(FIXMLBuilder.createSimpleOrder(id, sym, quantity, tinf, type, sectype, MarketSideField.SELL));
	}

	private FIXML sellAtPrice(String id, String sym, int quantity, TimeInForceField tinf, PriceType type, SecurityType sectype, double executionPrice, double stop)
	{
		return new FIXML(FIXMLBuilder.createOrderAtExecution(id, sym, quantity, tinf, type, sectype, MarketSideField.SELL, executionPrice, stop));
	}

	private FIXML sellAtOffset(String id, String symbol, int quantity, TimeInForceField timeInForce, PriceType priceType, SecurityType securityType, Percentage offset)
	{
		return new FIXML(FIXMLBuilder.createOrderAtOffset(id, symbol, quantity, timeInForce, priceType, securityType, MarketSideField.SELL, offset));
	}

	private FIXML sellAtOffset(String id, String symbol, int quantity, TimeInForceField timeInForce, PriceType priceType, SecurityType securityType, double offset)
	{
		return new FIXML(FIXMLBuilder.createOrderAtOffset(id, symbol, quantity, timeInForce, priceType, securityType, MarketSideField.SELL, offset));
	}

	public static FIXML sellShort(String id, String sym, int quantity, TimeInForceField tinf, PriceType type, SecurityType sectype)
	{
		return new FIXML(FIXMLBuilder.createSimpleOrder(id, sym, quantity, tinf, type, sectype, MarketSideField.SELL_SHORT));
	}

	private FIXML sellShortAtPrice(String id, String sym, int quantity, TimeInForceField tinf, PriceType type, SecurityType sectype, double executionPrice, double stop)
	{
		return new FIXML(FIXMLBuilder.createOrderAtExecution(id, sym, quantity, tinf, type, sectype, MarketSideField.SELL_SHORT, executionPrice, stop));
	}

	private FIXML sellShortAtOffset(String id, String symbol, int quantity, TimeInForceField timeInForce, PriceType priceType, SecurityType securityType, double offset)
	{
		return new FIXML(FIXMLBuilder.createOrderAtOffset(id, symbol, quantity, timeInForce, priceType, securityType, MarketSideField.SELL_SHORT, offset));
	}

	private FIXML sellShortAtOffset(String id, String symbol, int quantity, TimeInForceField timeInForce, PriceType priceType, SecurityType securityType, Percentage offset)
	{
		return new FIXML(FIXMLBuilder.createOrderAtOffset(id, symbol, quantity, timeInForce, priceType, securityType, MarketSideField.SELL_SHORT, offset));
	}

	public static FIXML buyToCover(String id, String sym, int quantity, TimeInForceField tinf, PriceType type, SecurityType sectype)
	{
		return new FIXML(FIXMLBuilder.createSimpleOrder(id, sym, quantity, tinf, type, sectype, MarketSideField.SELL_SHORT));
	}

	private FIXML buyToCoverAtPrice(String id, String sym, int quantity, TimeInForceField tinf, PriceType type, SecurityType sectype, double executionPrice, double stop)
	{
		return new FIXML(FIXMLBuilder.createOrderAtExecution(id, sym, quantity, tinf, type, sectype, MarketSideField.BUY_TO_COVER, executionPrice, stop));
	}

	private FIXML buyToCoverAtOffset(String id2, String symbol2, int quantity2, TimeInForceField timeInForce2, PriceType priceType2, SecurityType securityType2, double offset)
	{
		return new FIXML(FIXMLBuilder.createOrderAtOffset(id, symbol, quantity, timeInForce, priceType, securityType, MarketSideField.BUY_TO_COVER, offset));
	}

	private FIXML buyToCoverAtOffset(String id2, String symbol2, int quantity2, TimeInForceField timeInForce2, PriceType priceType2, SecurityType securityType2, Percentage offset)
	{
		return new FIXML(FIXMLBuilder.createOrderAtOffset(id, symbol, quantity, timeInForce, priceType, securityType, MarketSideField.BUY_TO_COVER, offset));
	}

	public static void changeOrder()
	{
		throw new UnsupportedOperationException();
	}

	public static void cancelOrder()
	{
		throw new UnsupportedOperationException();
	}

	private static String createSimpleOrder(String acct, String symbol, int quant, TimeInForceField timeinforce, PriceType type, SecurityType sectype, MarketSideField side)
	{
		return createOrderAtExecution(acct, symbol, quant, timeinforce, type, sectype, side, 0, 0);
	}

	private static String createOrderAtOffset(String acct, String symbol, int quant, TimeInForceField timeinforce, PriceType type, SecurityType sectype, MarketSideField side, Percentage offset)
	{
		StringBuilder sb = new StringBuilder();
		sb.append("<FIXML xmlns=\"http://www.fixprotocol.org/FIXML-5-0-SP2\">\n");
		sb.append("\t" + getOrderLine(timeinforce, type, side, acct, 0, 0, offset.toDouble()) + "\n");
		sb.append("\t\t" + "<PegInstr OfstTyp=\"1\" PegPxTyp=\"1\" OfstVal=\"" + offset.toDouble() + "\"/>\n");
		sb.append("\t\t" + "<Instrmt SecTyp=\"" + sectype + "\" Sym=\"" + symbol + "\"/>\n");
		sb.append("\t\t" + "<OrdQty Qty=\"" + quant + "\"/>\n");
		sb.append("\t" + "</Order>\n");
		sb.append("" + "</FIXML>\n");

		return sb.toString();
	}

	private static String createOrderAtExecution(String acct, String symbol, int quant, TimeInForceField timeinforce, PriceType type, SecurityType sectype, MarketSideField side, double executionPrice, double stop)
	{
		StringBuilder sb = new StringBuilder();
		sb.append("<FIXML xmlns=\"http://www.fixprotocol.org/FIXML-5-0-SP2\">\n");
		sb.append("\t" + getOrderLine(timeinforce, type, side, acct, executionPrice, stop, 0) + "\n");
		sb.append("\t\t" + "<Instrmt SecTyp=\"" + sectype + "\" Sym=\"" + symbol + "\"/>\n");
		sb.append("\t\t" + "<OrdQty Qty=\"" + quant + "\"/>\n");
		sb.append("\t" + "</Order>\n");
		sb.append("" + "</FIXML>\n");

		return sb.toString();
	}

	private static Object getOrderLine(TimeInForceField timeinforce, PriceType type, MarketSideField side, String acct, double price, double stop, double offset)
	{
		if (side.equals(MarketSideField.BUY_TO_COVER))
		{
			if (price > 0)
			{
				if (type.equals(PriceType.STOP))
				{
					return "<Order TmInForce=\"" + timeinforce + "\" Typ=\"" + type + "\" Side=\"" + side + "\" AcctTyp=\"5\" StopPx=\"" + price + "\" Acct=\"" + acct + "\">";
				}
				else if (type.equals(PriceType.STOP_LIMIT))
				{
					return "<Order TmInForce=\"" + timeinforce + "\" Typ=\"" + type + "\" Side=\"" + side + "\" AcctTyp=\"5\" Px=\"\"" + price + " StopPx=\"" + stop + "\" Acct=\"" + acct + "\">";
				}
				else
				{
					return "<Order TmInForce=\"" + timeinforce + "\" Typ=\"" + type + "\" Side=\"" + side + "\" AcctTyp=\"5\" Px=\"" + price + "\" Acct=\"" + acct + "\">";
				}
			}
			else if (offset != 0)
			{
				return "<Order TmInForce=\"" + timeinforce + "\" Typ=\"" + type + "\" Side=\"" + side + "\" AcctTyp=\"5\"" + "\" Acct=\"" + acct + "\" ExecInst=\"a\">";
			}
			else
			{
				return "<Order TmInForce=\"" + timeinforce + "\" Typ=\"" + type + "\" Side=\"" + side + "\" AcctTyp=\"5\" Acct=\"" + acct + "\">";
			}
		}
		else
		{
			if (price > 0)
			{
				if (type.equals(PriceType.STOP))
				{
					return "<Order TmInForce=\"" + timeinforce + "\" Typ=\"" + type + "\" Side=\"" + side + "\" StopPx=\"" + price + "\" Acct=\"" + acct + "\">";

				}
				else if (type.equals(PriceType.STOP_LIMIT))
				{
					return "<Order TmInForce=\"" + timeinforce + "\" Typ=\"" + type + "\" Side=\"" + side + "\" Px=\"" + price + "\" StopPx=\"" + stop + "\" Acct=\"" + acct + "\">";
				}
				else
				{
					return "<Order TmInForce=\"" + timeinforce + "\" Typ=\"" + type + "\" Side=\"" + side + "\" Px=\"" + price + "\" Acct=\"" + acct + "\">";
				}
			}
			else if (offset != 0)
			{
				return "<Order TmInForce=\"" + timeinforce + "\" Typ=\"" + type + "\" Side=\"" + side + "\" Acct=\"" + acct + "\" ExecInst=\"a\">";
			}
			else
			{
				return "<Order TmInForce=\"" + timeinforce + "\" Typ=\"" + type + "\" Side=\"" + side + "\" Acct=\"" + acct + "\">";
			}
		}
	}

	private static String createOrderAtOffset(String acct, String symbol, int quant, TimeInForceField timeinforce, PriceType type, SecurityType sectype, MarketSideField side, double offset)
	{
		StringBuilder sb = new StringBuilder();
		sb.append("<FIXML xmlns=\"http://www.fixprotocol.org/FIXML-5-0-SP2\">\n");
		sb.append("\t" + getOrderLine(timeinforce, type, side, acct, 0, 0, offset) + "\n");
		sb.append("\t\t" + "<PegInstr OfstTyp=\"0\" PegPxTyp=\"1\" OfstVal=\"" + offset + "\"/>\n");
		sb.append("\t\t" + "<Instrmt SecTyp=\"" + sectype + "\" Sym=\"" + symbol + "\"/>\n");
		sb.append("\t\t" + "<OrdQty Qty=\"" + quant + "\"/>\n");
		sb.append("\t" + "</Order>\n");
		sb.append("" + "</FIXML>\n");

		return sb.toString();
	}

}
