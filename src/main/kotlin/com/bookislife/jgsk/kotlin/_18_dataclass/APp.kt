package com.bookislife.jgsk.kotlin._18_dataclass

/**
 * Created by SidneyXu on 2015/09/25.
 */
fun main(args: Array<String>) {
    //  Data classes
    val peter = Customer("Peter", "peter@example.com")

    //  Copying
    val peter2 = peter.copy()
    val peter3 = peter.copy(name = "")

    println(peter2)
    println(peter3)

    //  Component Function
    val (name, email) = peter
    println("name=$name,email=$email")
}

//  Data Class
//  do nothing but hold data
//  provides the following functionality
// getters (and setters in case of var’s) for all properties
// equals()/hashCode()
// toString()
// copy()
// componentN()
data class Customer(var name: String, var email: String)
