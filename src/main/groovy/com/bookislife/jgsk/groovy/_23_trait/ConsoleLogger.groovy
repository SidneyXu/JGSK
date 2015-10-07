package com.bookislife.jgsk.groovy._23_trait

/**
 * Created by SidneyXu on 2015/10/05.
 */
class ConsoleLogger implements Logger{
    @Override
    void log(String msg) {
        println(msg)
    }
}
