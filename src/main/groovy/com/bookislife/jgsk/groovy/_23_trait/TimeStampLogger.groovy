package com.bookislife.jgsk.groovy._23_trait

/**
 * Created by SidneyXu on 2015/10/05.
 */
trait TimeStampLogger implements Logger {
    @Override
    void log(String msg) {
        println("--> Seeing msg in TimeStampLogger.")
        super.log(new Date().toString() + " " + msg)
    }

}