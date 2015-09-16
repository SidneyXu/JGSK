package com.bookislife.jgsk.java._05_datatype;

import java.math.BigDecimal;

/**
 * Created by SidneyXu on 2015/09/16.
 */
public class DataType {

    public static void main(String[] args) {
        //  Data Types
        int x = 2;
        float y = 0.1f;
        boolean flag = false;

        //  BigDecimal
        System.out.println(2.0 - 1.8);  //  0.19999999999999996
        System.out.println(new BigDecimal(2.0).subtract(new BigDecimal(1.8)));  //  0.19999999999999995559...
        System.out.println(new BigDecimal("2.0").subtract(new BigDecimal("1.8")));  //  0.2

        //  Type Conversion
        //  Implicit Conversion
        byte b = 1;
        int i = b;
        char c = 1;

        //  Explicit Conversion
        System.out.println((int) 99.98);
        System.out.println((char) 99);
        System.out.println(Double.valueOf("99.12"));

        //  Type Inference
        Object foo = "foo";
        bar(foo);
    }

    private static void bar(Object foo) {
        if (foo instanceof String) {
            String fooString = (String) foo;
            System.out.println(fooString.toUpperCase());
        }
    }
}
