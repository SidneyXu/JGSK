package com.bookislife.jgsk.scala._18_object

/**
 * Created by mrseasons on 2015/2/13.
 */
abstract class UndoableAction(val description: String) {
  def undo

  def redo
}
