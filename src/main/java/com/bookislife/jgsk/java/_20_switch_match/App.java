package com.bookislife.jgsk.java._20_switch_match;

/**
 * Created by SidneyXu on 2015/09/24.
 */
public class App {

    public static void main(String[] args) {
        int i = 5 + 5;
        int j = 20;
        switch (i) {
            case 1:
                System.out.println("i is 1");
            case 10:
                System.out.println("i is 10");
                //  Wrong!! constant expression required
                //            case j:
                //                System.out.println("i is 20");
            case 100:
                System.out.println("i is 100");
            case 1000:
                System.out.println("i is 1000");
                break;
            case 10000:
                System.out.println("i is 10000");
            default:
                System.out.println("default");
        }

        String word = "Hello Java";
        switch (word) {
            case "Hello Java":
                System.out.println("Java");
                break;
            case "Hello Groovy":
                System.out.println("Groovy");
                break;
            case "Hello Scala":
                System.out.println("Scala");
                break;
            default:
                System.out.println("Kotlin");
                break;
        }
    }

}
