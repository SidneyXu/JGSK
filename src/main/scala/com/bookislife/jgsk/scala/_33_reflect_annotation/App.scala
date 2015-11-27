package com.bookislife.jgsk.scala._33_reflect_annotation

import scala.annotation.{ClassfileAnnotation, StaticAnnotation}
import scala.reflect.runtime.universe._

/**
 * Created by SidneyXu on 2015/11/25.
 */
object App {

  def main(args: Array[String]) {
    val person = new Person
    person.age = 20

    val bean = typeOf[Person].typeSymbol.annotations.find(anno => {
      anno.tree.tpe == typeOf[Bean]
    }).get
    println(bean)

  }

  @Bean(name = "t_person")
  class Person {
    @BeanField
    private var privateAge: Int = 0

    @BeanMethod(alias = "trueAge")
    def age_=(pAge: Int) {
      privateAge = pAge
    }

    def age = privateAge

    @BeanMethod
    def sayHello(message: String) = println(s"hello $message")
  }

}

class Bean(val name: String) extends ClassfileAnnotation

class BeanField extends StaticAnnotation

class BeanMethod(val alias: String = "") extends StaticAnnotation
