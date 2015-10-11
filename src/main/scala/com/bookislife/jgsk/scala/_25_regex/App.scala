package com.bookislife.jgsk.scala._25_regex

/**
 * Created by SidneyXu on 2015/10/10.
 */
object App {

    def main(args: Array[String]) {
        val input = "99 bottles, 98 bottles"

        //  Regex
        val pattern = """[0-9]+\W""".r

        //  Matching
        if ("Hello".matches("[A-Z][a-z]+"))
            println("ok")

        //  Searching
        for (matchString <- pattern.findAllIn(input)) {
            println(s"find all $matchString") //  99  98
        }

        //  group
        //  named group
        """(\d{4})-(\d{2})""".r("year", "month").findAllIn("2015-10").matchData.foreach { m =>
            println(m.group("year")) //  99
            println(s"group count is ${m.groupCount}") //  2
            for (i <- 0 to m.groupCount)
                println(s"group $i is ${m.group(i)}") //  [2015-10, 2015, 10]
        }

        val pattern2 = "[A-Z][a-z]+".r
        "Hello" match {
            case pattern2(c) => println("ok")
            case _ =>
        }

        //  Replacing
        val result = pattern.replaceFirstIn(input, "xxx")
        println(result) //  xxxbottles, 98 bottles

    }
}
