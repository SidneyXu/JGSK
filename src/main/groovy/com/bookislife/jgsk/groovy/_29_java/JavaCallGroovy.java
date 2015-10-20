package com.bookislife.jgsk.groovy._29_java;

/**
 * Created by SidneyXu on 2015/10/20.
 */
public class JavaCallGroovy {

    public static void main(String[] args) {
        GroovyBean groovyBean = new GroovyBean("Peter");
        System.out.println(groovyBean.calc(2, 3));
    }
}
