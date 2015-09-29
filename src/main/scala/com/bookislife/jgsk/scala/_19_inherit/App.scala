package com.bookislife.jgsk.scala._19_inherit

/**
 * Created by SidneyXu on 2015/09/29.
 */
object App {
  def main(args: Array[String]) {
    def person = new Person("Jane") //Person[name=Jane]
    def emp1 = new Employee("Jane", 30) //Employee[name=Jane][salary=30]

    //type check
    if (emp1.isInstanceOf[Person]) {
      //type conversion
      val e = emp1.asInstanceOf[Person]
      println(e) //Employee[name=Jane][salary=30]
    }
    //type check without subclass
    if (emp1.getClass == classOf[Person]) {
      println("is Person.class")
    } else {
      println("not Person.class") //not Person.class
    }

    //    println(person.info)  cannot access
    println(person.info2)
    println(emp1.desc) //Jane

    println(emp1.id)
    println(emp1.idf)
    println(emp1.idf2)

    //antonymous sub class
    val anonymousPerson = new Person("Tom") {
      def greeting = "hello world"
    }
    println(anonymousPerson)
    println(meet(anonymousPerson))
    //    println(meet(emp1))   error


    val conn: Connection = new Connection()
    withClose(conn, conn =>
      println("do something with Connection"))

    //outputs:
    //    do something with Connection
    //    close Connection
  }

  def withClose(closeAble: {def close(): Unit},
                op: {def close(): Unit} => Unit) {
    try {
      op(closeAble)
    } finally {
      closeAble.close()
    }
  }

  class Connection {
    def close() = println("close Connection")
  }

  def meet(p: Person {def greeting: String}): Unit = {
    println(p.name + " " + p.greeting)
  }
}
