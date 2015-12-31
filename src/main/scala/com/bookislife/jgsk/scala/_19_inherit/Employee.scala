package com.bookislife.jgsk.scala._19_inherit

/**
  * Created by SidneyXu on 2015/09/29.
  */
class Employee(name: String, salary: Int) extends Person(name) {

  //  Override Rules
  override val defValue1: String = "val Override def"
  override val valValue: String = "val Override val"

  override def defValue2: String = "def Override def"

  //  Wrong!!
  //  override var x: String = "var Override var"
}
