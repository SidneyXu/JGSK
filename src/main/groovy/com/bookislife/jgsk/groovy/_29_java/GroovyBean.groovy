package com.bookislife.jgsk.groovy._29_java

/**
 *  Created by SidneyXu on 2015/10/20.
 */
class GroovyBean {

    def name

    GroovyBean(name) {
        this.name = name
    }


    def calc(x, y) {
        x + y
    }

    static def hello(GroovyBean bean) {
        println("Hello, this is ${bean.name}")
    }
}
