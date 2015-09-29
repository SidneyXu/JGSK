package com.bookislife.jgsk.scala._19_inherit

/**
 * Created by SidneyXu on 2015/09/29.
 */
class Person(val name: String) {

  //  Overrides Non-Abstract method
  override def toString = getClass.getName + "[name=" + name + "]"

  //  Override rules
  val valValue = "PersonVal"
  var varValue = "PersonVar"

  def defValue1 = "PersonDef"

  def defValue2 = "PersonDef2"

  //  Protected Access
  protected def info = name

  //  Protected + Package access
  protected[_19_inherit] def info2 = name

}
