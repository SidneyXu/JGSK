package com.bookislife.jgsk.scala._18_object

/**
 * Created by SidneyXu on 2015/09/25.
 */
abstract class UndoableAction(val description: String) {
  def undo

  def redo
}

object DoNothing extends UndoableAction("Do nothing") {

  override def undo: Unit = {
    println("undo")
  }

  override def redo: Unit = {
    println("redo")
  }

}
