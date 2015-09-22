package com.bookislife.jgsk.kotlin._15_class

/**
 * Created by SidneyXu on 2015/06/05.
 */
//  Primary Constructor
//  Var for mutable and val for read-only
class Man(val name: String,
          var age: Int,
          private var from: String = "USA") {

    init {
        println("Sentences in primary constructor")
    }

    //  Secondary Constructor
    //  Delegate to the primary constructor
    constructor(name: String) : this(name, 0) {
    }

    constructor(age: Int) : this("Default Name", age) {
    }

    constructor() : this("Default Name") {
    }
}

class Woman private constructor(val name: String, val age: Int) {
    constructor(name: String) : this(name, 0) {

    }
}

class Empty