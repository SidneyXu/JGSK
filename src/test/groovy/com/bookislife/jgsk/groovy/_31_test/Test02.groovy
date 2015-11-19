package com.bookislife.jgsk.groovy._31_test

import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

/**
 * Created by SidneyXu on 2015/11/16.
 */
class Test02 {

    private Calculator calculator

    @Before
    protected void setUp() throws Exception {
        calculator = new Calculator()
    }

    @After
    protected void tearDown() throws Exception {
        println("End test...")
    }

    @Test
    def testSum() {
        assert 3 == calculator.sum(1, 2)
        assert 3 != calculator.sum(2, 5)
    }

    @Test
    def testMock() {
        Calculator calculator = Mockito.mock(Calculator.class)
        Mockito.when(calculator.sum(1, 2)).thenReturn(10)
        assert 10 == calculator.sum(1, 2)
        assert 0 == calculator.sum(1, 20)
    }

    @Test
    def void testStory() {
        Animal elephant = new Animal(type: "Elephant")
        Animal giraffa = new Animal(type: "Giraffa")
        Refrigerator refrigerator = new Refrigerator()

        refrigerator.putInto(giraffa)
        assert !refrigerator.isEmpty()

        refrigerator.takeOut()
        refrigerator.putInto(elephant)
        assert !refrigerator.isEmpty()

        Animal animal = refrigerator.takeOut()
        assert refrigerator.isEmpty()
        assert animal == elephant
    }

    private class Calculator {
        def sum(x, y) {
            x + y
        }
    }

    private class Refrigerator {
        private Animal animal

        def putInto(Animal animal) {
            if (isEmpty()) {
                this.animal = animal
                true
            }
            false
        }

        def Animal takeOut() {
            if (isEmpty()) return null
            def temp = animal
            animal = null
            temp
        }

        def isEmpty() {
            animal == null
        }
    }

    private class Animal {
        public String type
    }
}
