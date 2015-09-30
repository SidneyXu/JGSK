package com.bookislife.jgsk.java._21_exception;

import java.io.FileNotFoundException;

/**
 * Created by SidneyXu on 2015/09/30.
 */
public class App {

    public static void main(String[] args) {
        //  Try..Catch..Finally
        try {
            throw new FileNotFoundException("File not found.");
        } catch (FileNotFoundException e) {
            System.out.println("Catch block");
        } finally {
            System.out.println("Finally block");
        }

        //  Exception in Callbacks
        MyBean bean = new MyBean();
        try {
            bean.test();

            bean.when(() -> {
                try {
                    bean.test();
                } catch (MyException | FileNotFoundException e) {
                    System.out.println("Some errors occur in callback.");
                }
            });
        } catch (FileNotFoundException | MyException e) {
            System.out.println("Some errors occur.");
        }
    }

}

class MyBean {

    interface Callbacks {
        void done();
    }

    public void test() throws MyException, FileNotFoundException {
    }

    public void when(Callbacks callbacks) {
        callbacks.done();
    }
}

class MyException extends Exception {

}
