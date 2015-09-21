package com.bookislife.jgsk.groovy._14_map

/**
 * Created by SidneyXu on 2015/09/21.
 */
class App {

    public static void main(String[] args) {
        //  Define
        //  Empty Map
        def emptyMap = [:]
        def map = [name: "Peter", "age": 12, "national": "USA"]
        println(map.getClass())

        //  Put
        map.put("name", "Jane")
        map.age = 20
        map["sex"] = "Female"
        map.id = 10

        //  Get
        println(map.get("name"))
        println(map["name"])
        println(map.name)

        def height = map.getOrDefault("height", 170)
        println(height)

        println(map)
    }
}
