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
 *         &lt;element name="warningcode" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="warningtext" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "warningcode",
    "warningtext"
})
public class Warning {

    protected int warningcode;
    @XmlElement(required = true)
    protected String warningtext;

    /**
     * Gets the value of the warningcode property.
     * 
     */
    public int getWarningcode() {
        return warningcode;
    }

    /**
     * Sets the value of the warningcode property.
     * 
     */
    public void setWarningcode(int value) {
        this.warningcode = value;
    }

    /**
     * Gets the value of the warningtext property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWarningtext() {
        return warningtext;
    }

    /**
     * Sets the value of the warningtext property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWarningtext(String value) {
        this.warningtext = value;
    }

}