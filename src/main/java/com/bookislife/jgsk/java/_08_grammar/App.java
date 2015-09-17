package com.bookislife.jgsk.java._08_grammar;

import java.util.Date;

/**
 * Created by SidneyXu on 2015/09/17.
 */
public class App {

    public static void main(String[] args) {
        //  Comment
        //  Single Line Comment
        /*
            MultiLines Comments
         */
        /**
         * JavaDoc
         */

        //  Operators
        int i = 1;
        i++;
        i += 3;

        //  Call Methods
        add(1, 2);

        //  Equals
        Date x = new Date(100);
        Date y = new Date(100);

        System.out.println("x==y: " + (x == y));    //  false
        System.out.println("x.equals(y): " + x.equals(y));  //  true

    }

    public static int add(int x, int y) {
        return x + y;
    }
}
