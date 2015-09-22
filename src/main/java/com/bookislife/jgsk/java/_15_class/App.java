package com.bookislife.jgsk.java._15_class;

import java.util.Date;

/**
 * Created by SidneyXu on 2015/09/22.
 */
public class App {

    public static void main(String[] args) {
        testPerson();
        testMan();
        testImmutableSong();
    }

    private static void testPerson() {
        Person person = new Person();
        person.setAge(10);
        System.out.println(person.getAge());
    }

    private static void testMan() {
        Man fred = new Man("Fred", 21);
        Man peter = new Man("Peter");
        Man jack = new Man(21);

        System.out.println(fred);
        System.out.println(peter);
        System.out.println(jack);
    }

    private static void testImmutableSong() {
        ImmutableSong song = new ImmutableSong("Canon in D major",
                "Johann Pachelbel",
                new Date());
        System.out.println("Before is " + song.getPublishDate());
        song.getPublishDate().setTime(100);
        System.out.println("After is " + song.getPublishDate());
    }
}
