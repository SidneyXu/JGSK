package com.bookislife.jgsk.scala._18_object

/**
 * Created by mrseasons on 2015/2/13.
 */
class Companion(private var balance: Int = 0) {
  //access private method of companion object
  val id = Companion.sequence()
}

object Companion {
  private var num = 0

  def getInfo(account: Companion): String = {
    //access private member of class
    "balance is " + account.balance
  }

  def apply(initBalance: Int) = {
    new Companion(initBalance)
  }

  private def sequence(): Int = {
    num += 1
    num
  }
}