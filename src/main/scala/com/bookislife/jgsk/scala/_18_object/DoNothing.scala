package com.bookislife.jgsk.scala._18_object

/**
 * Created by mrseasons on 2015/2/13.
 */
object DoNothing extends UndoableAction("Do nothing") {

  override def undo: Unit = ???

  override def redo: Unit = ???

  def main(args: Array[String]) {
    val actions = Map("open" -> DoNothing, "save" -> DoNothing)
  }
}
