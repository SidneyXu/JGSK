package com.bookislife.jgsk.groovy._19_inherit

/**
 * Created by SidneyXu on 2015/09/29.
 */
class Button extends View implements OnClickListener {

    private def text

    @Override
    def onClick() {
        println("Click Button $text")
    }

    @Override
    def getDescription() {
        return text
    }
}