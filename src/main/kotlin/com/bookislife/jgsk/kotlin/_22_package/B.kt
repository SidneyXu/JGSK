package com.bookislife.jgsk.kotlin._22_package.b

import com.bookislife.jgsk.kotlin._22_package.A

/**
 * Created by SidneyXu on 2015/10/03.
 */
open class B {
    public open fun foo() {
        privateFoo()
        val a= A()
        a.foo()
    }

    fun defaultFoo() {
    }

    private fun privateFoo() {
    }

    protected fun protectedFoo() {
    }
}

class D {
    fun foo() {
        val b = B()
        b.foo()
        b.defaultFoo()
    }
}