package com.bookislife.jgsk.kotlin._09_null

/**
 * Created by SidneyXu on 2015/09/17.
 */
fun main(args: Array<String>) {
    //  Null
    var result = 0
    var x = null
    println(x == null)
    println(x.isNullOrEmpty())
    println(x.isNullOrBlank())

    //  NullPointerException
    //  Nullable types and Non-Null Types
    var nonNullString: String = "foo"
    //  Wrong!!
    //    nonNullString = null

    var nullableString: String? = "foo"
    nullableString = null

    //  Safe Operator
    val persons = listOf(null, Person("Peter"))
    for (p in persons) {
        println(p?.name)
    }

    var y: Int? = null
    val nullableResult: Int? = y?.plus(3)
    println(nullableResult)

    //  The !! Operator
    y = 10
    val nullableSum: Int? = y?.plus(3)
    val nonNullSum: Int = y!!.plus(3)

    //  Safe Case
    val xInt: Int? = x as? Int
}

class Person(val name: String) {
}