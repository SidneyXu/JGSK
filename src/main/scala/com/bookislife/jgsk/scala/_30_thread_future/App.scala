package com.bookislife.jgsk.scala._30_thread_future

import java.util.concurrent.{Executors, TimeUnit}

import scala.util.{Failure, Success}

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
        //        testExecutionContext()
                simpleFuture
        //        simplePromise
        //    futureAndPromise
        //    simpleSyncVar
        futureChain()
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
    }

    def simpleFuture: Unit = {
        //  Create a future
        val s = "Hello"
        val f1: Future[String] = Future {
            s + " future!"
        }
        f1 onSuccess {
            case msg =>
                println(msg, Thread.currentThread().getName)
                msg
        }
        f1 onComplete {
            case msg => println("onComplete")
        }
        f1 onComplete {
            case Success(msg) => println("Success")
            case Failure(msg) => println("Failure")
        }
        val result = Await result(f1, Duration(3, TimeUnit.SECONDS))
        println(result)

        /*
          Output:
          onComplete
          (Hello future!,ForkJoinPool-1-worker-5)
          Hello future!
         */

    }

    def simplePromise: Unit = {
        //  Create a promise
        //p.success create a new future and call onSuccess
        //p.fail create a new future and call onFailure
        val f = Future {
            1
        }
        val p = Promise[Int]()
        p completeWith f
        p.future onSuccess {
            case x => println(x, Thread.currentThread().getName)
        }
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
            Future {
                Thread.sleep(1000)
                val result = 10
                p.success(result)
            }
            p.future
        }

        val f = heavyFuture
        f onSuccess { case x => println(x) } // 10

        Thread.sleep(3000)
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
