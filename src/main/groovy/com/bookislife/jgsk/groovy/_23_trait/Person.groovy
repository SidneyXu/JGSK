package com.bookislife.jgsk.groovy._23_trait

/**
 * Created by SidneyXu on 2015/10/05.
 */
class Person implements Greetable {

    String name

    @Override
    String name() {
        return name
    }
}