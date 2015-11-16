package com.bookislife.jgsk.java._31_test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Created by SidneyXu on 2015/11/16.
 */
public class Test02 {

    private Calculator calculator;

    @Before
    public void setUp() {
        calculator = new Calculator();
    }

    @After
    public void tearDown() {
        System.out.println("End test...");
    }

    @Test
    public void testSum() {
        assert 3 == calculator.sum(1, 2);
        assert 3 != calculator.sum(2, 5);
    }

    @Test
    public void testMock() {
        Calculator calculator = Mockito.mock(Calculator.class);
        Mockito.when(calculator.sum(1, 2)).thenReturn(10);
        assert 10 == calculator.sum(1, 2);
        assert 0 == calculator.sum(1, 20);
    }

    private class Calculator {
        public int sum(int x, int y) {
            return x + y;
        }
    }
}
