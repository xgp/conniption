package com.celexus.conniption.model.util;

import java.io.StringReader;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JAXBUtils {
    static private final Logger log = LoggerFactory.getLogger(JAXBUtils.class);

    static public <T> T getElement(String path, String response, String root, Class<T> clazz) throws Exception {
	log.trace(response);

	JAXBContext jaxbContext = JAXBContext.newInstance(path);
	Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
	
	DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	dbf.setNamespaceAware(true);
	DocumentBuilder db = dbf.newDocumentBuilder();
	Document doc = db.parse(new InputSource(new StringReader(response)));
	Element element = doc.getDocumentElement();
	if (root != null) {
	    NodeList nodeList = element.getChildNodes();
	    for (int j = 0; j < nodeList.getLength(); j++) {
		Node childNode = nodeList.item(j);
		if (childNode.getNodeType() == Node.ELEMENT_NODE) {
		    if (childNode.getNodeName().equals(root)) {
			element = (Element)childNode;
			break;
		    }
		}
	    }
	}

	JAXBElement<T> t = jaxbUnmarshaller.unmarshal(element, clazz);
	return t.getValue();
    }

}