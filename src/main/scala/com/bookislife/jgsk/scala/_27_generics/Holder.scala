package com.bookislife.jgsk.scala._27_generics

/**
 * Created by mrseasons on 2015/10/08.
 */
class Holder[A](val a: A) {
}

class CovariantHolder[+A](val a: A) {
  def foo(): A = {
    a
  }
}

class ContravarintHolder[-A](val a: A) {
  def foo(p: A): Unit = {
  }
}