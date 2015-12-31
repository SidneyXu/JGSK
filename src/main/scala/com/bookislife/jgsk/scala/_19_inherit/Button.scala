package com.bookislife.jgsk.scala._19_inherit

/**
  * Created by Sidney on 2015/09/29.
  */
class Button(val text: String, width: Int, override val height: Int) extends View(width, height) {
  //  Overrides abstract method
  def getDescription(): String = text

  override def toString: String = getDescription()
}
