package com.bookislife.jgsk.java._33_reflect_annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by SidneyXu on 2015/11/25.
 */
public class App {

    public static void main(
            String[] args) throws InvocationTargetException, IllegalAccessException {
        Person person = new Person();
        person.setAge(20);

        Class<?> clazz = Person.class;
        Bean bean = clazz.getAnnotation(Bean.class);
        String name = bean.name();
        System.out.println("name is " + name);  //  t_person

        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            Annotation[] annotations = field.getDeclaredAnnotations();
            if (annotations == null || annotations.length == 0) continue;
            System.out.println("find annotation " + annotations[0].annotationType().getSimpleName());
        }

        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            Annotation[] annotations = method.getDeclaredAnnotations();
            if (annotations == null || annotations.length == 0) continue;
            System.out.println(annotations[0].annotationType().getName());  //  BeanMethod

            BeanMethod beanMethod = (BeanMethod) annotations[0];
            String alias = beanMethod.alias();
            System.out.println("alias is " + alias);    //  trueAge

            if (method.getName().equals("sayHello")) {
                method.invoke(person, "world");
            }
        }

    }
}

@Bean(name = "t_person")
class Person {

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
