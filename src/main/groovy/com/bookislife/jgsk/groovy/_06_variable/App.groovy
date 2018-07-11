package com.bookislife.jgsk.groovy._06_variable

/**
 * Created by SidneyXu on 2015/09/16.
 */
class App {

    static void main(String[] args) {
        //  Variable
        String variable = "foo"
        variable = "bar"

        Date date = new Date()
//        date = 10

        String str = "10"
        str = new Date()
        println(str)

        def foo = "foo"
        foo = 10

        //  Constant
        final String constant = "foo"
        // Bug fix after 2.5.0, see https://issues.apache.org/jira/browse/GROOVY-1628
        // constant = 10
    }
}
