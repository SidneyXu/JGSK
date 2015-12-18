package com.bookislife.jgsk.scala.s06_actor

import java.util.concurrent.TimeUnit

import akka.actor.ActorDSL._
import akka.actor.{ActorSystem, Props}
import akka.pattern.ask

import scala.util.Random

/**
 * Created by SidneyXu on 2015/11/06.
 */
object App {

  def main(args: Array[String]) {
    //    testEchoServer()
    //    testEchoServerUsingDSL()
    //    testActorAndThread()
    testBlockOperation()
  }

  def testEchoServer(): Unit = {
    //  Creating Actors with default constructor
    val system = ActorSystem()
    val echoServer = system.actorOf(Props[EchoServer])

    //  Send message
    echoServer ! "hi"

    system.shutdown()

    /*
      output:
      preStart
      echo hi
     */
  }

  def testEchoServerUsingDSL(): Unit = {
    implicit val system = ActorSystem()
    val echoServer = actor(new Act {
      become {
        case msg => println("echo " + msg)
      }
      whenStarting {
        println("preStart")
      }
    })
    echoServer ! "hi"

    system.shutdown()

    /*
      output:
      preStart
      echo hi
    */
  }

  def testActorAndThread(): Unit = {
    implicit val system = ActorSystem()

    //    implicit val executionContext = system.dispatchers.lookup("my-dispatcher")

    //  Specify a dispatcher to an actor
    val echoServers = (1 to 10).map(x =>
      system.actorOf(Props(new EchoServer2(x.toString))
        .withDispatcher("my-dispatcher")))
    (1 to 10).foreach(msg =>
      echoServers(Random.nextInt(10)) ! msg.toString)

    system.shutdown()

    /*
      output:
      server9 echo 2 by default-my-dispatcher-5
      server9 echo 6 by default-my-dispatcher-5
      server7 echo 1 by default-my-dispatcher-7
      server7 echo 9 by default-my-dispatcher-7
      server7 echo 10 by default-my-dispatcher-7
      server3 echo 8 by default-my-dispatcher-9
      server8 echo 3 by default-my-dispatcher-8
      server8 echo 4 by default-my-dispatcher-8
      server1 echo 5 by default-my-dispatcher-6
      server9 echo 7 by default-my-dispatcher-5
    */
  }

  def testBlockOperation(): Unit = {
    implicit val ec = scala.concurrent.ExecutionContext.Implicits.global
    implicit val system = akka.actor.ActorSystem()

    val versionUrl = "https://github.com/SidneyXu"

    val fromURL = actor(new Act {
      become {

        case url: String => sender ! scala.io.Source.fromURL(url)
          .getLines().mkString("\n")
      }
    })

    val version = fromURL.ask(versionUrl)(akka.util.Timeout(5, TimeUnit.SECONDS))
    version.foreach(println)

    system.shutdown()
  }

  def testConcurrentOperation(): Unit = {
    implicit val ec = scala.concurrent.ExecutionContext.Implicits.global
    implicit val system = akka.actor.ActorSystem()

    val versionUrl = "https://github.com/SidneyXu"

    val fromURL = actor(new Act {
      become {
        case url: String => sender ! scala.io.Source.fromURL(url)
          .getLines().mkString("\n")
      }
    })

    val version = fromURL.ask(versionUrl)(akka.util.Timeout(5, TimeUnit.SECONDS))
    version onComplete {
      case msg => println(msg); system.shutdown
    }

  }

  def testParallelProcessCollection(): Unit = {

    val urls = List("http://scala-lang.org",
      "https://github.com/SidneyXu")

    def fromURL(url: String) = scala.io.Source.fromURL(url)
      .getLines().mkString("\n")

    val t = System.currentTimeMillis()
    //    urls.map(fromURL(_))
    urls.par.map(fromURL)

    println("time: " + (System.currentTimeMillis - t) + "ms")
  }

  def testParallelWordCount(): Unit = {
    val file = List("warn 2013 msg", "warn 2012 msg",
      "error 2013 msg", "warn 2013 msg")

    def wordcount(str: String): Int = str.split(" ").count("msg" == _)

    val num = file.par.map(wordcount).par.reduceLeft(_ + _)

    println("wordcount:" + num)
  }
}
