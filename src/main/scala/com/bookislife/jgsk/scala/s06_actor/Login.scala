package com.bookislife.jgsk.scala.s06_actor

import akka.actor.Actor

/**
  * Created by SidneyXu on 2015/12/23.
  */
case class Login(username: String, password: String)

case class Message(content: String, sender: Actor)
