package com.bookislife.jgsk.java._13_collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by SidneyXu on 2015/09/20.
 */
public class App {

    public static void main(String[] args) {
        testArray();
        testList();
    }

    private static void testArray() {
        //  Define
        int[] arr = new int[3];
        int[] arr2 = {1, 2, 3};

        //  Length
        System.out.println(arr.length);

        //  Modify Elements
        arr[0] = 10;

        //  Access Elements
        System.out.println(arr[0]);

        //  Traverse
        for (int a : arr2) {
            System.out.println("Traverse " + a);
        }

        //  Pretty Print
        System.out.println(Arrays.toString(arr2));

    }

    private static void testList() {
        //  Define
        //  Empty List
        List<String> list = new ArrayList<>();
        List emptyList = Collections.emptyList();
        //  Wrong!! UnsupportedOperationException
        //        emptyList.add(1);

        //  Length
        System.out.println(list.size());

        //  Modify List
        //  Add Elements
        list.add("Groovy");
        list.add("Java");
        list.add("Scala");
        Collections.addAll(list, "Groovy", "Java", "Scala");

        //  Modify Elements
        list.set(1, "Python");
        //  Wrong!! IndexOutOfBoundsException
        //        list.set(10, "Ruby");

        //  Delete Elements
        list.remove(1);

        //  Access Elements
        System.out.println(list.get(2));
        //  Wrong!! ArrayIndexOutOfBoundsException
        //        System.out.println(list.get(-1));

        //  Constructor List with Elements
        Arrays.asList("Groovy", "Java", "Scala");
        new ArrayList<String>() {{
            add("Groovy");
            add("Java");
            add("Scala");
        }};

        //  Immutable List
        List<String> immuatbleList = Collections.unmodifiableList(list);

        //  Traverse
        for (String lang : list) {
            System.out.println("Traverse " + lang);
        }
    }
}
