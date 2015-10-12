package com.bookislife.jgsk.java._26_xml_json;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * Created by SidneyXu on 2015/10/13.
 */
public class ParseXml {
    public static void main(String[] args) {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse("coffeetime-groovy/src/langs.xml");

            //print the "type" attribute
            Element langs = doc.getDocumentElement();
            System.out.println("type = " + langs.getAttribute("type"));

            //print the "language" elements
            NodeList list = langs.getElementsByTagName("language");
            for(int i = 0 ; i < list.getLength();i++) {
                Element language = (Element) list.item(i);
                System.out.println(language.getTextContent());
            }
        }catch(ParserConfigurationException pce) {
            pce.printStackTrace();
        }catch(SAXException se) {
            se.printStackTrace();
        }catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
