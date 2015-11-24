package com.bookislife.jgsk.scala._31_test

import junit.framework.TestCase
import org.mockito.Mockito

/**
 * Created by SidneyXu on 2015/11/19.
 */
class Test01 extends TestCase {
  private var calculator: Calculator = null

  override def setUp() {
    calculator = new Calculator()
  }

  override def tearDown() {
    println("End test...")
  }

  def testSum() {
    assert(3 == calculator.sum(1, 2))
    assert(3 != calculator.sum(2, 5))
  }

  def testMock() {
    val calculator: Calculator = Mockito.mock(classOf[Calculator])
    Mockito.when(calculator.sum(1, 2)).thenReturn(10)
    assert(10 == calculator.sum(1, 2))
    assert(0 == calculator.sum(1, 20))
  }

  def testStory() {
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

class Calculator {
  def sum(x: Int, y: Int): Int = x + y
}

class Refrigerator {
  private var animal: Animal = null

  def putInto(animal: Animal): Boolean = {
    if (isEmpty) {
      this.animal = animal
      true
    } else {
      false
    }
  }

  def takeOut: Animal = {
    if (isEmpty) {
      null
    } else {
      val temp = animal
      animal = null
      temp
    }
  }

  def isEmpty: Boolean = {
    animal == null
  }
}

class Animal(val `type`: String)

