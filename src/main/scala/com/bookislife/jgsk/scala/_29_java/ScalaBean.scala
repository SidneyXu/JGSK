package com.bookislife.jgsk.scala._29_java

import scala.beans.BeanProperty

/**
 * Created by mrseasons on 2015/05/16.
 */
class ScalaBean(@BeanProperty var name: String) {
  def say = "hello scala"
}
