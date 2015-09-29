package com.bookislife.jgsk.java._19_inherit;

/**
 * Created by SidneyXu on 2015/09/29.
 */
public interface Calculator {

    int add(int x, int y);

    //  Default Method
    default int addOne(int x) {
        return x + 1;
    }
}
