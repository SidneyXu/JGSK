package com.bookislife.jgsk.kotlin.k07_inline_function

import java.util.concurrent.locks.Lock
import java.util.concurrent.locks.ReentrantLock
import javax.swing.tree.DefaultMutableTreeNode
import javax.swing.tree.TreeNode

/**
 * Created by SidneyXu on 2015/12/29.
 */
fun main(args: Array<String>) {
    //  Inline Function
    val lock = ReentrantLock()
    inlineLock(lock, { echo() }, { println("init") })

    //  Non-local returns
    val list = listOf(1, 2, 3, 0)
    val result = localReturn(list)
    println(result)

    //  Reified type parameters
    val root = DefaultMutableTreeNode("root")
    val node1 = DefaultMutableTreeNode("node1")
    val node1_1 = DefaultMutableTreeNode("node1_1")
    val node2 = DefaultMutableTreeNode("node2")
    node1.add(node1_1)
    root.add(node1)
    root.add(node2)

    var parent = node1_1.findParentOfType(DefaultMutableTreeNode::class.java)
    println(parent) //  node1
    parent = node1_1.inlineFindParentOfType()
    println(parent) //  node1

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

fun localReturn(list: List<Int>): Boolean {
    contains {
        for (i in list) {
            if (i == 0) return true
        }
        return false
    }
    return false
}

inline fun contains(f: () -> Boolean): Boolean {
    return f()
}

//  Cross Line
fun crosslineReturn(list: List<Int>): Unit {
    crosslineFun {
    }
}

inline fun crosslineFun(crossinline f: () -> Unit): Unit {
    Thread {
        f()
    }.start()
}

//  Reified type parameters
fun <T> TreeNode.findParentOfType(clazz: Class<T>): T? {
    var p = parent
    while (p != null && !clazz.isInstance(p)) {
        p = p.parent
    }
    @Suppress("UNCHECKED_CAST")
    return p as T
}

inline fun <reified T> TreeNode.inlineFindParentOfType(): T? {
    var p = parent
    while (p != null && p !is T) {
        p = p.parent
    }
    return p as T
}
