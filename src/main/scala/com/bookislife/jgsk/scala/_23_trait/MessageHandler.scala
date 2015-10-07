package com.bookislife.jgsk.scala._23_trait

/**
 * Created by SidneyXu on 2015/10/05.
 */
trait MessageHandler {
    //  Fields
    val minLength: Int

    //  Methods
    //  Normal method
    def echo(msg: String) {
        println(msg)
    }

    //  Abstract method
    def show(msg: String)
}
