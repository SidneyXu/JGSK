package com.bookislife.jgsk.groovy._31_test

import org.mockito.Mockito

/**
 * Created by SidneyXu on 2015/11/16.
 */
class Test01 extends GroovyTestCase {

    private Calculator calculator

    @Override
    protected void setUp() throws Exception {
        super.setUp()
        calculator = new Calculator()
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown()
        println("End test...")
    }

    def testSum() {
        assert 3 == calculator.sum(1, 2)
        assert 3 != calculator.sum(2, 5)
    }

    def testMock() {
        Calculator calculator = Mockito.mock(Calculator.class)
        Mockito.when(calculator.sum(1, 2)).thenReturn(10)
        assert 10 == calculator.sum(1, 2)
        assert 0 == calculator.sum(1, 20)
    }

    def testStory() {
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
        assertEquals(animal, elephant)
    }

    class Calculator {
        def sum(x, y) {
            x + y
        }
    }

    class Refrigerator {
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

    class Animal {
        public String type
    }
}
