package com.bookislife.jgsk.scala._15_class

/**
 * Created by SidneyXu on 2015/09/22.
 */
object App {

  def main(args: Array[String]) {
    testPerson()
    testMan()
    testModel()
  }

  def testPerson(): Unit = {
    val person = new Person
    person.age = 10 //  person.age_=(10)
    println(person.age) //  person.age()

    person.trueAge = 20
    person.trueAge = 14
    println(person.trueAge) //20
  }

  def testMan(): Unit = {
    val fred = new Man("Fred", 21) // Main Constructor
    val peter = new Man("Peter") //  Slave Constructor
    val jack = new Man(21) //  Slave Constructor

    println(fred)
    println(peter)
    println(jack)

    //  Wrong!! Main Constructor is private.
    //    val mary = new Woman("Mary",21)
    val jane = new Woman("Jane")
  }


  def testModel() {
    def m = new Model()
    println(m.name)
    m.name = "def"
    println(m.name)

    m.setName("abc")
    println(m.getName)
  }
}
