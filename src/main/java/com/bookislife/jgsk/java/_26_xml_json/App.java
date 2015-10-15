package com.bookislife.jgsk.java._26_xml_json;

import com.oracle.javafx.jmx.json.JSONDocument;
import com.oracle.javafx.jmx.json.JSONReader;
import com.oracle.javafx.jmx.json.impl.JSONStreamReaderImpl;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;

/**
 * Created by SidneyXu on 2015/10/13.
 */
public class App {

    public static void main(String[] args) {
        createJson();
        parseJson();
        createXml();
        parseXml();
    }

    private static void createJson() {
        System.out.println("========invoke createJson()========");

        //  JSON Object
        JSONDocument jsonDocument = JSONDocument.createObject();
        JSONDocument results = JSONDocument.createObject();
        results.setString("result", "x");
        results.setString("result", "y");
        jsonDocument.set("results", results);
        System.out.println(jsonDocument.toJSON());

        //  JSON Array
        jsonDocument = JSONDocument.createArray();
        JSONDocument jsonDocument1 = JSONDocument.createObject();
        jsonDocument1.setString("404", "not found");
        JSONDocument jsonDocument2 = JSONDocument.createObject();
        jsonDocument2.setString("302", "redirect");
        jsonDocument.array().add(jsonDocument1);
        jsonDocument.array().add(jsonDocument2);
        System.out.println(jsonDocument.toJSON());
    }

    private static void parseJson() {
        System.out.println("========invoke parseJson()========");

        String json = "{\"data\":[{\"404\":\"not found\"},{\"302\":\"redirect\"}]}";
        JSONReader jsonReader = new JSONStreamReaderImpl(new StringReader(json));
        JSONDocument jsonDocument = jsonReader.build();
        JSONDocument data = jsonDocument.get("data");
        System.out.println(data.get(0).object().keySet().iterator().next());    //  404
        System.out.println(data.get(1).object().values().iterator().next());    //  redirect
    }

    private static void createXml() {
        System.out.println("========invoke createXml()========");

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();

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
            Text text3 = doc.createTextNode("Scala");
            language3.appendChild(text3);
            langs.appendChild(language3);

            Element language4 = doc.createElement("language");
            Text text4 = doc.createTextNode("Kotlin");
            language4.appendChild(text4);
            langs.appendChild(language4);

            // Output the XML
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.VERSION, "1.0");
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            StringWriter writer = new StringWriter();
            StreamResult streamResult = new StreamResult(writer);
            DOMSource source = new DOMSource(doc);
            transformer.transform(source, streamResult);
            String xmlString = writer.toString();
            System.out.println(xmlString);
        } catch (ParserConfigurationException | TransformerException pce) {
            pce.printStackTrace();
        }
    }

    private static void parseXml() {
        System.out.println("========invoke parseXml()========");

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
            for (int i = 0; i < list.getLength(); i++) {
                Element language = (Element) list.item(i);
                System.out.println(language.getTextContent());
            }
        } catch (ParserConfigurationException | SAXException | IOException pce) {
            pce.printStackTrace();
        }
    }
}
