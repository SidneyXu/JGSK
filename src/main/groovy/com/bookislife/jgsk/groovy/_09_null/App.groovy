package com.bookislife.jgsk.groovy._09_null

/**
 * Created by SidneyXu on 2015/09/17.
 */
class App {

    public static void main(String[] args) {
        //  Null
        Integer x = null
        println(x == null)
        println(x.is(null))

        //  NullPointerException
        //  Safe Operator
        List<Person> persons = [null, new Person("Peter")]
        for (Person p : persons) {
            println(p?.name)
        }

    }

    static class Person {
        def name

        public Person(name) {
            this.name = name
        }
    }
}
