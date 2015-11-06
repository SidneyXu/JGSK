package com.bookislife.jgsk.scala._31_actor

import akka.actor.ActorSystem
import com.typesafe.config.ConfigFactory

/**
 * Created by mrseasons on 2015/05/20.
 */
object Client extends App {

  implicit val system = ActorSystem("LocalSystem", ConfigFactory.load("client"))
  val remote = system.actorSelection("akka.tcp://RemoteSystem@127.0.0.1:5150/user/remoteServer")
  remote ! "Hello from the LocalActor"
}
