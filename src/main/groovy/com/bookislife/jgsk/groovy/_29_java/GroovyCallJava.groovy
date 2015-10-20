package com.bookislife.jgsk.groovy._29_java

/**
 *  Created by SidneyXu on 2015/10/20.
 */
class GroovyCallJava {

    static void main(args) {
        JavaBean javaBean = new JavaBean("JavaBean")
        println javaBean.getName()  //  JavaBean
        println javaBean.calc(2, 3) //  5
        JavaBean.hello(javaBean)    //  Hello, this is JavaBean
    }
}
