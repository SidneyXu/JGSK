package com.bookislife.jgsk.scala.s06_actor

import akka.actor.{ActorSystem, Props}

/**
  * Created by SidneyXu on 2015/05/19.
  */
object RemoteServer extends App {

    implicit val system = ActorSystem("RemoteSystem")
    val remoteActor = system.actorOf(Props[EchoServer], name = "remoteServer")
    remoteActor ! "The RemoteActor is alive"

}
