package com.bookislife.jgsk.scala._19_inherit

/**
 * Created by SidneyXu on 2015/09/29.
 */
object App {
  def main(args: Array[String]) {
    val openButton = new Button("Open", 100, 100)
    println(openButton.getDescription())


    def person = new Person("Jane") //  Person[name=Jane]
    def employee = new Employee("Jane", 30) //  Employee[name=Jane][salary=30]

    println(person.info2)
    println(employee.valValue)  //  val Override val
    println(employee.varValue)  //  PersonVar
    println(employee.defValue1) //  val Override def
    println(employee.defValue2) //  def Override def

  }

}
