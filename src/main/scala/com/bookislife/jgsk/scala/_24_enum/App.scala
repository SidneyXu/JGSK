package com.bookislife.jgsk.scala._24_enum

/**
 * Created by SidneyXu on 2015/10/02.
 */
object App {

  def main(args: Array[String]) {
    //  Define with a keyword
    val monday = WeekDay.withName("Mon")
    println(monday)

    //  Method
    println(WeekDay.isWorkingDay(WeekDay.Tuesday))

    //  Define with the Ordinal
    println(WeekDay(101))

    //  Id
    println(monday.id)
    println(WeekDay.Tuesday.id)

    //  Name
    println(WeekDay.Thursday)
    println(WeekDay.Wednesday)

  }
}

object WeekDay extends Enumeration {
  type WeekDay = Value
  val Monday = Value(100, "Mon")
  val Tuesday = Value("Tue")
  val Wednesday = Value
  val Thursday = Value("Thu")
  val Friday = Value("Fri")
  val Saturday = Value("Sat")
  val Sunday = Value("Sun")


  def isWorkingDay(d: WeekDay) {
    !(d == Saturday || d == Sunday)
  }
}
