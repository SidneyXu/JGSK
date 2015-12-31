package com.bookislife.jgsk.scala._27_generics

/**
  * Created by SidneyXu on 2015/12/31.
  */
class Holder[A](val a: A) {
}

class CovariantHolder[+A](val a: A) {
  def foo(): A = {
    a
  }
}

class ContravarintHolder[-A]() {
  def foo(p: A): Unit = {
  }
}