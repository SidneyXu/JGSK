package com.bookislife.jgsk.java._15_class;

/**
 * Created by SidneyXu on 2015/09/22.
 */
public class Person {

    private int age;

    public void say(String message) {
        System.out.println(message);
    }

    public int getAge() {
        return age;
    }

    public void setAge(final int age) {
        this.age = age;
    }
}
