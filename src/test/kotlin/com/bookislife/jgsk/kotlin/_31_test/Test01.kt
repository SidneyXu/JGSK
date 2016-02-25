package com.bookislife.jgsk.kotlin._31_test

import junit.framework.TestCase
import org.mockito.Mockito

/**
 * Created by SidneyXu on 2015/11/18.
 */
class Test01 : TestCase() {

    private var calculator: Calculator? = null

    override fun setUp() {
        super.setUp()
        calculator = Calculator()
    }

    override fun tearDown() {
        super.tearDown()
        println("End test...")
    }

    fun testSum() {
        assert(3 == calculator?.sum(1, 2))
        assert(3 != calculator?.sum(2, 5))
    }

    fun testMock() {
        val calculator = Mockito.mock<Calculator>(Calculator::class.java)
        Mockito.`when`<Int>(calculator.sum(1, 2)).thenReturn(10)
        assert(10 == calculator.sum(1, 2))
        assert(0 == calculator.sum(1, 20))
    }

    fun testStory() {
        val elephant = Animal("Elephant")
        val giraffa = Animal("Giraffa")
        val refrigerator: Refrigerator = Refrigerator()

        refrigerator.putInto(giraffa)
        assert(!refrigerator.isEmpty())

        refrigerator.takeOut()
        refrigerator.putInto(elephant)
        assert(!refrigerator.isEmpty())

        val animal = refrigerator.takeOut()
        assert(refrigerator.isEmpty())
        assertEquals(animal, elephant)
    }

}

//  Declared open when using mock
open class Calculator {
    open fun sum(x: Int, y: Int): Int {
        return x + y
    }
}

class Refrigerator {
    private var animal: Animal? = null

    fun putInto(animal: Animal): Boolean {
        if (isEmpty()) {
            this.animal = animal
            return true
        }
        return false
    }

    fun takeOut(): Animal? {
        if (isEmpty()) return null
        val temp = animal
        animal = null
        return temp
    }

    fun isEmpty(): Boolean {
        return animal == null
    }
}

class Animal(type: String)