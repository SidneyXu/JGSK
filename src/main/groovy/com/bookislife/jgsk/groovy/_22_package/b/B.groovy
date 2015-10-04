package com.bookislife.jgsk.groovy._22_package.b

import groovy.transform.PackageScope

/**
 * Created by SidneyXu on 2015/10/03.
 */
class B {
    public def foo() {
        privateFoo()
    }

    def defaultFoo() {

    }

    private def privateFoo() {

    }

    protected def protectedFoo() {

    }

    @PackageScope
    def packageFoo() {
    }
}
