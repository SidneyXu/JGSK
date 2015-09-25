package com.bookislife.jgsk.kotlin._18_dataclass

import java.util.ArrayList

/**
 * Created by SidneyXu on 2015/09/25.
 */
fun main(args: Array<String>) {
    //  New Instance
    val peter = Customer("Peter", "peter@example.com", arrayListOf("Jane", "Tom"))

    //  Copying
    val tom = peter.copy()
    val jane = peter.copy(name = "")
    peter.friends.add("Tina")

    println(peter)  //  Customer(name=Peter, email=peter@example.com, friends=[Jane, Tom, Tina])
    println(tom)    //  Customer(name=Peter, email=peter@example.com, friends=[Jane, Tom, Tina])
    println(jane)   //  Customer(name=, email=peter@example.com, friends=[Jane, Tom, Tina])

    //  Component Function
    val (name, email) = peter
    println("name=$name, email=$email")
}

//  Define
data class Customer(var name: String, var email: String, var friends: ArrayList<String>)