package com.bookislife.jgsk.scala._29_java;

/**
 * Created by SidneyXu on 2015/10/20.
 */
public class JavaBean {

    private String name;

    public JavaBean(String name) {
        this.name = name;
    }

    public int calc(int x, int y) {
        return x + y;
    }

    public String getName() {
        return name;
    }

    public static void hello(JavaBean bean) {
        System.out.println("Hello, this is " + bean.name);
    }

}
