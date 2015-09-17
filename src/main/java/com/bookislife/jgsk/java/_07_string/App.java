package com.bookislife.jgsk.java._07_string;

/**
 * Created by SidneyXu on 2015/09/17.
 */
public class App {

    public static void main(String[] args) {
        //  Literals
        String s = "Hello World";

        //  Iterator
        for (char c : s.toCharArray()) {
            System.out.println(c);
        }

        //  Multiple Lines
        String text =
                "\t1, 2, 3\n" +
                        "\tone, two, three\n" +
                        "\t\"x\", \"y\", \"z\"";
        System.out.println(text);

        //  Template
        String name = "Peter";
        String str = "name=$name, ${name.length()}";
        System.out.println(
                str.replace("$name", name)
                        .replace("${name.length}", "" + name.length()));

        //  Methods
        System.out.println(s.charAt(2));    //  l
        System.out.println(s.substring(6, 9));  //  Wor
    }
}
