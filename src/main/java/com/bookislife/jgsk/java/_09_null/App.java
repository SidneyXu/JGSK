package com.bookislife.jgsk.java._09_null;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

/**
 * Created by SidneyXu on 2015/09/17.
 */
public class App {

    public static void main(String[] args) {
        //  Null
        Integer x = null;
        System.out.println(x == null);

        //  NullPointerException
        //  Optional
        int result;
        if (x != null) {
            result = 3 + x;
        } else {
            result = 0;
        }
        Optional<Integer> nullableX = Optional.ofNullable(x);
        result = 3 + nullableX.orElseGet(new Supplier<Integer>() {
            public Integer get() {
                return 0;
            }
        });

        List<Person> persons = new ArrayList<Person>() {{
            add(null);
            add(new Person("Peter"));
        }};
        for (Person p : persons) {
            if (p != null) {
                p.getName();
            }
        }

        List<Optional<Person>> opPersons = new ArrayList<Optional<Person>>() {{
            Person p = null;
            add(Optional.ofNullable(p));
            add(Optional.ofNullable(new Person("Peter")));
        }};

        for (Optional<Person> p : opPersons) {
            if (p.isPresent()) {
                System.out.println(p.get().getName());
            }
        }

    }


    static class Person {
        private String name;

        public Person(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}
