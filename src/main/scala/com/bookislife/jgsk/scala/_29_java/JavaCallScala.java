package com.bookislife.jgsk.scala._29_java;

/**
 * Created by mrseasons on 2015/05/16.
 */
public class JavaCallScala {

    public static void main(String[] args) {
        ScalaBean scalaBean = new ScalaBean("ScalaBean");
        System.out.println(scalaBean.name());   //ScalaBean
        System.out.println(scalaBean.getName());    //ScalaBean
        System.out.println(scalaBean.say());    //hello scala

        ScalaExample.info(); //scala
        ScalaExample example = ScalaExample.get("abc");
        System.out.println(example.name()); //abc
    }
}
