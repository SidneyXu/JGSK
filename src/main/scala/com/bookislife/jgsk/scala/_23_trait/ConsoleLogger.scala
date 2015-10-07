package com.bookislife.jgsk.scala._23_trait

/**
 * Created by SidneyXu on 2015/10/04.
 */
class ConsoleLogger extends Logger with Cloneable with Serializable {
    //  Overrides abstract field
    val minLength: Int = 1

    //  Overrides abstract method
    override def log(msg: String): Unit = println(msg)
}
