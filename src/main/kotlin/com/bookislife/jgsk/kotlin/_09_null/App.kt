package com.bookislife.jgsk.kotlin._09_null

/**
 * Created by SidneyXu on 2015/09/17.
 */
fun main(args: Array<String>) {
    //  Null
    var result = 0
    var x = null
    kotlin.io.println(x == null)
    kotlin.io.println(x.isNullOrEmpty())
    //  Wrong!! Found kotlin.String Require kotlin.Int
    //    result = x + 3

    //  Nullable types and Non-Null Types
    var nonNullString: String = "foo"
    //  Wrong!!
    //    nonNullString = null

    var nullableString: String? = "foo"
    nullableString = null

    //  Safe Operator
    var y: Int? = null
    val nullableResult: Int? = y?.plus(3)
    kotlin.io.println(nullableResult)

    //  Smart Cast
    //  Wrong!! Not allowed
    //    y + 3
    if (y != null) {
        println(y + 3)
    }


    //  The !! Operator
    y!!.plus(3)

}