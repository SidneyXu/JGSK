package com.bookislife.jgsk.groovy._33_reflect_annotation
/**
 * Created by SidneyXu on 2015/11/25.
 */
class App {

    public static void main(String[] args) {
        def person = new Person(age: 20)

        def clazz = Person.class
        Bean bean = clazz.getAnnotation(Bean.class)
        def name = bean.name()
        println("name is " + name); //  t_person

        clazz.declaredFields.findAll {
            it.declaredAnnotations != null && it.declaredAnnotations.size() > 0
        }.each {
            println("find annotation ${it.annotations[0].annotationType().name}")
        }

        clazz.declaredMethods.findAll {
            it.declaredAnnotations != null && it.declaredAnnotations.size() > 0
        }.each {
            println(it.annotations[0].annotationType().name)

            def alias = (it.annotations[0] as BeanMethod).alias()
            println("alias is $alias")

            if (it.name == "sayHello") {
                it.invoke(person, "world")

                person."${it.name}"('world')
            }
        }
    }
}

@Bean(name = "t_person")
class Person {

    @BeanField
    def int age

    @BeanMethod(alias = "trueAge")
    def int getAge() {
        age
    }

    def void setAge(int age) {
        this.age = age
    }

    @BeanMethod(alias = "hello")
    def void sayHello(String message) {
        println("hello $message")
    }
}
