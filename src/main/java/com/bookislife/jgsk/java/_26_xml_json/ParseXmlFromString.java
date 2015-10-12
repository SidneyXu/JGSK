package com.bookislife.jgsk.java._26_xml_json;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by SidneyXu on 2015/10/13.
 */
public class ParseXmlFromString {
    public static void main(String[] args) {
        String xml = "<langs type=\"current\">\n" +
                "  <language>Java</language>\n" +
                "  <language>Groovy</language>\n" +
                "  <language>JavaScript</language>\n" +
                "</langs>";

        byte[] xmlBytes = xml.getBytes();
        InputStream is = new ByteArrayInputStream(xmlBytes);

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(is);

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
