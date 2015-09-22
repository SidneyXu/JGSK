package com.bookislife.jgsk.groovy._15_class

/**
 * Created by SidneyXu on 2015/09/22.
 */
class Person {

    //  Default Getter and Setter
    def age

    //  Specify Getter and Setter
    private def privateAge

    def getPrivateAge() {
        return privateAge
    }

    def setPrivateAge(n) {
        if (n > privateAge) {
            privateAge = n
        }
    }

    def say(message) {
        println(message)
    }

}
