package com.bookislife.jgsk.scala.s06_actor

import akka.actor.ActorRef

/**
  * Created by SidneyXu on 2015/12/23.
  */
case class Login(username: String, password: String)

case class Message[T <: ActorRef](content: String, sender: T)
