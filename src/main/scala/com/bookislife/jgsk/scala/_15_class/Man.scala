package com.bookislife.jgsk.scala._15_class

/**
  * Created by SidneyXu on 2015/2/12.
  */
//  Main Constructor
//  Parameters without var or val in main constructor are same as private[this].
class Man(val name: String,
          var age: Int,
          private var from: String = "USA",
          description: String = "none") {

    println("Sentences in Main Constructor")

    //  Slave Constructor
    def this(name: String) {
        //  Delegate to the main constructor
        this(name, 0)
    }
  
    def this(age: Int) {
        this("Default Name", age)
    }

    def this() {
        this("Default Name")
    }

    override def toString = s"Man($name, $age, $from, $description)"
}

class Woman private(val name: String, val age: Int) {
    def this(name: String) {
        this(name, 0)
    }
}