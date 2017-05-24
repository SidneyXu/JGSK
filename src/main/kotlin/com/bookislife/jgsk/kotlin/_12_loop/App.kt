package com.bookislife.jgsk.kotlin._12_loop

/**
 * Created by SidneyXu on 2015/09/19.
 */
fun main(args: Array<String>) {
    testFor()
    testWhile()
    testRange()
    testRepeat()
    testBreakAndContinue()
}

private fun testFor() {
    val arr = intArrayOf(1, 2, 3)
    for (a in arr) {
        println("Repeat For-Each $a")
    }

    for (i in arr.indices) {
        println("Repeat For-indices ${arr[i]}")
    }
}

private fun testWhile() {
    val arr = intArrayOf(1, 2, 3)
    var i = 0
    while (i < arr.size) {
        println("Repeat While ${arr[i++]}")
    }
    i = 0
    do {
        i++
        println("Repeat Do-While $i")
    } while (i < 5)
}


private fun testRange() {
    for (a in 0..3)
        println("Repeat Range $a")
    println("=====================")

    for (a in 3 downTo 0)
        println("Repeat Reverse-Range $a")
    println("=====================")

    for (a in (1..4).reversed())
        println("Repeat Reverse-Range $a")

    for (a in 0..5 step 2)
        println("Repeat Range with Step $a")
    println("=====================")

    for (i in 1..4 step 2) print(i)

}

private fun testRepeat() {
    repeat(3) {
        println("Repeat $it times")
    }
}

private fun testBreakAndContinue() {
    for (i in 1..5) {
        if (i == 3) continue
        println("Continue $i")
    }
    for (i in 1..5) {
        if (i == 3) break
        println("Break $i")
    }
}