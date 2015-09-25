package com.bookislife.jgsk.scala._18_object

/**
 * Created by SidneyXu on 2015/09/25.
 */
object Singleton {
  private var num = 0

  def sequence() = {
    num += 1
    num
  }

}
