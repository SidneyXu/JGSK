package com.bookislife.jgsk.groovy._35_collection_function

import java.util.function.Function

/**
 * Created by SidneyXu on 2015/12/24.
 */
class App {

    public static void main(String[] args) {
        def numbers1 = [1, 2, 3, 4, 5, 6]
        def numbers2 = [10, 20, 30]
        def numbers3 = [numbers1, numbers2]

        //  Map
        def mapResult = numbers1.stream().map(new Function<Integer, Integer>() {
            @Override
            Integer apply(Integer x) {
                x * x
            }
        })
        println("map => ${mapResult.toArray()}")

        //  Flatten
        println("flatten => ${numbers3.flatten()}") //  [1, 2, 3, 4, 5, 6, 10, 20, 30]

        //  Collect
        def collectResult = numbers1.collect {
            if (it % 2 == 0)
                it
            else
                null
        }
        println("collect => $collectResult")    //  [null, 2, null, 4, null, 6]

        //  ForEach
        numbers1.each { println(it) }
    }
}
