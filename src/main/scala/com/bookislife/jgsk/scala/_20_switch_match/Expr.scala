package com.bookislife.jgsk.scala._20_switch_match

/**
 * Created by SidneyXu on 2015/09/24.
 */
//  Define
case class Number(n: Int) {
  var comment: String = "Default Comment"

  def eval: Int = n
}

case class Sum(n1: Number, n2: Number) {
  var comment: String = "Default Comment"

  def eval: Int = n1.eval + n2.eval
}