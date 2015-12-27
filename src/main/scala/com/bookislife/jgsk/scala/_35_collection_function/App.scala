package com.bookislife.jgsk.scala._35_collection_function

import scala.io.Source

/**
  * Created by SidneyXu on 2015/12/24.
  */
object App {

    def main(args: Array[String]) {
        val numbers1 = List(1, 2, 3, 4, 5, 6)
        val numbers2 = List(10, 20, 30)
        val numbers3 = List(numbers1, numbers2)

        //  Map
        val mapResult: List[Int] = numbers1.map(x => x * x)
        println(s"map => $mapResult") //  List(1, 4, 9, 16, 25, 36)

        //  FlatMap
        val flatMapResult: List[Int] = numbers3.flatMap(list => list.map(x => x * 10))
        println(s"flatMap => $flatMapResult") //  List(10, 20, 30, 40, 50, 60, 100, 200, 300)
        println(s"flatten => ${numbers3.flatten}") //  List(1, 2, 3, 4, 5, 6, 10, 20, 30)

        //  Zip
        val zipResult1: List[(Int, Int)] = numbers1.zip(numbers2)
        println(s"zip1 => $zipResult1") //  List((1,10), (2,20), (3,30))

        val zipResult2: List[(Int, Int)] = numbers2.zip(numbers1)
        println(s"zip2 => $zipResult2") //  List((10,1), (20,2), (30,3))

        val zipResult3: List[(Int, Any)] = numbers1.zipAll(numbers2, -1, 'a')
        println(s"zipAll => $zipResult3") //  List((1,10), (2,20), (3,30), (4,a), (5,a), (6,a))

        //  Reduce
        val reduceResult = numbers1.reduce((n1, n2) => n1 - n2)
        println(s"reduce => $reduceResult") //  -19

        val reduceLeftResult = numbers1.reduceLeft((n1, n2) => n1 - n2)
        println(s"reduceLeft => $reduceLeftResult") //  -19

        val reduceRightResult = numbers1.reduceRight((n1, n2) => n1 - n2)
        println(s"reduceRight => $reduceRightResult") //  -3

        //  Fold
        val foldLeftResult = numbers1.foldLeft(2)((n1, n2) => n1 - n2)
        println(s"foldLeft => $foldLeftResult") //  -19

        val foldRightResult = numbers1.foldRight(0)((n1, n2) => n1 - n2)
        println(s"foldRight => $foldRightResult") //  -3

        //  Filter
        val filterResult = numbers1.filter(_ % 2 == 0)
        println(s"filter => $filterResult") //  List(2, 4, 6)

        //  Collect
        val collectResult = numbers1.collect(PartialFunction[Int, Option[Int]] {
            case x if x % 2 == 0 => Some(x)
            case _ => None
        })
        println(s"collect => $collectResult") //  List(None, Some(2), None, Some(4), None, Some(6))

        //  ForEach
        numbers1.foreach(println)

        //  Parallel
        numbers1.par.foreach(println)
        val parallelResult = numbers1.par.map((x) => {
            println(s"stream first: $x on ${Thread.currentThread().getName}")
            x
        }).map((x) => {
            println(s"stream second: $x on ${Thread.currentThread().getName}")
            x
        }).map((x) => {
            println(s"stream third: $x on ${Thread.currentThread().getName}")
            x
        })
        println(parallelResult)
    }

    def testParallelProcessCollection(): Unit = {

        val urls = List("http://scala-lang.org",
            "https://github.com/SidneyXu")

        def fromURL(url: String) = Source.fromURL(url)
                .getLines().mkString("\n")

        val t = System.currentTimeMillis()
        //    urls.map(fromURL(_))
        //  par for Parallel Process
        urls.par.map(fromURL)

        println("time: " + (System.currentTimeMillis - t) + "ms")
    }

    def testParallelWordCount(): Unit = {
        val file = List("warn 2013 msg", "warn 2012 msg",
            "error 2013 msg", "warn 2013 msg")

        def wordcount(str: String): Int = str.split(" ").count("msg" == _)

        val num = file.par.map(wordcount).par.reduceLeft(_ + _)

        println("wordcount:" + num)
    }

}
