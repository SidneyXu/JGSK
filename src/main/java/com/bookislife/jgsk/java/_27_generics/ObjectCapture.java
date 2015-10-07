package com.bookislife.jgsk.java._27_generics;

/**
 * Created by SidneyXu on 2015/10/05.
 */
public class ObjectCapture {

    private Object object;

    public ObjectCapture(Object o) {
        this.object = o;
    }

    public void set(Object object) {
        this.object = object;
    }

    public Object get() {
        return object;
    }
}
