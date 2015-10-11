package com.bookislife.jgsk.groovy._25_regex

/**
 * Created by SidneyXu on 2015/10/10.
 */
class App {

    public static void main(String[] args) {
        def input = "99 bottles, 98 bottles"

        //  Pattern
        def pattern = ~/[0-9]+\W/

        //  Matching
        //  with precompiled regex
        if ("Hello" =~ ~/[A-Z][a-z]+/) {
            println("ok")
        }

        //  Searching
        for( matchString in input.findAll(pattern)){
            println("find all $matchString")    //  99  98
        }

        //  group
        ("2015-10" =~ /(\d{4})-(\d{2})/).each { match, year, month ->
            println(match)  //  2015-10
            println(year)   //  2015
            println(month)  //  10
        }
        "2015-10".find(/(\d{4})-(\d{2})/) {
            println(it) //  [2015-10, 2015, 10]
        }

        //  Replacing
        def matcher = input =~ pattern
        def result = matcher.replaceFirst("xxx")
        println(result) //  xxxbottles, 98 bottles

    }
}
