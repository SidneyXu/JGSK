package com.bookislife.jgsk.groovy._21_exception
/**
 * Created by SidneyXu on 2015/09/30.
 */
class App {

    static void main(args) {
        //  Try..Catch..Finally
        try {
            throw new FileNotFoundException("File not found.")
        } catch (FileNotFoundException e) {
            println("Catch block")
        } finally {
            println("Finally block")
        }

        //  Exception in Callbacks
        def bean = new MyBean()
        try {
            bean.test()

            bean.when(new MyBean.Callbacks() {

                @Override
                def done() {
                    throw new FileNotFoundException("File not found.")
                }
            })
        } catch (FileNotFoundException | MyException e) {
            println("Some errors occur.")
        }
    }


}

class MyBean {

    interface Callbacks {
        def done()
    }

    def test() throws MyException, FileNotFoundException {
    }

    def when(Callbacks callbacks) {
        tryCatchClosure {
            callbacks.done()
        }
    }

    def tryCatchClosure(Closure closure) {
        try {
            closure();
        } catch (MyException | FileNotFoundException e) {
            println("Some errors occur in closure.")
        }
    }
}

class MyException extends Exception {

}