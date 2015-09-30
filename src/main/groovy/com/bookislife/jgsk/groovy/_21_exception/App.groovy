package com.bookislife.jgsk.groovy._21_exception

/**
 * Created by SidneyXu on 2015/09/30.
 */
class App {

    static void main(args) {
        throw new MyException();
    }

    static class MyException extends Exception {

    }
}
