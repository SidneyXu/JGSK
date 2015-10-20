package com.bookislife.jgsk.scala._29_java;

/**
 * Created by SidneyXu on 2015/10/20.
 */
public class JavaCallScala {

    public static void main(String[] args) {
        ScalaBean scalaBean = new ScalaBean("ScalaBean");
        System.out.println(scalaBean.name());       //  ScalaBean
        System.out.println(scalaBean.getName());    //  ScalaBean
        System.out.println(scalaBean.age());        //  10
        System.out.println(scalaBean.calc(2, 3));    //  5

        ScalaBean.hello(scalaBean);                 //  Hello, this is ScalaBean
        ScalaBean$.MODULE$.hello(scalaBean);        //  Hello, this is ScalaBean

        ScalaUtils.foo();   //  Foo...
    }
}
