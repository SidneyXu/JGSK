package com.bookislife.jgsk.java._31_test;

import junit.framework.TestCase;
import org.mockito.Mockito;

/**
 * Created by SidneyXu on 2015/11/16.
 */
public class Test01 extends TestCase {

    private Calculator calculator;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        calculator = new Calculator();
    }

    @Override
    public void tearDown() throws Exception {
        super.tearDown();
        System.out.println("End test...");
    }

    public void testSum() {
        assert 3 == calculator.sum(1, 2);
        assert 3 != calculator.sum(2, 5);
    }

    public void testMock() {
        Calculator calculator = Mockito.mock(Calculator.class);
        Mockito.when(calculator.sum(1, 2)).thenReturn(10);
        assert 10 == calculator.sum(1, 2);
        assert 0 == calculator.sum(1, 20);
    }

    public void testStory() {
        Animal elephant = new Animal("Elephant");
        Animal giraffa = new Animal("Giraffa");
        Refrigerator refrigerator = new Refrigerator();

        refrigerator.putInto(giraffa);
        assert !refrigerator.isEmpty();

        refrigerator.takeOut();
        refrigerator.putInto(elephant);
        assert !refrigerator.isEmpty();

        Animal animal = refrigerator.takeOut();
        assert refrigerator.isEmpty();
        assertEquals(animal, elephant);
    }

    private class Calculator {
        public int sum(int x, int y) {
            return x + y;
        }
    }

    private class Refrigerator {
        private Animal animal;

        public boolean putInto(Animal animal) {
            if (isEmpty()) {
                this.animal = animal;
                return true;
            }
            return false;
        }

        public Animal takeOut() {
            if (isEmpty()) return null;
            Animal temp = animal;
            animal = null;
            return temp;
        }

        public boolean isEmpty() {
            return animal == null;
        }
    }

    private class Animal {
        public String type;

        public Animal(String type) {
            this.type = type;
        }
    }
}
