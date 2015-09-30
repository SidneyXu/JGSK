package com.bookislife.jgsk.kotlin._21_exception

import java.io.FileNotFoundException

/**
 * Created by SidneyXu on 2015/09/30.
 */
fun main(args: Array<String>) {
    //  Try..Catch..Finally
    try {
        throw  FileNotFoundException("File not found.")
    } catch(e: FileNotFoundException) {
        println("Catch block")
    } finally {
        println("Finally block")
    }

    //  Exception in Callbacks
    val bean = MyBean()
    try {
        bean.test()

        bean.callback {
            throw  FileNotFoundException("File not found.")
        }
    } catch(e: Exception) {
        println("Some errors occur.")
    } finally {
    }

    //  Exception value
    val n = 4
    val half =
            if (n % 2 == 0)
                n / 2
            else
                throw  RuntimeException("n must be even")
    println(half) //  2


    //  Return value in finally
    val m = try {
        "99".toInt()
    } catch(e: Exception) {
        -99
    }
    println(m)

    //  Illegal!
    //    fun f(): Int = try {
    //        return 1
    //    } finally {
    //        return 2
    //    }

    fun f2(): Int {
        try {
            return 1
        } finally {
            return 2
        }
    }

    fun g(): Int = try {
        1
    } finally {
        2
    }

    //  Illegal!
    //    fun q(): Int = try {
    //        return 1
    //    } finally {
    //    }

    println(f2()) //  2
    println(g()) //  1

}

class MyBean {

    @throws(MyException::class, FileNotFoundException::class)
    fun test() {

    }

    fun callback(callback: () -> Unit) {
        try {
            callback()
        } catch(e: FileNotFoundException) {
            println("Some errors occur in closure.")
        } catch(e: MyException) {
            println("Some errors occur in closure.")
        }
    }
}

class MyException : Exception() {

}