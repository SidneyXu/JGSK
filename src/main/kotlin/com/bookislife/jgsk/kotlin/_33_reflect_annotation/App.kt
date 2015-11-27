package com.bookislife.jgsk.kotlin._33_reflect_annotation

import kotlin.reflect.declaredMemberFunctions
import kotlin.reflect.declaredMemberProperties
import kotlin.reflect.jvm.javaField
import kotlin.reflect.jvm.javaGetter

/**
 * Created by SidneyXu on 2015/11/25.
 */
fun main(args: Array<String>) {
    //https://kotlinlang.org/docs/reference/reflection.html


    val person = Person()
    person.age = 20

    //  Class Reference
    val clazz = Person::class
    val bean = clazz.annotations.first {
        it.annotationType().typeName == Bean::class.qualifiedName
    } as Bean
    println("name is ${bean.name}") //  t_person

    val properties = clazz.declaredMemberProperties
    properties.filter {
        it.annotations.isNotEmpty()
    }.forEach {
        println(it.annotations[0].annotationType().name)
    }

    val functions = clazz.declaredMemberFunctions
    functions.filter {
        it.annotations.isNotEmpty()
    }.forEach {
        println(it.name)
        println(it.annotations[0].annotationType().name)    //  BeanMethod

        val beanMethod = it.annotations[0] as BeanMethod
        println("alias is ${beanMethod.alias}") //  hello
    }

    //  Function Reference
    val numbers = listOf(1, 2, 3)
    //  (Int) -> Boolean
    println(numbers.filter(::isOdd))

    //  Property Reference
    println(::x.get())
    ::x.set(3)
    println(x)

    var name = Person::age
    println(name.get(person))

    //  With Java Reflection
    println(Person::age.javaGetter)
    println(Person::age.javaField)

    //  Constructor References
    factory(::Person)
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