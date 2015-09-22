package com.bookislife.jgsk.scala._15_class

import java.util.Date

/**
 * Created by SidneyXu on 2015/2/12.
 */
class Person {
  //  Default Getter and Setter
  var age = 0

  //  Specify Getter and Setter
  private var privateAge = 0

  def trueAge = privateAge

  def trueAge_=(pAge: Int) {
    if (pAge > privateAge) {
      privateAge = pAge
    }
  }

  //  Only Getter
  val birthday = new Date()

  //  Object Private Fields
  private[this] var selfAge = 0

  def isYounger(other: Person) = age < other.age

  //  Wrong!!  Field is inaccessible.
  //    def isYounger2(other:Person) = selfAge < other.selfAge

  def say(message: String) {
    println(message)
  }
}
