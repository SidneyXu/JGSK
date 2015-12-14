package com.bookislife.jgsk.kotlin._15_class

/**
 * Created by SidneyXu on 2015/09/022.
 */
fun main(args: Array<String>) {
    testPerson()
    testMan()
}

fun testPerson() {

    val person = Person()
    person.age = 10
    println(person.age) //  10

    person.trueAge = 20
    person.trueAge = 14
    println(person.trueAge)  //  20

    person.backAge = 30
    person.backAge = 15
    println(person.backAge) //  30
}

fun testMan() {
    //no keyword: new
    val fred = Man("Fred", 21)   //  Primary Constructor
    val peter = Man("Peter")  //  Secondary Constructor
    val jack = Man(21)      //  Secondary Constructor

    //  Wrong!! Primary Constructor is private.
    //    val mary = Woman("Mary",21)
    val jane = Woman("Jane")
}
