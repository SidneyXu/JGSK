package com.bookislife.jgsk.java._27_generics;

/**
 * Created by SidneyXu on 2015/10/05.
 */
public class Capture<T> {

    private T t;

    public Capture(T t) {
        this.t = t;
    }

    public void set(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }
}
