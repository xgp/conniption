package com.celexus.conniption.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
	"instrumentquote"
})
public class OrderQuotes {

    protected List<Instrumentquote> instrumentquote;

    /**
     * Gets the value of the instrumentquote property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the instrumentquote property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInstrumentquote().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Instrumentquote }
     * 
     * 
     */
    public List<Instrumentquote> getInstrumentquote() {
        if (instrumentquote == null) {
            instrumentquote = new ArrayList<Instrumentquote>();
        }
        return this.instrumentquote;
    }

}
