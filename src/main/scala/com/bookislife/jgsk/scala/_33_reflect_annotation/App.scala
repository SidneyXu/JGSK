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

        //  Class Reference
        val clazz = classOf[Person]

        val bean = typeOf[Person].typeSymbol.annotations.find(anno => {
            anno.tree.tpe == typeOf[Bean]
        }).get
        println(bean)

        //Accessing and Invoking Members of Runtime Types
        val classLoaderMirror = runtimeMirror(getClass.getClassLoader)
        val typePerson = typeOf[Person]
        val classPerson = typePerson.typeSymbol.asClass
        val classMirror = classLoaderMirror.reflectClass(classPerson)
        val methodSymbol = typePerson.decl(termNames.CONSTRUCTOR).asMethod
        val methodMirror = classMirror.reflectConstructor(methodSymbol)
        val p: Person = methodMirror(10).asInstanceOf[Person]
        p.age = 16
        println(p.age)
    }

    def getTypeTag[T: TypeTag](obj: T) = typeTag[T]

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
