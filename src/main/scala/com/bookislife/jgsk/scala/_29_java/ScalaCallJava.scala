package com.bookislife.jgsk.scala._29_java

/**
 * Created by SidneyXu on 2015/10/20.
 */
object ScalaCallJava extends App {

  val javaBean = new JavaBean("JavaBean")
  println(javaBean.getName) //  JavaBean
  println(javaBean.calc(2, 3)) //  5

  JavaBean.hello(javaBean) //  Hello, this is JavaBean
}
