package com.bookislife.jgsk.java._26_xml_json;

import com.oracle.javafx.jmx.json.JSONDocument;
import com.oracle.javafx.jmx.json.JSONReader;
import com.oracle.javafx.jmx.json.impl.JSONStreamReaderImpl;

import java.io.StringReader;

/**
 * Created by SidneyXu on 2015/10/13.
 */
public class App {

    public static void main(String[] args) {
        createJson();
        parseJson();
    }

    private static void createJson() {
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
        String json = "{\"data\":[{\"404\":\"not found\"},{\"302\":\"redirect\"}]}";
        JSONReader jsonReader = new JSONStreamReaderImpl(new StringReader(json));
        JSONDocument jsonDocument = jsonReader.build();
        JSONDocument data = jsonDocument.get("data");
        System.out.println(data.get(0).object().keySet().iterator().next());    //  404
        System.out.println(data.get(1).object().values().iterator().next());    //  redirect
    }

}
