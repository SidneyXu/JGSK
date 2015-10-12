package com.bookislife.jgsk.java._26_xml_json;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;

/**
 * Created by SidneyXu on 2015/10/13.
 */
public class CreateXml {
    public static void main(String[] args) {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.newDocument();

            Element langs = doc.createElement("langs");
            langs.setAttribute("type", "current");
            doc.appendChild(langs);

            Element language1 = doc.createElement("language");
            Text text1 = doc.createTextNode("Java");
            language1.appendChild(text1);
            langs.appendChild(language1);

            Element language2 = doc.createElement("language");
            Text text2 = doc.createTextNode("Groovy");
            language2.appendChild(text2);
            langs.appendChild(language2);

            Element language3 = doc.createElement("language");
            Text text3 = doc.createTextNode("JavaScript");
            language3.appendChild(text3);
            langs.appendChild(language3);

            // Output the XML
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            StringWriter sw = new StringWriter();
            StreamResult sr = new StreamResult(sw);
            DOMSource source = new DOMSource(doc);
            transformer.transform(source, sr);
            String xmlString = sw.toString();
            System.out.println(xmlString);
        }catch(ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}
