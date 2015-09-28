package com.bookislife.jgsk.scala._17_innerclass


/**
 * Created by SidneyXu on 2015/09/28.
 */
object App {

  def main(args: Array[String]) {
    //  Anonymous Inner Class
    val thread = new Thread(new Runnable {
      def run(): Unit = {

      }
    })

    //  Inner Class
    val outter1 = new Outter("Outter1")
    val inner1 = new outter1.Inner("Inner1")

    val outter2 = new Outter("Outter2")
    val inner2 = new outter2.Inner("Inner2")

    println(s"outter1 is ${outter1.getClass}") //  _innerclass.Outter
    println(s"outter2 is ${outter2.getClass}") //  _innerclass.Outter
    println(s"inner1 is ${inner1.getClass}")  //  _innerclass.Outter$Inner
    println(s"inner2 is ${inner2.getClass}")  //  _innerclass.Outter$Inner

    outter1.foo(inner1) //  Outter1-Inner1
    //  Wrong!! type mismatch
    //    outter1.foo(inner2)

    outter1.foo2(inner2)  //  Outter2-Inner2
  }

}

class Outter(val name: String) {
  outter =>

  class Inner(val name: String) {
    def desc = s"${Outter.this.name}-$name"

    def desc2 = s"${outter.name}-$name"
  }

  def foo(bar: Inner): Unit = {
    println(bar.desc)
  }

  def foo2(bar: Outter#Inner): Unit = {
    println(bar.desc2)
  }
}
