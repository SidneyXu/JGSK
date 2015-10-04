package com.bookislife.jgsk.groovy._22_package.b

/**
 * Created by SidneyXu on 2015/10/03.
 */
class D {
    def foo() {
        def b = new B()
        b.foo()
        b.protectedFoo()
        b.defaultFoo()
        b.packageFoo()
    }
}
