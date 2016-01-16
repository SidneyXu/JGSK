package com.bookislife.jgsk.scala.s06_actor

/**
  * Created by SidneyXu on 2015/05/19.
  */

import akka.actor.Actor

class EchoServer2(name: String) extends Actor {
    def receive = {
        case msg => println("server" + name + " echo " + msg +
                " by " + Thread.currentThread().getName)
    }

}
