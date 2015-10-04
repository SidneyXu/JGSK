package com.bookislife.jgsk.groovy._24_enum
/**
 * Created by SidneyXu on 2015/10/02.
 */
class App {

    public static void main(String[] args) {
        //  Define with a keyword
        def monday = 'Monday' as WeekDay
        assert monday == WeekDay.Monday

        //  Method
        assert WeekDay.Tuesday.isWorkingDay()
        println(WeekDay.Thursday.abbr)

        //  Query Ordinal
        println(monday.ordinal())

        //  Define with the Ordinal
        println(WeekDay.values()[0])

        //  Singleton
        println(Singleton.INSTANCE.sequence())
    }
}

enum WeekDay {
    Monday('Mon'), Tuesday('Tue'), Wednesday('Wed'), Thursday('Thu'),
    Friday('Fri'), Saturday('Sat'), Sunday('Sun')

    def abbr

    WeekDay(abbr) {
        this.abbr = abbr
    }

    def isWorkingDay() {
        !(this == Saturday || this == Sunday)
    }
}

enum Singleton {
    INSTANCE

    def count = 0

    def sequence() {
        ++count
    }
}