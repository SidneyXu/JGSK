package com.bookislife.jgsk.groovy._35_collection_function

/**
 * Created by SidneyXu on 2015/12/24.
 */
class App {

    public static void main(String[] args) {
        def numbers1 = [1, 2, 3, 4, 5, 6]
        def numbers2 = [10, 20, 30]
        def numbers3 = [numbers1, numbers2]

        //  Map -> Collect
        def mapResult = numbers1.collect { it * it }
        println("map => ${mapResult}")    //  [1, 4, 9, 16, 25, 36]

        //  FlatMap -> CollectMany
        def flatMapResult = numbers3.collectMany { it.collect { it * 10 } }
        println("flatMap => ${flatMapResult}")    //   [10, 20, 30, 40, 50, 60, 100, 200, 300]
        println("flatten => ${numbers3.flatten()}")    //  [1, 2, 3, 4, 5, 6, 10, 20, 30]

        //  Zip -> Transpose
        def zipResult1 = [numbers1, numbers2].transpose()
        println("zip1 => $zipResult1")    //  [[1, 10], [2, 20], [3, 30]]

        def zipResult2 = [numbers2, numbers1].transpose()
        println("zip2 => $zipResult2")  //  [[10, 1], [20, 2], [30, 3]]

        //  Fold -> Inject
        def foldLeftResult = numbers1.inject(2) { n1, n2 -> n1 - n2 }
        println("foldLeft => $foldLeftResult")  //  -19

        //  Filter -> FindAll
        def filterResult = numbers1.findAll { it % 2 == 0 }
        println("filter => $filterResult")  //  [2, 4, 6]

        //  ForEach
        numbers1.each { println(it) }
    }
}
