package com.bookislife.jgsk.kotlin._33_reflect_annotation

import kotlin.reflect.jvm.javaField
import kotlin.reflect.jvm.javaGetter

/**
 * Created by SidneyXu on 2015/11/25.
 */
fun main(args: Array<String>) {
    val person = Person()
    person.age = 20

    //  Class Reference
    val clazz = Person::class

    //  Function Reference
    val numbers = listOf(1, 2, 3)
    //  (Int) -> Boolean
    println(numbers.filter(::isOdd))

    val sayHello = Person::sayHello
    println(sayHello.invoke(person, "world"))

    //  Property Reference
    println(::x.get())
    ::x.set(3)
    println(x)

    var name = Person::age
    println(name.get(person))

    //  Constructor References
    factory(::Person)

    val bean = clazz.annotations.first {
        it.annotationClass.qualifiedName == Bean::class.qualifiedName
    } as Bean
    println("name is ${bean.name}") //  t_person

    val properties = clazz.members
    properties.filter {
        it.annotations.isNotEmpty()
    }.forEach {
        println(it.annotations[0].annotationClass.simpleName)
    }

    val functions = clazz.members
    functions.filter {
        it.annotations.isNotEmpty()
    }.forEach {
        println(it.name)
        println(it.annotations[0].annotationClass.simpleName)    //  BeanMethod

        val beanMethod = it.annotations[0] as BeanMethod
        println("alias is ${beanMethod.alias}") //  hello
    }


    //  With Java Reflection
    println(Person::age.javaGetter)
    println(Person::age.javaField)

}

var x = 2
fun isOdd(x: Int) = x % 2 != 0
fun factory(f: () -> Person) {
    val p = f()
}

@Bean(name = "t_person")
class Person {
    @BeanField var age: Int = 0
        @BeanMethod(alias = "trueAge") get() = field

    @BeanMethod(alias = "hello") fun sayHello(message: String) {
        println("hello $message")
    }
}

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS)
@Repeatable
@MustBeDocumented
annotation class Bean(val name: String)

@Retention(AnnotationRetention.BINARY)
@Target(AnnotationTarget.FIELD)
annotation class BeanField

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.FUNCTION)
annotation class BeanMethod(val alias: String = "")