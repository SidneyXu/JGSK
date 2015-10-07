package com.bookislife.jgsk.groovy._27_generics

/**
 * Created by SidneyXu on 2015/10/07.
 */
class App {
    public static void main(String[] args) {
        //  Without Generics
        ObjectCapture integerObjectCapture = new ObjectCapture(object: 10)
        assert 10 == integerObjectCapture.getObject()

        //  Simple Usages
        Capture<Integer> integerCapture = new Capture<>(t: 10)
        assert 10 == integerCapture.getT()
        Capture<String> stringCapture = new Capture<>(t: "Hi")
        assert "Hi" == stringCapture.getT()

        //  Type Erasure
        println(integerCapture.getClass())
        println(stringCapture.getClass())

        List<Date> dateList = new ArrayList<>()
        dateList.add(1)
        dateList.add(new Date())
    }
}
