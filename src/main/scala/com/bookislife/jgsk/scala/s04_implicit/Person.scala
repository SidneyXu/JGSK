package com.bookislife.jgsk.scala.s04_implicit

/**
  * Created by SidneyXu on 2015/12/16.
  */
class Person(val name: String)

class Student(name: String) extends Person(name)

class Animal(val name: String)

class Teacher(val name: String)