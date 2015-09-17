package com.bookislife.jgsk.groovy._10_script

/**
 * Created by SidneyXu on 2015/09/18.
 */
//local scope
String hello = "hello"
def world = "world"

//binding scope
helloworld = "hello world"

void otherMethod() {
    //  Wrong!!
//    println hello
//    println world

    println(helloworld)
}

println "${hello} ${world}, ${helloworld}"

//  access only binding scopes
otherMethod()