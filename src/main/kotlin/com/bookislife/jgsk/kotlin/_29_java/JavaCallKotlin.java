package com.bookislife.jgsk.kotlin._29_java;

import java.io.IOException;

/**
 * Created by SidneyXu on 2015/10/20.
 */
public class JavaCallKotlin {

    public static void main(String[] args) {
        //  Class
        KotlinBean kotlinBean = new KotlinBean("Peter");
        System.out.printf(kotlinBean.getName());    //  Peter
        System.out.println(kotlinBean.calc(2, 3));  //  5

        KotlinBean.hello(kotlinBean);               //  Hello, this is Peter
        KotlinBean.Companion.echo("GoodBye", kotlinBean);   //  GoodBye, this is Peter

        //  Object
        KotlinUtils.foo();
        KotlinUtils.INSTANCE.bar();

        //TODO
        //  For the root package, a class named _DefaultPackage is created
//        _29_javaPackage.foobar();
//
//
//        //  Exception
//        //        _29_javaPackage.throwAnException();
//        try {
//            _29_javaPackage.declaredThrowAnException();
//        } catch (IOException ignored) {
//        }
//
//        //  Overload
//        _29_javaPackage.f("x");             //  a=x b=0 c=c
//        _29_javaPackage.f("x", 10);         //  a=x b=10 c=c
//        _29_javaPackage.f("x", 10, "z");    //  a=x b=10 c=z
    }
}
