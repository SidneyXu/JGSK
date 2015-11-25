package com.bookislife.jgsk.kotlin._33_annotation

import kotlin.reflect.declaredMemberFunctions
import kotlin.reflect.declaredMemberProperties

/**
 * Created by SidneyXu on 2015/11/25.
 */
fun main(args: Array<String>) {
    //https://kotlinlang.org/docs/reference/reflection.html


    val person = Person()
    person.age = 20

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