package com.bookislife.jgsk.scala._23_trait

/**
 * Created by SidneyXu on 2015/10/04.
 */
trait ShortLogger extends Logger {
    val maxLength = 15

    override def log(msg: String): Unit = {
        super.log(
            if (msg.length <= maxLength) msg else msg.substring(0, maxLength - 3) + "..."
        )
    }
}
