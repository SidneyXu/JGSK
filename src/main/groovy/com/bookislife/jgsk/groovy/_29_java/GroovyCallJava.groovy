package com.bookislife.jgsk.groovy._29_java

/**
 *  Created by SidneyXu on 2015/10/20.
 */
class GroovyCallJava {

    static void main(args) {
        JavaBean javaBean = new JavaBean("Peter")
        println javaBean.getName()
        println javaBean.calc(2, 3)

        GroovyBean groovyBean = new GroovyBean(name: "Peter")
        println groovyBean.name
        println groovyBean.calc(2, 3)
    }
}
