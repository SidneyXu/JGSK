package com.bookislife.jgsk.scala._19_inherit

/**
 * Created by SidneyXu on 2015/09/29.
 */
abstract class Shape(val name: String) {
  val int: Int

  def height: Int

  def width: Int
}

class Rectangle(override val name: String) extends Shape(name) {
  val int: Int = 20

  override def height: Int = ???

  override def width: Int = ???
}
