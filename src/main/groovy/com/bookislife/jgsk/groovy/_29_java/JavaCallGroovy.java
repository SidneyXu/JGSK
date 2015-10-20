package com.bookislife.jgsk.groovy._29_java;

/**
 * Created by SidneyXu on 2015/10/20.
 */
public class JavaCallGroovy {

    public static void main(String[] args) {
        GroovyBean groovyBean = new GroovyBean("GroovyBean");
        System.out.println(groovyBean.getName());   //  GroovyBean
        System.out.println(groovyBean.calc(2, 3));  //  5
        GroovyBean.hello(groovyBean);               //  Hello, this is GroovyBean
    }
}
