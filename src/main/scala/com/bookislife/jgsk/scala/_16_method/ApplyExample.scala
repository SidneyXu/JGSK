package com.bookislife.jgsk.scala._16_method

import scala.collection.mutable
import scala.util.matching.Regex

/**
 * Created by mrseasons on 2015/2/25.
 */
object ApplyExample {

  def main(args: Array[String]) {

    //  apply
    //  calling apply() on object
    //  use for making instance
    val obj = ApplyExample(1, 2)
    println(obj) // 1+2

    //  calling apply() on class
    obj() //  apply for class

    //  update
    ApplyExample(2, 3) = 4 // (2,3,4)


    //  use for container
    val scores = new mutable.HashMap[String, Int]()
    scores("Bob") = 100 //  actually invoke scores.update("Bob,100)
    val bob = scores("Bob") //  actually invoke scores.apply("Bob")


    //  unapply
    val ApplyExample(a, b) = ApplyExample(1, 2)
    println()

    val result = obj match {
      case ApplyExample(1, 2) => "one"
      case ApplyExample(a, b) => a + "," + b
      case _ => "other"
    }
    println(result) //  10,20

    //  unapply in regex
    "user@domain.com" match {
      case Email(user, domain) => println(user + "@" + domain)
    }
  }

  def apply(x: Int, y: Int) = new ApplyExample(x, y)

  def update(x: Int, y: Int, z: Int) = println(x, y, z)

  //  use to extract value or return boolean
  def unapply(input: ApplyExample) = {
    if (input.x < 0)
      None
    else
      Some(input.x * 10, input.y * 10)
  }

}

class ApplyExample(var x: Int, var y: Int) {
  override def toString: String = x + "+" + y

  def apply() = println("apply for class")
}

object Email {
  def unapply(str: String) = new Regex( """(.*)@(.*)""")
    .unapplySeq(str).get match {
    case user :: domain :: Nil => Some(user, domain)
    case _ => None
  }
}