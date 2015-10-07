package com.bookislife.jgsk.groovy._23_trait

/**
 * Created by SidneyXu on 2015/10/05.
 */
trait ShortLogger implements Logger {

    final int maxLength = 15

    @Override
    void log(String msg) {
        println("--> Seeing msg in ShortLogger.")
        if (msg.length() <= maxLength)
            super.log(msg)
        else
            super.log(msg.substring(0, maxLength - 3) + "...")

    }
}