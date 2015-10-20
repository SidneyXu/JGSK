package com.bookislife.jgsk.scala._29_java

import scala.beans.BeanProperty

/**
 * Created by SidneyXu on 2015/10/20.
 */
class ScalaBean(@BeanProperty val name: String) {

  val age: Int = 10

  def calc(x: Int, y: Int) = x + y
}

object ScalaBean {

  def hello(bean: ScalaBean): Unit = println(s"Hello, this is ${bean.name}")
}

object ScalaUtils {
  def foo = println("Foo...")
}
