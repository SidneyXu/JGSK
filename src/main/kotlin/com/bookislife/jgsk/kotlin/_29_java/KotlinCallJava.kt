package com.bookislife.jgsk.kotlin._29_java

import java.util.ArrayList

/**
 * Created by SidneyXu on 2015/10/20.
 */
fun main(args: Array<String>) {
    val javaBean = JavaBean("JavaBean")
    println(javaBean.name)     //  JavaBean
    println(javaBean.calc(2, 3))    //  5

    JavaBean.hello(javaBean)        //  Hello, this is Peter

    //  Escaping for Java identifiers that are keywords in Kotlin
    println(javaBean.`is`("Peter")) //  true

    //  Null-Safety and Platform Types
    val list = ArrayList<JavaBean>()
    list.add(javaBean)
    val nullable: JavaBean? = list[0]
    val notNull: JavaBean = list[0]
    nullable?.name
    notNull.name

}