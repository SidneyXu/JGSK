package com.bookislife.jgsk.scala._23_trait

import java.util.Date

/**
 * Created by SidneyXu on 2015/10/04.
 */
trait TimeStampLogger extends Logger {
    override def log(msg: String): Unit = {
        super.log(new Date() + " " + msg)
    }
}
