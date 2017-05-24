package com.bookislife.jgsk.groovy._13_collection

/**
 * Created by SidneyXu on 2015/09/20.
 */
class App {

    static void main(String[] args) {
        testArray()
        testList()
        testRange()
    }

    static def testArray() {
        //  Define
        def arr = new int[3]
        def arr2 = [1, 2, 3] as int[]

        //  Length
        println(arr.length)

        //  Modify Elements
        arr[0] = 10

        //  Access Elements
        println(arr[0])

        //  Traverse
        for (int a : arr2) {
            println("Traverse " + a)
        }
    }

    static def testList() {
        //  Define
        // Empty List
        def emptyList = []
        def list = ["Groovy", "Java", "Scala"]
        assert list instanceof Collection
        assert list instanceof ArrayList

        //  Length
        println(list.size())

        //  Modify List
        //  Add Elements
        list.add("Rust")
        list << "Kotlin"
        list[10] = "Ruby"

        //  Modify Elements
        list.putAt(9, "Python")
        println list
        //[Groovy, Java, Scala, Rust, Katlin, null, null, null, null, null, Python, Ruby]

        //  Delete Elements
        list.remove(1)

        //  Access Elements
        println list[2]         //Scala
        println list.get(2)     //Scala
        println list[-1]        //Ruby
        println list[-1..-2]    //[Ruby, Python]

        //  New List
        def newList = list - ["Ruby", "Rust", "Kotlin"] + "Swift"
        println list
        //[Groovy, Java, Scala, Rust, Katlin, null, null, null, null, null, Ruby]
        println newList           //[Groovy, Java, Scala, null, null, null, null, null, Swift]

        //  Spread Operator
        def numbers = [1, 2, 3, 4, 3, 4]
        def numbers2 = numbers*.plus(10)
        println(numbers)            //[1, 2, 3, 4, 3, 4]
        println(numbers2)           //[11, 12, 13, 14, 13, 14]

        // Other Methods
        println numbers.join(",")   //1,2,3,4,3,4
        println numbers.count(3)    //2

        list = [1, 2, 3, [4, 5]]
        println list.flatten()                  //[1, 2, 3, 4, 5]
        println list.intersect([3, 4, 5])       //[3]
        println list.pop()                      //[4, 5]
        println list.reverse()                  //[3, 2, 1]
        println list.sort()                     //[1, 2, 3]

        //  Traverse
        for (lang in list) {
            println("Traverse " + lang)
        }
    }

    static void testRange() {
        def rng1 = 1..3
        println(rng1)   //  [1, 2, 3]

        def rng2 = 1..<3
        println(rng2)   //  [1, 2]

        def rng3 = (1..5).step(2)
        println(rng3)   //  [1, 3, 5]

        def rng4 = 'a'..'c'
        println(rng4)   //  [a, b, c]

    }
}
