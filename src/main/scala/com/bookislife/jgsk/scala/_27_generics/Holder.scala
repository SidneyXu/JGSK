package com.bookislife.jgsk.scala._27_generics

/**
 * Created by mrseasons on 2015/10/08.
 */
class Holder[A](a: A) {
  def info = println(a)
}

class CovariantHolder[+A](a: A) {
  def info = println(a)
}

class ContravarintHolder[-A](a: A) {
  def info = println(a)
}