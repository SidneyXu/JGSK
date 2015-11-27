package com.bookislife.jgsk.java._33_reflect_annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by SidneyXu on 2015/11/25.
 */
public class App {

    public static void main(String[] args) throws Exception {
        Person person = new Person();
        person.setAge(20);

        //  Class Reference
        Class<?> clazz = Person.class;

        //  Method Reference
        Method setAgeMethod = clazz.getMethod("setAge", int.class);
        setAgeMethod.invoke(person, 100);
        Method getAgeMethod = clazz.getMethod("getAge");
        int age = (int) getAgeMethod.invoke(person);
        System.out.println("Age is " + age);    //  100

        //  Field Reference
        Field ageField = clazz.getDeclaredField("age");
        ageField.setAccessible(true);
        System.out.println("Age is " + ageField.getInt(person));    //  100

        //  Constructor Reference
        Constructor<Person> constructor = (Constructor<Person>) clazz.getConstructor(int.class);
        Person person1 = constructor.newInstance(18);
        System.out.println("Age is " + person1.getAge());   //  18

        //  Annotation Reference
        Bean bean = clazz.getAnnotation(Bean.class);
        String name = bean.name();
        System.out.println("Name is " + name);  //  t_person
        System.out.println("====================");

        //  Iterator
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            Annotation[] annotations = field.getDeclaredAnnotations();
            if (annotations == null || annotations.length == 0) continue;
            System.out.println("Find field annotation " + annotations[0].annotationType().getSimpleName());
        }

        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            Annotation[] annotations = method.getDeclaredAnnotations();
            if (annotations == null || annotations.length == 0) continue;
            System.out.println("Find method annotation " + annotations[0].annotationType().getSimpleName());  //  BeanMethod

            BeanMethod beanMethod = (BeanMethod) annotations[0];
            String alias = beanMethod.alias();
            System.out.println("Alias is " + alias);    //  trueAge

            if (method.getName().equals("sayHello")) {
                method.invoke(person, "world");
            }
            System.out.println("====================");
        }


    }
}

@Bean(name = "t_person")
class Person {

    public Person() {
    }

    public Person(int age) {
        this.age = age;
    }

    @BeanField
    private int age;

    @BeanMethod(alias = "trueAge")
    public int getAge() {
        return age;
    }

    public void setAge(final int age) {
        this.age = age;
    }

    @BeanMethod(alias = "hello")
    public void sayHello(String message) {
        System.out.println("hello " + message);
    }
}
