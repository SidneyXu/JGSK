package com.bookislife.jgsk.scala._18_object

/**
 * Created by SidneyXu on 2015/09/25.
 */
object App {

  def main(args: Array[String]) {
    testSingleton()
    testCompanion()
  }

  def testSingleton(): Unit = {
    assert(1 == Singleton.sequence())
    assert(2 == Singleton.sequence())
    assert(3 == Singleton.sequence())
  }

  def testCompanion(): Unit = {
    val account = Companion(30)
    assert(1 == account.id)
    assert("Balance is 30" == Companion.getInfo(account))
  }

}
