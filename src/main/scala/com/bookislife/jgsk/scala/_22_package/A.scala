package com.bookislife.jgsk.scala._22_package


/**
 * Created by SidneyXu on 2015/10/03.
 */
class A {
  def foo(): Unit = {
    println(Constants.VERSION)
  }

  def privateFoo(): Unit = {
  }
}

object A extends App {
  new A().privateFoo()
}

import com.bookislife.jgsk.scala._22_package.b.{B, D}

class C extends B {
  private val x = 1

  def test(): Unit = {
    val x = new X
  }

  class X {
    private val y = 2

    def test(): Int = {
      val c = new C
      c.x
    }
  }

  override def foo(): Unit = {
    protectedFoo()
    def d = new D
    d.foo()
  }
}
