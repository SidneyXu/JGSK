package com.bookislife.jgsk.kotlin._29_java;

import org.mrseasons.coffeetime.kotlin._23_java.KotlinBean;
import org.mrseasons.coffeetime.kotlin._23_java.Obj;
import org.mrseasons.coffeetime.kotlin._23_java._23_javaPackage;

import java.io.IOException;

/**
 * Created by mrseasons on 2015/06/29.
 */
public class JavaCallKotlin {

    public static void main(String[] args) {
        KotlinBean bean = new KotlinBean("Peter");
        bean.hello();

        //For the root package (the one that’s called a “default package” in Java),
        // a class named _DefaultPackage is created
        _23_javaPackage.bar();

        //foo is static, bar is not
        KotlinBean.foo();

        Obj.foo();

        //Java overload
        _23_javaPackage.f("str");
        _23_javaPackage.f("str", 1);
        _23_javaPackage.f("str", 1, "foo");

        _23_javaPackage.f2("str", 1, "foo");

        //check exception
        try {
            _23_javaPackage.e();
        } catch (IOException e) {
            e.printStackTrace();
        }

        _23_javaPackage.e2();


    }
}
