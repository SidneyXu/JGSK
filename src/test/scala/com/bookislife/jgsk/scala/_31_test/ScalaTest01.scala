package com.bookislife.jgsk.scala._31_test

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{BeforeAndAfter, FunSuite}

/**
 * Created by SidneyXu on 2015/11/19.
 */
@RunWith(classOf[JUnitRunner])
class ScalaTest01 extends FunSuite with BeforeAndAfter {

  private var calculator: Calculator = null

  before {
    calculator = new Calculator
  }

  after {
    println("End test...")
  }

  test("Sum") {
    assert(3 == calculator.sum(1, 2))
    assert(3 != calculator.sum(2, 5))
  }

  test("Story") {
    val elephant: Animal = new Animal("Elephant")
    val giraffa: Animal = new Animal("Giraffa")
    val refrigerator: Refrigerator = new Refrigerator
    refrigerator.putInto(giraffa)
    assert(!refrigerator.isEmpty)
    refrigerator.takeOut
    refrigerator.putInto(elephant)
    assert(!refrigerator.isEmpty)
    val animal: Animal = refrigerator.takeOut
    assert(refrigerator.isEmpty)
    assert(animal == elephant)
  }
}
