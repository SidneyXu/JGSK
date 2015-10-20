package com.bookislife.jgsk.scala._29_java;

/**
 * Created by mrseasons on 2015/05/16.
 */
public class JavaBean {

    private String name;

    public JavaBean(String name) {
        this.setName(name);
    }

    public String say(){
        return "hello java";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
