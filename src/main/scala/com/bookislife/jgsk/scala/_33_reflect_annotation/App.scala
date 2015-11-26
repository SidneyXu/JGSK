package com.bookislife.jgsk.scala._33_reflect_annotation

import scala.annotation.{ClassfileAnnotation, StaticAnnotation}

/**
  * Created by SidneyXu on 2015/11/25.
  */
object App {

    def main(args: Array[String]) {
        val person = new Person
        person.age = 20

        val clazz = classOf[Person]
        val bean = clazz.getAnnotations.find(anno => {
            anno.annotationType().getTypeName == classOf[Bean].getCanonicalName
        }).asInstanceOf[Bean]
        println(s"name is ${bean.name}")
    }

}

@Bean(name = "t_person")
class Person {
    @Bean(name = "f_age")
    var age: Int = 0

    def sayHello(message: String) = println(s"hello $message")
}

//http://stackoverflow.com/questions/2265773/how-do-you-define-an-interface-in-scala
class Bean(val name: String) extends ClassfileAnnotation

class BeanField extends StaticAnnotation

class BeanMethod(val alias: String = "") extends StaticAnnotation
