package com.bookislife.jgsk.kotlin.k07_inline_function

import java.util.concurrent.locks.Lock
import java.util.concurrent.locks.ReentrantLock
import javax.swing.tree.TreeNode

/**
 * Created by SidneyXu on 2015/12/29.
 */
fun main(args: Array<String>) {
    //https://kotlinlang.org/docs/reference/inline-functions.html

    //  Inline Function
    val lock = ReentrantLock()
    lock.lock()
    try {
        echo()
    } finally {
        lock.unlock()
    }
    inlineLock(lock, { echo() }, { println("init") })

    //  Non-local returns

}

fun echo() = println("foo")

//  Inline Function
inline fun <T> inlineLock(lock: Lock, body: () -> T,
                          noinline notInlined: () -> T): T {
    lock.lock()
    try {
        return body()
    } finally {
        lock.unlock()
    }
}

fun foo(): String {
    fun bar(): String {
        return "foobar"
    }
    return "_"
}

//fun foo2(): String {
//    inline fun bar2(): String {
//        return "foobar"
//    }
//    return "_"
//}

fun hasZeros(ints: List<Int>): Boolean {
    ints.forEach {
        if (it == 0) return true // returns from hasZeros
    }
    return false
}

fun <T> TreeNode.findParentOfType(clazz: Class<T>): T? {
    var p = parent
    while (p != null && !clazz.isInstance(p)) {
        p = p?.parent
    }
    @Suppress("UNCHECKED_CAST")
    return p as T
}