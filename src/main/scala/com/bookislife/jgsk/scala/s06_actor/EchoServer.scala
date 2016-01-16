package com.bookislife.jgsk.scala.s06_actor

import akka.actor.Actor

/**
  * Created by SidneyXu on 2015/11/06.
  */
//  Define an actor
class EchoServer extends Actor {
    //  Receive message
    def receive = {
        case msg: String => println("echo " + msg)
    }

    @throws[Exception](classOf[Exception])
    override def preStart(): Unit = {
        super.preStart()
        println("preStart")
    }
}
