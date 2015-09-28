package com.bookislife.jgsk.java._17_innerclass;

/**
 * Created by SidneyXu on 2015/09/28.
 */
public class App {

    public static void main(String[] args) {
        //  Static Inner Class
        Outter.StaticInner staticInner = new Outter.StaticInner();

        //   Anonymous Inner Classes
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });

        //  Non-Static Inner Class
        Outter outter1 = new Outter("Outter1");
        Outter.Inner inner1 = outter1.new Inner("Inner1");

        Outter outter2 = new Outter("Outter2");
        Outter.Inner inner2 = outter2.new Inner("Inner2");

        System.out.println("outter1 is " + outter1.getClass()); //  _innerclass.Outter
        System.out.println("outter2 is " + outter2.getClass()); //  _innerclass.Outter
        System.out.println("inner1 is " + inner1.getClass());   //  _innerclass.Outter$Inner
        System.out.println("inner2 is " + inner2.getClass());   //  _innerclass.Outter$Inner

        outter1.foo(inner1);    //  Outter1-Inner1
        outter1.foo(inner2);    //  Outter2-Inner2
    }


}

class Outter {

    private String name;

    public Outter(String name) {
        this.name = name;
    }

    static class StaticInner {
    }

    public class Inner {
        private String name;

        public Inner(String name) {
            this.name = name;
        }

        public String desc() {
            return Outter.this.name + "-" + name;
        }
    }

    public void foo(Inner bar) {
        System.out.println(bar.desc());
    }
}
