package com.bookislife.jgsk.kotlin._31_test

import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

/**
 * Created by SidneyXu on 2015/11/18.
 */
class Test02 {

    private var calculator: Calculator? = null

    @Before
    fun setUp() {
        calculator = Calculator()
    }

    @After
    fun tearDown() {
        println("End test...")
    }

    @Test
    fun testSum() {
        assert(3 == calculator?.sum(1, 2))
        assert(3 != calculator?.sum(2, 5))
    }

    @Test
    fun testMock() {
        val calculator = Mockito.mock<Calculator>(Calculator::class.java)
        Mockito.`when`<Int>(calculator.sum(1, 2)).thenReturn(10)
        assert(10 == calculator.sum(1, 2))
        assert(0 == calculator.sum(1, 20))
    }

    @Test
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