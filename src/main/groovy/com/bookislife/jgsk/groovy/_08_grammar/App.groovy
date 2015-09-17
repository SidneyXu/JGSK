package com.bookislife.jgsk.groovy._08_grammar

/**
 * Created by SidneyXu on 2015/09/17.
 */
class App {

    public static void main(String[] args) {
        //  Operators
        def i = 1
        i++
        i += 3
        i + 3
        i.plus("3")

        //  Elvis Operator
        String agentStatus = "Active"
//        String status = (agentStatus !=null && !"".equals(agentStatus)) ? "Active" : "Inactive"
        String status = agentStatus ?: "Inactive"
        println(status)

        //  Call Methods
        println add(1, 2)

        //  Equals
        Date x = new Date(100);
        Date y = new Date(100);

        println(null == 10) //  false
        println("x==y: " + (x == y))    //  true
        println("x.equals(y): " + x.equals(y))  //  true
        println("x.is(y): " + x.is(y))  //  false
    }

    static int add(x, y) {
        x + y
    }

}
