package com.bookislife.jgsk.java._24_enum;

/**
 * Created by SidneyXu on 2015/10/02.
 */
public class App {

    public static void main(String[] args) {
        //  Define with a keyword
        WeekDay monday = WeekDay.valueOf("Monday");
        assert monday == WeekDay.Monday;

        //  Method
        assert WeekDay.Tuesday.isWorkingDay();
        System.out.println(WeekDay.Thursday.getAbbr());

        //  Query Ordinal
        System.out.println(monday.ordinal());

        //  Define with the Ordinal
        System.out.println(WeekDay.values()[0]);

        //  Singleton
        System.out.println(Singleton.INSTANCE.sequence());
    }
}

enum WeekDay {
    Monday("Mon"), Tuesday("Tue"), Wednesday("Wed"), Thursday("Thu"),
    Friday("Fri"), Saturday("Sat"), Sunday("Sun");

    private String abbr;

    WeekDay(String abbr) {
        this.abbr = abbr;
    }

    public boolean isWorkingDay() {
        return !(this == Saturday || this == Sunday);
    }

    public String getAbbr() {
        return abbr;
    }
}

enum Singleton {
    INSTANCE;

    private int count;

    public int sequence() {
        return ++count;
    }
}