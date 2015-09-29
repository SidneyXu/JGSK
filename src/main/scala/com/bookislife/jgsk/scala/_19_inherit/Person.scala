package com.bookislife.jgsk.scala._19_inherit

/**
 * Created by SidneyXu on 2015/09/29.
 */
class Person(val name: String) {

  //override not abstract method
  override def toString = getClass.getName + "[name=" + name + "]"

  //override
  val id = "PersonVal"
  var x = "PersonVar"
  def idf = "PersonDef"

  def idf2 = "PersonDef2"

  //protected access
  protected def info = name

  //protected + package access
  protected[_19_inherit] def info2 = name

}
