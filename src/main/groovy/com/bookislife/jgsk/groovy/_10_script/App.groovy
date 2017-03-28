package com.bookislife.jgsk.groovy._10_script

/**
 * Created by SidneyXu on 2015/09/18.
 */
class App {

    static void main(String[] args) {
        //  Run Scripts
        //  The script name must follow the Java naming rules.
        def scope = new scriptTest()
        scope.run()
        println ""

        //  Binding Values
        scope.binding.hello = "goodbye"       //    hello is not a binding scope
        scope.binding.helloworld = "hello groovy"   //  helloworld is a binding scope
        scope.otherMethod()
        println ""

        scope.run()
    }
}
