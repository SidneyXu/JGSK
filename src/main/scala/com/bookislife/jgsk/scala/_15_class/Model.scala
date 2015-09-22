package com.bookislife.jgsk.scala._15_class

import scala.beans.{BeanProperty, BooleanBeanProperty}

/**
 * Created by SidneyXu on 2015/09/22.
 */
class Model {

  @BeanProperty
  var name: String = ""

  @BooleanBeanProperty
  var visible = false
}
