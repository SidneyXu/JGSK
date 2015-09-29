package com.bookislife.jgsk.java._19_inherit;

/**
 * Created by SidneyXu on 2015/09/29.
 */
public class App {

    public static void main(String[] args) {
        Button openButton = new Button("Open", 100, 100);
        openButton.onClick();

        Calculator calculator = (x, y) -> x + y;
        calculator.addOne(10);
    }
}
