package com.bookislife.jgsk.groovy._14_map

/**
 * Created by SidneyXu on 2015/09/21.
 */
class App {

    public static void main(String[] args) {
        testMap()
        testTuple()
    }

    private static void testMap() {
        //  Define
        //  Empty Map
        def emptyMap = [:]
        def map = [name: "Peter", "age": 12, "national": "USA"]
        assert map.getClass().getName() == "java.util.LinkedHashMap"

        //  Put
        map.put("name", "Jane")
        map.age = 20
        map["sex"] = "Female"
        map.id = 10

        //  Delete
        map.remove("age")

        //  Get
        assert map.get("name") == "Jane"
        assert map["name"] == "Jane"
        assert map.name == "Jane"

        assert map.getOrDefault("height", 170) == 170

        println(map)

        //  Length
        println(map.size())

        //  Traverse
        for (entry in map) {
            println("Traverse ${entry.key} is ${entry.value}")
        }
    }

    private static void testTuple() {
        //  Define
        def t1 = new Tuple()
        def t2 = new Tuple(1, 2, 3)
        def t3 = new Tuple(1, "abc", [10, 20, 30], [name: "Peter", "age": 12])

        //  Put
        //  Wrong!! UnsupportedOperationException
        //        t3[0] = 1

        //  Get
        assert t3.get(0) == 1
        assert t3[1] == "abc"
        assert t3[-1]["name"] == "Peter"
    }

}
