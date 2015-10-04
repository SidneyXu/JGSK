package com.bookislife.jgsk.java._22_package;

import com.bookislife.jgsk.java._22_package.b.B;

/**
 * Created by SidneyXu on 2015/10/03.
 */
public class A {
    public void foo() {
        B b = new B();
        b.foo();
        System.out.println(Constants.VERSION);
    }
}

class C extends B {
    public void foo() {
        protectedFoo();
    }
}

