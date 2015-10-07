package com.bookislife.jgsk.java._27_generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by SidneyXu on 2015/10/05.
 */
public class App {

    public static void main(String[] args) {
        //  Without Generics
        ObjectCapture integerObjectCapture = new ObjectCapture(10);
        assert 10 == (Integer) integerObjectCapture.get();

        //  Simple Usages
        Capture<Integer> integerCapture = new Capture<>(10);
        assert 10 == integerCapture.get();
        Capture<String> stringCapture = new Capture<>("Hi");
        assert "Hi".equals(stringCapture.get());

        //  Type Erasure
        System.out.println(integerCapture.getClass());
        System.out.println(stringCapture.getClass());

        //  Covariant
        Integer[] integers = new Integer[2];
        Object[] objects = integers;

        Date[] dates = new Date[2];
        Object[] objects2 = dates;
        //        objects2[0] = "str";

        List<Date> dateList = new ArrayList<>();
        //        List<Object> objectList = dateList;

        //  Wildcard
        //        foo(dateList);
        foo2(dateList);

        //  Border
        List<Num> list = Arrays.asList(new Num(1), new Num(2), new Num(3));
        foo3(list);
        foo4(list);
    }

    private static void foo(List<Object> list) {
    }

    private static void foo2(List<?> list) {
    }

    private static void foo3(List<? extends Num> list) {
//        list.add(new Num(4));
        Num num = list.get(0);
        System.out.println(num);
    }

    private static void foo4(List<? super Num> list) {
        list.add(new Num(4));
        Object object = list.get(0);
        System.out.println(object);
    }
}
