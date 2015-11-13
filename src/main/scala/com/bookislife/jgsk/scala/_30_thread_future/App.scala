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
    testExecutionContext()
    simpleFuture
    combineFuture
    simplePromise
    futureAndPromise
    simpleSyncVar
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
        println(msg)
    }
    f1 onFailure {
      case e =>
        e.printStackTrace()
    }
    f1 onComplete {
      case Success(msg) => println(s"Success $msg")
      case Failure(e) => println(s"Failure ${e.getMessage}")
    }
    val result = Await result(f1, Duration(3, TimeUnit.SECONDS))
    println(result)

    /*
      Output:
      Success Hello future!
      Hello future!
     */

    //  Callback
    val f2 = Future {
      Thread.sleep(10)
    }
    f2 onSuccess {
      case _ => println("a")
    }
    f2 onSuccess {
      case _ => println("b")
    }
    f2 onSuccess {
      case _ => println("c")
    }
  }

  def combineFuture: Unit = {
    //  Callback Hell
    Future {
      1
    } onSuccess {
      case x => Future {
        x + 3
      } onSuccess {
        case x => Future {
          x * 10
        } onSuccess {
          case x =>
            println(s"Result of callback hell is $x") //  40
        }
      }
    }

    //  Combine
    val f1 = Future {
      1
      //            1 / 0
    }
    val f2 = f1 map { x =>
      x + 3
    }
    f2 map { x =>
      x * 10
    } onComplete {
      case Success(x) => println(s"Result of map is $x") //  40
      case Failure(e) => e.printStackTrace()
    }

    //  Recovery
    Future {
      1 / 0
    } recover {
      case e: ArithmeticException => 0
    } map { x =>
      x + 3
    } map { x =>
      x * 10
    } onComplete {
      case Success(x) => println(s"Result of recover is $x") //  30
      case Failure(e) => e.printStackTrace()
    }

    //  Fallback
    val f3 = Future {
      1 / 0
      //            1
    }
    val f4 = Future {
      10
    }
    f3 fallbackTo f4 map { x =>
      x + 3
    } onComplete {
      case Success(x) => println(s"Result of fallback is $x") //  13
      case Failure(e) => e.printStackTrace()
    }

    //  Then
    Future {
      1
    } andThen {
      case Success(x) =>
        x + 1
    } andThen {
      case Success(x) =>
        x + 10
    } andThen {
      case Success(x) =>
        println(s"Result of then is $x") //  1
    }
  }

  def simplePromise: Unit = {
    //  Create a promise
    val p1 = Promise[Int]()
    val f1 = p1.future
    Future {
      val i = Random.nextInt(100)
      p1.success(i)
    }
    Future {
      f1 onSuccess {
        case x => println(x)
      }
    }

    //  Promise already completed
    //    Thread.sleep(10)
    //    p1.success(10)
    p1.trySuccess(10)
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

  def simpleSyncVar: Unit = {
    val v = new SyncVar[Int]
    Future {
      Thread.sleep(10)
      v.put(3)
    }
    var result = v.get
    println("result", result, Thread.currentThread().getName) //(result,3,main)

    result = v.take()
    println("take", result, Thread.currentThread().getName) //(take,3,main)

    //  Blocking...
    //  result = v.get
    //  println("get", result, Thread.currentThread().getName)
  }

}

class Counter {
  private var num: Int = 0

  def count(): Unit = synchronized {
    num += 1
  }

  def get(): Int = synchronized {
    num
  }
}
