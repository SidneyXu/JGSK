package com.bookislife.jgsk.kotlin._18_object

/**
 * Created by SidneyXu on 2015/11/15.
 */
fun main(args: Array<String>) {
    //  Object Declaration
    testSingleton()
    testCompanion()

    //  Object Expression
    //  like Java’s anonymous inner classes
    //  make a slight modification of some class
    val ab = object : A(1), B {
        override fun info() {
            println("info")
        }

        override val y: Int
            get() = 15
    }
    println(ab.y)
    println(ab.javaClass)

    val obj = object {
        val x = 10
        val y = 20
    }
    println(obj.x)
    println(obj.javaClass)
}

fun testSingleton() {
    assert(1 == Singleton.sequence())
    assert(2 == Singleton.sequence())
    assert(3 == Singleton.sequence())
}

fun testCompanion() {
    val account = Companion.create(30)
    assert(1 == account.id)
    assert("Balance is 30" == Companion.getInfo(account))
}

//  Object declaration
object Singleton {
    private var num = 0

    fun sequence(): Int {
        num += 1
        return num
    }

}

class Companion(private var balance: Int = 0) {
    //  Access private method of companion object
    val id = Companion.sequence()

    companion object Factory {
        private var num = 0

        fun getInfo(account: Companion): String {
            return "Balance is " + account.balance
        }

        fun create(initBalance: Int): Companion {
            return Companion(initBalance)
        }

        private fun sequence(): Int {
            num += 1
            return num
        }
    }
}

//  Wrong
//object Companion{
//}

//  Object expression
open class A(x: Int) {
    public open val y: Int = x
}

interface B {
    fun info()
}
