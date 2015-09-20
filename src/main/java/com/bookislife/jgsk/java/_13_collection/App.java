package com.bookislife.jgsk.java._13_collection;

import java.util.*;

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

        //  Modify Elements
        arr[0] = 10;

        //  Access Elements
        System.out.println(arr[0]);
    }

    private static void testList() {
        //  Define
        //  Empty List
        List<String> list = new ArrayList<>();
        List emptyList = Collections.emptyList();
        //  Wrong!! UnsupportedOperationException
        //        emptyList.add(1);

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
    }
}
