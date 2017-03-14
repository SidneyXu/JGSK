package com.bookislife.jgsk.groovy._05_datatype

/**
 * Created by SidneyXu on 2015/09/16.
 */
class DataType {

    static void main(String[] args) {
        //  Everything is Object
        1.toString()

        //  Data Types
        //  Static Type
        int x = 2
        float y = 0.1f
        boolean flag = false

        //  Dynamic Type
        def dx = 2
        def dy = 0.1
        def dflag = false

        Date staticDate = new Date()
        //  Error! Cannot cast object '2' with class 'java.lang.Integer' to class 'java.util.Date'
//        staticDate = 2
        def dynamicDate = new Date()
        dynamicDate = 2

        //  BigDecimal
        println(2.0 - 1.8) //  0.2

        //  Type Conversion
        //  Implicit Conversion
        byte b = 1
        int i = b
        char c = 1

        //  Explicit Conversion
        println(99.98.toInteger())
        println(99 as char)
        println("99.12".toDouble())

        //  Type Inference
        def foo = "foo"
        bar(foo)
    }

    def static bar(foo) {
        if (foo instanceof String) {
            println(foo.toUpperCase())
        }
        if (foo instanceof Double) {
            println(foo.intValue())
        }
        if (foo.isDouble()) {
            println(foo.toDouble())
        }
    }
}
