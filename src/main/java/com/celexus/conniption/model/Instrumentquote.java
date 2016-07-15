//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.07.14 at 01:02:12 PM PDT 
//


package com.celexus.conniption.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="displaydata">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="askprice" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *                   &lt;element name="asksize" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="bidprice" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *                   &lt;element name="bidsize" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="change" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *                   &lt;element name="contracthigh" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *                   &lt;element name="contractlow" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *                   &lt;element name="contractsize" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *                   &lt;element name="delta" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *                   &lt;element name="desc" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="dividendamount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                   &lt;element name="dividendexdate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                   &lt;element name="dividendpaydate" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *                   &lt;element name="dividendyield" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="earningspershare" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *                   &lt;element name="exch" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="expiry" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *                   &lt;element name="gamma" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *                   &lt;element name="high52price" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *                   &lt;element name="highprice" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *                   &lt;element name="impvolatility" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *                   &lt;element name="lastclosingprice" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *                   &lt;element name="lastprice" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *                   &lt;element name="low52price" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *                   &lt;element name="lowprice" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *                   &lt;element name="nav" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *                   &lt;element name="openinterest" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *                   &lt;element name="openprice" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *                   &lt;element name="optval" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *                   &lt;element name="optiontype" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *                   &lt;element name="pctchange" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="priceearningsratio" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                   &lt;element name="rho" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *                   &lt;element name="sessionvolume" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="strike" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *                   &lt;element name="symbol" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="theta" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *                   &lt;element name="unknownsymbol" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="vega" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *                   &lt;element name="volatility" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *                   &lt;element name="volume" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="greeks" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *         &lt;element name="instrument">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="desc" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="exch" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="sectyp" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="sym" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="quote">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="askprice" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *                   &lt;element name="bidprice" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *                   &lt;element name="change" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *                   &lt;element name="extendedquote">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="asksize" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                             &lt;element name="bidsize" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                             &lt;element name="dividenddata">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="amt" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *                                       &lt;element name="exdate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *                                       &lt;element name="paydate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *                                       &lt;element name="yield" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="earningspershare" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *                             &lt;element name="high52price" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *                             &lt;element name="highprice" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *                             &lt;element name="low52price" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *                             &lt;element name="lowprice" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *                             &lt;element name="openprice" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *                             &lt;element name="prevclose" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *                             &lt;element name="priceearningsratio" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                             &lt;element name="sessionvolume" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                             &lt;element name="volume" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="lastprice" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *                   &lt;element name="pctchange" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="unknownsymbol" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "displaydata",
    "greeks",
    "instrument",
    "quote",
    "unknownsymbol"
})
public class Instrumentquote {

    @XmlElement(required = true)
    protected Displaydata displaydata;
    @XmlElement(required = true)
    protected Object greeks;
    @XmlElement(required = true)
    protected Instrument instrument;
    @XmlElement(required = true)
    protected OrderQuote quote;
    @XmlElement(required = true)
    protected String unknownsymbol;

    /**
     * Gets the value of the displaydata property.
     * 
     * @return
     *     possible object is
     *     {@link Displaydata }
     *     
     */
    public Displaydata getDisplaydata() {
        return displaydata;
    }

    /**
     * Sets the value of the displaydata property.
     * 
     * @param value
     *     allowed object is
     *     {@link Displaydata }
     *     
     */
    public void setDisplaydata(Displaydata value) {
        this.displaydata = value;
    }

    /**
     * Gets the value of the greeks property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getGreeks() {
        return greeks;
    }

    /**
     * Sets the value of the greeks property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setGreeks(Object value) {
        this.greeks = value;
    }

    /**
     * Gets the value of the instrument property.
     * 
     * @return
     *     possible object is
     *     {@link Instrument }
     *     
     */
    public Instrument getInstrument() {
        return instrument;
    }

    /**
     * Sets the value of the instrument property.
     * 
     * @param value
     *     allowed object is
     *     {@link Instrument }
     *     
     */
    public void setInstrument(Instrument value) {
        this.instrument = value;
    }

    /**
     * Gets the value of the quote property.
     * 
     * @return
     *     possible object is
     *     {@link OrderQuote }
     *     
     */
    public OrderQuote getQuote() {
        return quote;
    }

    /**
     * Sets the value of the quote property.
     * 
     * @param value
     *     allowed object is
     *     {@link OrderQuote }
     *     
     */
    public void setQuote(OrderQuote value) {
        this.quote = value;
    }

    /**
     * Gets the value of the unknownsymbol property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnknownsymbol() {
        return unknownsymbol;
    }

    /**
     * Sets the value of the unknownsymbol property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnknownsymbol(String value) {
        this.unknownsymbol = value;
    }

}
