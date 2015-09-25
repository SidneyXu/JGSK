package com.bookislife.jgsk.scala._18_object

/**
 * Created by mrseasons on 2/13/15.
 */
object CompanionExample {

  def main(args: Array[String]) {
    def account1 = new Companion(30)
    println(account1.id)
    println(Companion.getInfo(account1))

    def account2 = new Companion(10)
    println(account2.id)
    println(Companion.getInfo(account2))

    def account3 = new Companion(50)
    println(account3.id)
    println(Companion.getInfo(account3))

    account1.id
    account1.id
    account1.id
    println(account1.id)

    //apply
    def account4 = Companion(90)
    println(account4.id)
    println(Companion.getInfo(account4))
  }
}
