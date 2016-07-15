//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.07.14 at 02:43:01 PM PDT 
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
 *         &lt;element name="askprice" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="bidprice" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="change" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="extendedquote">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="asksize" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                   &lt;element name="bidsize" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                   &lt;element name="dividenddata">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="amt" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *                             &lt;element name="exdate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *                             &lt;element name="paydate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *                             &lt;element name="yield" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="earningspershare" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *                   &lt;element name="high52price" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *                   &lt;element name="highprice" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *                   &lt;element name="low52price" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *                   &lt;element name="lowprice" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *                   &lt;element name="openprice" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *                   &lt;element name="prevclose" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *                   &lt;element name="priceearningsratio" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                   &lt;element name="sessionvolume" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                   &lt;element name="volume" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="lastprice" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="pctchange" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "askprice",
    "bidprice",
    "change",
    "extendedquote",
    "lastprice",
    "pctchange"
})
public class OrderQuote {

    protected double askprice;
    protected double bidprice;
    protected double change;
    @XmlElement(required = true)
    protected Extendedquote extendedquote;
    protected double lastprice;
    protected int pctchange;

    /**
     * Gets the value of the askprice property.
     * 
     */
    public double getAskprice() {
        return askprice;
    }

    /**
     * Sets the value of the askprice property.
     * 
     */
    public void setAskprice(double value) {
        this.askprice = value;
    }

    /**
     * Gets the value of the bidprice property.
     * 
     */
    public double getBidprice() {
        return bidprice;
    }

    /**
     * Sets the value of the bidprice property.
     * 
     */
    public void setBidprice(double value) {
        this.bidprice = value;
    }

    /**
     * Gets the value of the change property.
     * 
     */
    public double getChange() {
        return change;
    }

    /**
     * Sets the value of the change property.
     * 
     */
    public void setChange(double value) {
        this.change = value;
    }

    /**
     * Gets the value of the extendedquote property.
     * 
     * @return
     *     possible object is
     *     {@link Extendedquote }
     *     
     */
    public Extendedquote getExtendedquote() {
        return extendedquote;
    }

    /**
     * Sets the value of the extendedquote property.
     * 
     * @param value
     *     allowed object is
     *     {@link Extendedquote }
     *     
     */
    public void setExtendedquote(Extendedquote value) {
        this.extendedquote = value;
    }

    /**
     * Gets the value of the lastprice property.
     * 
     */
    public double getLastprice() {
        return lastprice;
    }

    /**
     * Sets the value of the lastprice property.
     * 
     */
    public void setLastprice(double value) {
        this.lastprice = value;
    }

    /**
     * Gets the value of the pctchange property.
     * 
     */
    public int getPctchange() {
        return pctchange;
    }

    /**
     * Sets the value of the pctchange property.
     * 
     */
    public void setPctchange(int value) {
        this.pctchange = value;
    }

}
