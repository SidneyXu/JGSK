package com.bookislife.jgsk.scala._05_datatype

/**
  * Created by SidneyXu on 2015/09/16.
  */
object DataType {

    def main(args: Array[String]) {
        //  Everything is Object
        1.toString()

        //  Data Types
        var x: Int = 2
        var y: Float = 0.1f
        var flag: Boolean = false

        //  BigDecimal
        println(BigDecimal(2) - BigDecimal(1.8)) //  0.2

        //  Type Conversion
        //  Implicit Conversion
        var b: Byte = 1
        var i: Int = b
        var c: Char = 1

        //  Explicit Conversion
        println(99.98.toInt)
        println(99.toChar)
        println("99.12".toDouble)

        //  Type Inference
        val foo: Any = "foo"
        bar(foo)
    }

    def bar(foo: Any): Unit = {
        if (foo.isInstanceOf[String]) {
            val fooString: String = foo.asInstanceOf[String]
            println(fooString.toUpperCase)
        }
    }
}
