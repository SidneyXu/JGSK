package com.bookislife.jgsk.scala._18_object

/**
 * Created by SidneyXu on 2015/09/25.
 */
class Companion(private var balance: Int = 0) {
  //  Access private method of companion object
  val id = Companion.sequence()
}

object Companion {
  private var num = 0

  def getInfo(account: Companion): String = {
    //  Access private member of class
    "Balance is " + account.balance
  }

  def apply(initBalance: Int) = {
    new Companion(initBalance)
  }

  private def sequence(): Int = {
    num += 1
    num
  }
}