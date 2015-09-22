package com.bookislife.jgsk.kotlin._15_class

import java.util.Date

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

    //  Backing field should start with "$"
    //  Must be initialized first
    //  if not using "$", backAge will call the getter and stack overflow may occurs
    var backAge: Int = 0
        get() = $backAge
        set(pAge) {
            if (pAge > $backAge) {
                $backAge = pAge
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