package com.bookislife.jgsk.kotlin._22_package

import com.bookislife.jgsk.kotlin._22_package.b.B as b

/**
 * Created by SidneyXu on 2015/10/03.
 */
class A {
    fun foo() {
        val b = b()
        b.foo()
        b.defaultFoo()
    }

    private fun privateFoo() {
    }
}

class C : b() {
    override fun foo() {
        protectedFoo()
    }
}

