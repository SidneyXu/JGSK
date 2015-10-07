package com.bookislife.jgsk.scala._23_trait

/**
 * Created by SidneyXu on 2015/10/05.
 */
class DefaultMessageHandler extends MessageHandler {

    override val minLength: Int = 100

    //  Abstract method
    override def show(msg: String): Unit = {
        println(msg)
    }
}
