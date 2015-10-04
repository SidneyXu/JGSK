package com.bookislife.jgsk.scala._22_package.b

import com.bookislife.jgsk.scala._22_package.A

/**
 * Created by SidneyXu on 2015/10/03.
 */
class B {
  def foo(): Unit = {
    privateFoo()
    def a = new A
    a.foo()
    a.privateFoo()
  }

  private def privateFoo(): Unit = {

  }

  protected def protectedFoo(): Unit = {
  }

}

class D {
  def foo(): Unit = {
    val b = new B
    b.foo()
  }
}