package com.bookislife.jgsk.groovy._22_package

import com.bookislife.jgsk.groovy._22_package.b.B
import groovy.transform.CompileStatic

/**
 * Created by SidneyXu on 2015/10/03.
 */
class A {

    @CompileStatic
    public def foo() {
        def b = new B()
        b.foo()
        b.defaultFoo()
//        b.packageFoo()
    }

    public static void main(String[] args) {
        new A().foo()
    }

}

class C extends B {
    public def foo() {
        protectedFoo()
    }
}