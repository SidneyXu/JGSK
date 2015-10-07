package com.bookislife.jgsk.groovy._23_trait

/**
 * Created by SidneyXu on 2015/10/05.
 */
trait Greetable implements Named {
    
    String greeting() { "Hello, ${name()}!" }
}