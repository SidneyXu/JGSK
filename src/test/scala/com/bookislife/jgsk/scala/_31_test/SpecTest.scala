package com.bookislife.jgsk.scala._31_test

import org.specs2.mock._
import org.specs2.mutable._
import org.specs2.specification.BeforeAfterEach

/**
  * Created by SidneyXu on 2015/11/19.
  */
class SpecTest extends Specification with BeforeAfterEach with Mockito {

    private var calculator: Calculator = null

    override protected def after: Any = {
        println("End test...")
    }

    override protected def before: Any = {
        calculator = new Calculator
    }

    "Arithmetic" should {
        "sum" in {
            "two numbers" in {
                calculator.sum(1, 2) mustEqual 3
                calculator.sum(2, 5) mustNotEqual 3
            }
        }
    }

    "TestMock" should {
        "mock sum method" in {
            "two numbers" in {
                val calculator = mock[Calculator]
                calculator.sum(1, 2) returns 10
                calculator.sum(1, 2) mustEqual 10
                calculator.sum(1, 20) mustEqual 0
            }
        }
    }

    "Story" should {
        val elephant: Animal = new Animal("Elephant")
        val giraffa: Animal = new Animal("Giraffa")
        val refrigerator: Refrigerator = new Refrigerator

        """
           1. put giraffa
           2. takeout giraffa
           3. put elephant
           4. takeout elephant
           the refrigerator should be empty""" in {
            refrigerator.putInto(giraffa)
            refrigerator.isEmpty mustEqual false

            refrigerator.takeOut
            refrigerator.isEmpty mustEqual true

            refrigerator.putInto(elephant)
            val animal: Animal = refrigerator.takeOut
            refrigerator.isEmpty mustEqual true
            animal mustEqual elephant
        }

    }

}
