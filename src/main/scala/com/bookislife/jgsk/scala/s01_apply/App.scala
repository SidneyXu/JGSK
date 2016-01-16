package com.bookislife.jgsk.scala.s01_apply

import scala.collection.mutable
import scala.util.matching.Regex

/**
  * Created by SidneyXu on 2015/12/09.
  */
object App {

    def main(args: Array[String]) {
        //  apply
        //  Calling apply() on object
        val twain = Twain(1, 2)
        println(twain.sum()) //  3

        //  Calling apply() on class
        twain() //  Result is 3

        //  update
        //  Calling update() on object
        Twain(1, 2) = 3 //  123

        //  Calling update() on class
        twain(30) = 10
        println(twain) //  x=30, y=10

        //  unapply
        val Twain(a, b) = Twain(1, 2)
        println(s"a=$a, b=$b") //  a=10, b=20

        //  Usage
        //  Container
        val scores = new mutable.HashMap[String, Int]()
        scores("Bob") = 100 //  scores.update("Bob,100)
        val bob = scores("Bob") //  scores.apply("Bob")

        //  Match
        "user@domain.com" match {
            case Email(user, domain) => println(user + "@" + domain)
        }

    }
}


class Twain(var x: Int, var y: Int) {
    override def toString: String = s"x=$x, y=$y"

    def sum() = x + y

    def apply() = println(s"Result is ${x + y}")

    def update(first: Int, second: Int) = {
        x = first
        y = second
    }
}

object Twain {
    def apply(x: Int, y: Int) = {
        new Twain(x, y)
    }

    def update(x: Int, y: Int, z: Int) = {
        println(x + y + z)
    }

    //  Extract value or return boolean
    def unapply(input: Twain) = {
        if (input.x < 0)
            None
        else
            Some(input.x * 10, input.y * 10)
    }
}

object Email {
    def unapply(str: String) = new Regex( """(.*)@(.*)""")
            .unapplySeq(str).get match {
        case user :: domain :: Nil => Some(user, domain)
        case _ => None
    }
}