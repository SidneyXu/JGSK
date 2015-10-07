package com.bookislife.jgsk.groovy._23_trait

/**
 * Created by SidneyXu on 2015/10/05.
 */
trait MessageHandler {
    //  Fields
    int minLength

    //  Methods
    //  Only support public and private
    //  Normal Method
    void echo(String msg) {
        println(msg)
    }

    //  Abstract Method
    abstract void show(String msg)
}
