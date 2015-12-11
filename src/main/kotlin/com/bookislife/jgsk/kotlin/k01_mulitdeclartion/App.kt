package com.bookislife.jgsk.kotlin.k01_mulitdeclartion

/**
 * Created by SidneyXu on 2015/12/08.
 */
fun main(args: Array<String>) {
    val person = Person("Jane", 20)
    val  (name, age) = person
    val pname = person.component1()
    println("name=$name, age=$age, pname=$pname")    //  name=Jane, age=20, pname=Jane

    var n1 = person
    println(n1) //  @30f39991
    val (n2) = person
    println(n2) //  Jane
}

class Person(val name: String, val age: Int) {
    operator fun component1(): String {
        return name
    }

    operator fun component2(): Int {
        return age
    }
}