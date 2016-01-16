package com.bookislife.jgsk.scala.s04_implicit

import scala.collection.mutable.ArrayBuffer

/**
  * Created by SidneyXu on 2015/12/16.
  */
object App {

    def main(args: Array[String]) {
        //  Implicit Conversion
        import Context._
        val i: Int = 3
        showTripleResult(i) //  Result is 27
        println(i.triple) //  27

        //  Implicit Parameters
        implicit val stringValue = "Hello"
        show("World") //  Hello World
        show("Bye")("Good") //  Good Bye

        //  Implicit Class
        println(3.add(5)) //  8

        //  Type Constraint
        import Constraint._
        val peter = new Person("Peter")
        val tom = new Person("Tom")
        val jane = new Student("Jane")
        val cat = new Animal("Cat")

        //  <:<
        makeFriends(peter)
        //  type mismatch
        //    makeFriends(cat)

        foo(peter, cat)
        //    foo2(peter, cat)

        //  =:=
        bar(peter)
        //    bar(jane)

        //  Bounds
        import Bound._

        //  View Bound
        val linda = new Teacher("Linda")
        implicit def teacher2Person(t: Teacher): Person = new Person(t.name)
        limitView(peter)
        //    limitView(cat)
        limitView(linda)

        //  Context Bound
        implicit val persons = ArrayBuffer[Person]()
        append(peter)
        append(tom)
        persons.foreach { p => println(p.name) }
    }

    def showTripleResult(i: SuperInt): Unit = {
        println(s"Result is ${i.triple}")
    }

}

object Context {
    //  Implicit Conversion
    implicit def int2SuperInt(i: Int): SuperInt = new SuperInt(i)

    //  Implicit Parameters
    def show(msg: String)(implicit prefix: String) = println(s"$prefix $msg")

    //  Implicit Class
    implicit class Calculator(i: Int) {
        def add(a: Int) = a + i
    }

}

object Constraint {
    def makeFriends[A](a: A)(implicit ev: A <:< Person): Unit = {}

    def bar[A](a: A)(implicit ev: A =:= Person): Unit = {}

    def foo[A, B <: A](a: A, b: B) {}

    def foo2[A, B](a: A, b: B)(implicit ev: B <:< A) {}
}

object Bound {
    def limitViewOld[A <% Person](a: Person) {}

    def limitView[A](a: Person)(implicit ev1: A => Person) {}

    def append[A: ArrayBuffer](a: A): Unit = {
        var arrayBuffer = implicitly[ArrayBuffer[A]]
        arrayBuffer += a
    }

    def append2[A](a: A)(implicit ev: ArrayBuffer[A]) = {
    }
}

class SuperInt(val i: Int) {
    def triple = i * i * i
}

class Person(val name: String)

class Student(name: String) extends Person(name)

class Animal(val name: String)

class Teacher(val name: String)