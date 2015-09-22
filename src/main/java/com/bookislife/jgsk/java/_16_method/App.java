package com.bookislife.jgsk.java._16_method;

/**
 * Created by SidneyXu on 2015/09/22.
 */
public class App {

    public static void main(String[] args) {
        //  Method
        //  Static Method
        say("Peter", "Goodbye");

        //  Default Values
        say("Peter", null);

        //  Return Value
        Calculator calculator = new Calculator();
        System.out.println(calculator.add(2, 3));
    }

    private static int add(int x, int y) {
        return x + y;
    }

    private static void say(String name, String word) {
        if (word == null) {
            System.out.println(word + " " + name);
        }
    }

}

class Calculator {

    public int add(int x, int y) {
        return x + y;
    }

}