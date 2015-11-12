package com.bookislife.jgsk.scala._30_thread_future

import java.util.concurrent.{Executors, TimeUnit}

import scala.util.{Failure, Random, Success}

//  Global ExecutionContext

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent._
import scala.concurrent.duration.Duration
import scala.language.postfixOps

/**
 * Created by SidneyXu on 2015/11/06.
 */
object App {

  def main(args: Array[String]) {
    //    testExecutionContext()
    simpleFuture
    //    simplePromise
    //    futureAndPromise
    //    test
    //    simpleSyncVar
    //        futureChain()

    Thread.sleep(1000)
  }

  def testExecutionContext(): Unit = {
    //  Thread pool
    val executor = Executors.newFixedThreadPool(1)
    implicit val service = ExecutionContext.fromExecutor(executor)
    service.execute(new Runnable {
      override def run(): Unit = {
        println("Running in a pool.")
      }
    })
    executor.shutdown()
  }

  def simpleFuture: Unit = {
    //  Create a future
    val s = "Hello"
    val f1: Future[String] = Future {
      s + " future!"
    }
    f1 onSuccess {
      case msg =>
        msg
    }
    f1 onFailure {
      case e => e.printStackTrace()
    }
    f1 onComplete {
      case Success(msg) => println("Success")
      case Failure(msg) => println("Failure")
    }
    val result = Await result(f1, Duration(3, TimeUnit.SECONDS))
    println(result)

    /*
      Output:
      Success
      Hello future!
     */

    val f2 = Future {
      Thread.sleep(10)
    }
    f2 onSuccess {
      case i =>
        println("a")
    }
    f2 onSuccess {
      case i =>
        println("b")
    }
    f2 onSuccess {
      case i =>
        println("c")
    }

    val f3=Future{
      1
    }
    f3 onSuccess{
      case i=> Future{
        i+2
      } onSuccess{
        case i=>
          i*10
      }
    }
    val x = Await result(f1, Duration(3, TimeUnit.SECONDS))
    println(x)
  }

  def simplePromise: Unit = {
    //  Create a promise
    val f = Future {
      1
    }
    val p = Promise[Int]()
    //    p completeWith f
    p.future onSuccess {
      case x => println(x, Thread.currentThread().getName)
    }
    p.success(10)
    println("---1---")
    /*
      Output:
      ---1---
      (1,ForkJoinPool-1-worker-5)
    */
  }

  def futureAndPromise: Unit = {
    def heavyFuture = {
      val p = Promise[Int]()
      val f = Future {
        1000
      }
      p completeWith f
      p.future
    }

    val f = heavyFuture
    f onSuccess { case x => println(x) } // 1000
  }

  def test = {
    val secondFuture = Future {
      new Random().nextInt(1000)
    }
    val thirdFuture = secondFuture.map {
      case i: Int => if (i >= 999)
        "" + i
      else
        new IllegalArgumentException()
    } recover {
      case e: IllegalArgumentException => "Result is too small."
    }
    secondFuture fallbackTo thirdFuture
    secondFuture onFailure {
      case e =>
        e.printStackTrace()
        if (e.getCause.isInstanceOf[IllegalArgumentException])
          "Result is too small."
        else
          e.getMessage
    }
    val lastFuture = thirdFuture.andThen {
      case s => println(s"Result is ${s.get}")
    }

    //  Recover
    val tryDivideByZeroAgain = Future {
      1 / 0
    } recover {
      case e: ArithmeticException => "Infinity"
    }

    tryDivideByZeroAgain onSuccess {
      case result => println("Result is " + result)
    }

    tryDivideByZeroAgain onFailure {
      case e => e.printStackTrace()
    }

    //  Fallback
    val f1 = Future {
      1 / 0
    }

    val f2 = Future {
      "Infinity"
    }

    f1 fallbackTo f2 onSuccess {
      case v => println(v)
    }

    val future = Future {
      10 / 0
    } andThen {
      case Success(x) =>
        println(x)
        x + 20

      case Failure(e) =>
        e.getCause.getMessage
    } andThen {
      case Success(x) => {
        println(x)
      }
    }
  }

  def simpleSyncVar: Unit = {
    //---syncvar---
    val v = new SyncVar[Int]
    v.put(1)
    var result = v.get
    println("result", result, Thread.currentThread().getName) //(result,1,main)

    result = v.take()
    println("take", result, Thread.currentThread().getName) //(take,1,main)

    //blocking...
    //result = v.get
    //println("get", result, Thread.currentThread().getName)

    println("---2---")

    /*
      Output:
      (result,1,main)
      (take,1,main)
      ---2---
     */
  }

  def futureChain(): Unit = {
    val f = Future {
      5
    }
    val g = f.map { x =>
      x + 1
    }
    var result = Await result(g, Duration(3, TimeUnit.SECONDS))
    println(result)


    val h = f.flatMap { x =>
      Future {
        x + 1
      }
    }
    result = Await result(h, Duration(3, TimeUnit.SECONDS))
    println(result)

    val f1 = for {
      x <- Future {
        5
      }
      y <- Future {
        x + 1
      }
    } yield y + 2
    result = Await.result(f1, Duration("100 millis"))
    println(result)
    //
    //        val h1 = f.flatMap {
    //            case x => Future {
    //                x / 0
    //            }
    //        } recover {
    //            case x => 10
    //        } foreach println


    //TODO

  }

}
