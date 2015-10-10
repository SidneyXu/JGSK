package com.bookislife.jgsk.scala._27_generics

/**
 * Created by SidneyXu on 2015/10/08.
 */
object App {

  def main(args: Array[String]) {
    //  Without Generics
    val integerObjectCapture = new ObjectCapture(10)
    val int10: Int = integerObjectCapture.obj.asInstanceOf[Int]
    println(int10)

    //  Simple Usages
    val integerCapture = new Capture[Int](10)
    val nint10: Int = integerCapture.a
    val stringCapture = new Capture[String]("Hi")
    val strHi: String = stringCapture.a
    println(strHi)
    println(integerCapture.getClass)
    println(stringCapture.getClass)

    //  Covariant
    var strHolder = new Holder[String]("a");
    var intHolder = new Holder[Int](3)
    var anyHolder = new Holder[AnyRef]("b")
    //  Wrong!!
    //    anyHolder = strHolder

    var strCo = new CovariantHolder[String]("a")
    var intCo = new CovariantHolder[Int](3)
    var anyCo = new CovariantHolder[AnyRef]("b")

    //  Wrong!! Int is not a sub class of AnyRef
    //    anyCo = intCo`
    anyCo = strCo

    //   Contravarint
    var strDCo = new ContravarintHolder[String]()
    var intDCo = new ContravarintHolder[Int]()
    var anyDCo = new ContravarintHolder[AnyRef]()

    //  Wrong!! AnyRef is not a super class of Int
    //    intDCo = anyDCo
    strDCo = anyDCo

    //  Wildcard
    val capture = new Capture[String]("foo")
    //  Wrong!! Type mismatch
    //    foo(capture)
    foo2(capture)

    //  Border
    val list = collection.mutable.MutableList[Num](new Num(1), new Num(2), new Num(3))
    foo3(list)
    foo4(list)

    //  Least Type
    foo5(capture)
  }

  def foo(capture: Capture[Any]): Unit = {

  }

  def foo2(capture: Capture[_]): Unit = {
  }

  def foo3(list: collection.mutable.MutableList[_ <: Num]): Unit = {
    //    list += new Num(4)
    val num = list.head
    println(num.number)
  }

  def foo4(list: collection.mutable.MutableList[_ >: Num]): Unit = {
    list += new Num(4)
    val num = list.head
    println(num.asInstanceOf[Num].number)
  }

  def foo5(capture: Capture[_ >: Nothing]): Unit = {

  }
}
