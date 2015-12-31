package com.bookislife.jgsk.kotlin._35_collection_function

/**
 * Created by SidneyXu on 2015/12/24.
 */
fun main(args: Array<String>) {
    val numbers1 = listOf(1, 2, 3, 4, 5, 6)
    val numbers2 = listOf(10, 20, 30)
    val numbers3 = listOf(numbers1, numbers2)

    //  Map
    val mapResult: List<Int> = numbers1.map { it * it }
    println("map => $mapResult")    //  [1, 4, 9, 16, 25, 36]

    //  FlatMap
    val flatMapResult: List<Int> = numbers3.flatMap { it.map { it * 10 } }
    println("flatMap => $flatMapResult") //  [10, 20, 30, 40, 50, 60, 100, 200, 300]
    println("flatten => ${numbers3.flatten()}") //  [1, 2, 3, 4, 5, 6, 10, 20, 30]

    //  Zip
    val zipResult1: List<Pair<Int, Int>> = numbers1.zip(numbers2)
    println("zip1 => $zipResult1")  //  [(1, 10), (2, 20), (3, 30)]

    val zipResult2: List<Pair<Int, Int>> = numbers2.zip(numbers1)
    println("zip2 => $zipResult2")  //  [(10, 1), (20, 2), (30, 3)]

    //  Reduce
    val reduceLeftResult = numbers1.reduce { n1, n2 -> n1 - n2 }
    println("reduce => $reduceLeftResult")  //  -19

    val reduceRightResult = numbers1.reduceRight { n1, n2 -> n1 - n2 }
    println("reduceRight => $reduceRightResult")    //  -3

    //  Fold
    val foldLeftResult = numbers1.fold(2) { n1, n2 -> n1 - n2 }
    println("foldLeft => $foldLeftResult")  //  -19

    val foldRightResult = numbers1.foldRight(0) { n1, n2 -> n1 - n2 }
    println("foldRight => $foldRightResult")    //  -3

    //  Filter
    val filterResult = numbers1.filter { it % 2 == 0 }
    println("filter => $filterResult")  //  [2, 4, 6]

    //  ForEach
    numbers1.forEach { println(it) }
}