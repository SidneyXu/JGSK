package com.bookislife.jgsk.kotlin._29_java;

/**
 * Created by mrseasons on 2015/06/29.
 */
public class JavaBean {

    private String name;

    public JavaBean(String name) {
        this.name = name;
    }

    public void hello() {
        System.out.println("hello,my name is " + name);
    }

    public boolean is(String name){
        return this.name.equals(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
