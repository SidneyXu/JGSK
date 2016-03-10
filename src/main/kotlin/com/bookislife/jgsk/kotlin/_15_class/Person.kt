package com.bookislife.jgsk.kotlin._15_class

import java.util.*

/**
 * Created by SidneyXu on 2015/09/22.
 */
class Person {
    //  Default Getter and Setter
    var age = 0

    //  Specify Getter and Setter
    var trueAge: Int
        get() = age
        set(pAge) {
            if (pAge > age) {
                age = pAge
            }
        }

    //  Backing field
    var backAge: Int = 0
        get() = field
        set(pAge) {
            if (pAge > field) {
                field = pAge
            }
        }

    // Change the visibility
    var setterVisiblity: String = "foo"
        private set

    //  Only getter
    val birthday = Date()

    fun say(message: String) {
        println(message)
    }
}