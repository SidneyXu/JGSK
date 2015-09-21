package com.bookislife.jgsk.java._14_map;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by SidneyXu on 2015/09/21.
 */
public class App {

    public static void main(String[] args) {
        //  Define
        //  Empty Map
        Map<String, Object> map = new HashMap<>();
        Map<String, Integer> emptyMap = Collections.emptyMap();
        //  Wrong!! java.lang.UnsupportedOperationException
        //        emptyMap.put("x", 1);

        //  Put
        map.put("name", "Peter");
        map.put("age", 12);
        map.put("national", "USA");

        //  Delete
        map.remove("age");

        //  Get
        String name = (String) map.get("name");
        System.out.println(name);

        int height = (int) map.getOrDefault("height", 170);
        System.out.println(height);

        System.out.println(map);

        //  Length
        System.out.println(map.size());

        //  Traverse
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            System.out.println("Traverse " + entry.getKey() + " is " + entry.getValue());
        }
    }
}
