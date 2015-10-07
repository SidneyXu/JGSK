package com.bookislife.jgsk.groovy._23_trait

/**
 * Created by SidneyXu on 2015/10/05.
 */
class DefaultMessageHandler implements MessageHandler {

    @Override
    void show(String msg) {
        println(msg)
    }
}
