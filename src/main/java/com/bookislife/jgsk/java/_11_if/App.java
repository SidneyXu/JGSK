package com.bookislife.jgsk.java._11_if;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SidneyXu on 2015/09/18.
 */
public class App {

    public static void main(String[] args) {
        //  If
        int i = 0;
        if (i != 0) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }

        List list = new ArrayList<>();
        if (!list.isEmpty())
            System.out.println(true);
        else
            System.out.println(false);
    }
}
