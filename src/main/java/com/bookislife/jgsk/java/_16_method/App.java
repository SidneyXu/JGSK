package com.bookislife.jgsk.java._16_method;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Created by SidneyXu on 2015/09/22.
 */
public class App {

    public static void main(String[] args) {
        testMethod();
        testLambda();

        //  Closure
        Excite excite = excite("hello");
        System.out.println(excite.accept("world")); //  from=world,hello
    }
    
    private static void testMethod() {
        //  Static Method
        say("Peter", "Goodbye");

        //  Varargs
        Calculator calculator = new Calculator();
        calculator.sum(1, 2, 3);

        //  Default Values
        say("Peter", null);

        //  Return Value
        System.out.println(calculator.add(2, 3));
    }

    private static void testLambda() {
        Button button = new Button("Click");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                System.out.println("Perform Click");
            }
        });
        button.addActionListener(e -> System.out.println("Perform Click"));

        //  Define
        Excite excite = (word) -> word + "!!";

        //  Calling
        System.out.println(excite.accept("Java"));

        //  Static
        Excite hello = String::valueOf;
        System.out.println(hello.accept("Hello"));

        //  Parameters
        Convert<Integer, Integer, String> convert = (x, y) -> {
            int result = x + y;
            return x + " plus " + y + " is " + result;
        };
        System.out.println(convert.convert(1, 2));    //  1 plus 2 is 3

        //  Varargs
        Contact<String, String> contact = (args) -> String.join(",", args);
        System.out.println(contact.accept("Java", "Groovy", "Scala", "Kotlin"));

        //  Inner Function Interfaces
        //  Predicate
        Predicate<String> predicate = (s) -> s.length() > 0;
        assert predicate.test("foo");
        assert !predicate.negate().test("foo");

        //  Function
        Function<String, Integer> toInteger = Integer::valueOf;
        Function<String, String> backToString = toInteger.andThen(String::valueOf);
        assert toInteger.apply("123") == 123;
        assert backToString.apply("123").equals("123");

        //  Supplier
        Supplier<Calculator> calculatorSupplier = Calculator::new;
        assert calculatorSupplier.get().add(1, 2) == 3;

        //  Consumer
        Consumer<Person> calculatorConsumer = (p) ->
                System.out.println("The name is " + p.getName());
        calculatorConsumer.accept(new Person("Peter"));

        //  Comparator
        Comparator<Person> comparator = (p1, p2) ->
                p1.getAge().compareTo(p2.getAge());
        Person john = new Person("John", 20);
        Person alice = new Person("Alice", 18);

        assert comparator.compare(john, alice) > 0;
        assert comparator.reversed().compare(john, alice) < 0;

        //  Function Interface as Parameter
        int maxValue = max(new int[]{3, 10, 2, 40}, (s) -> {
            int max = -1;
            for (int n : s) {
                if (max < n) max = n;
            }
            return max;
        });
        assert maxValue == 40;
    }

    private static int add(int x, int y) {
        return x + y;
    }

    private static void say(String name, String word) {
        if (word == null) {
            System.out.println(word + " " + name);
        }
    }

    private static int max(int[] arr, Function<int[], Integer> integerFunction) {
        return integerFunction.apply(arr);
    }

    private static Excite excite(String s) {
        Excite e = from -> {
            from = "from=" + from;
            return from + "," + s;
        };
        return e;
    }

}

class Calculator {

    public int add(int x, int y) {
        return x + y;
    }

    public void sum(int... n) {
        int result = 0;
        for (int i : n) {
            result += i;
        }
        System.out.println(result);
    }

}

class Person {
    private String name;
    private int age;

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }
}

//  Define
@FunctionalInterface
interface Excite {
    String accept(String from);
}

interface Convert<F1, F2, T> {
    T convert(F1 from1, F2 from2);
}

interface Contact<F, T> {
    T accept(F... from);
}