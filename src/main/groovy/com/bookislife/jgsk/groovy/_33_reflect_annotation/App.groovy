package com.bookislife.jgsk.groovy._33_reflect_annotation
/**
 * Created by SidneyXu on 2015/11/25.
 */
class App {

    public static void main(String[] args) {
        def person = new Person(age: 20)

        //  Class Reference
        def clazz = Person.class

        //  Method Reference
        def setAgeMethod = clazz.getMethod("setAge", int.class)
        setAgeMethod.invoke(person, 100)
        def getAgeMethod = clazz.getMethod("getAge")
        int age = (int) getAgeMethod.invoke(person)
        println("Age is " + age)    //  100

        //  Another Way
        println(person."${setAgeMethod.name}"(20))
        println("Age is " + person.age) //  20

        //  Field Reference
        def ageField = clazz.getDeclaredField("age")
        ageField.setAccessible(true)
        println("Age is " + ageField.getInt(person))    //  20

        //  Constructor Reference
//                def constructor = clazz.getConstructor(int.class)
//                def person1 = constructor.newInstance(18)
//                println("Age is " + person1.getAge())

        //  Annotation Reference
        Bean bean = clazz.getAnnotation(Bean.class)
        def name = bean.name()
        println("name is " + name) //  t_person
        println("====================")

        //  Iterator
        clazz.declaredFields.findAll {
            it.declaredAnnotations != null && it.declaredAnnotations.size() > 0
        }.each {
            println("Find field annotation ${it.annotations[0].annotationType().simpleName}")
        }

        clazz.declaredMethods.findAll {
            it.declaredAnnotations != null && it.declaredAnnotations.size() > 0
        }.each {
            println("Find method annotation ${it.annotations[0].annotationType().simpleName}")

            def alias = (it.annotations[0] as BeanMethod).alias()
            println("Alias is $alias")

            if (it.name == "sayHello") {
                it.invoke(person, "world")
            }
            println("====================")
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
