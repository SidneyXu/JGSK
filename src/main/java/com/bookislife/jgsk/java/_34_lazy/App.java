package com.bookislife.jgsk.java._34_lazy;

import java.util.function.Supplier;

/**
 * Created by SidneyXu on 2015/12/07.
 */
public class App {

    public static void main(String[] args) {
        System.out.println("Before is " + System.currentTimeMillis());
        A a = new A();
        System.out.println("After is " + System.currentTimeMillis());
        System.out.println("Hello 1, " + a.getFoo());
        System.out.println("Hello 2, " + a.getFoo());
    }
}

class A {
    private Supplier<Long> fooField = () -> {
        Long val = expensiveInit();
        fooField = () -> val;
        return val;
    };

    protected Long expensiveInit() {
        System.out.println("Compute...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return System.currentTimeMillis();
    }

    public Long getFoo() {
        return fooField.get();
    }
}