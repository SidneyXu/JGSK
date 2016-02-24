package com.bookislife.jgsk.kotlin._30_thread_future

import java.util.*
import java.util.concurrent.Callable
import java.util.concurrent.CompletableFuture
import java.util.concurrent.CountDownLatch
import java.util.concurrent.Executors
import java.util.concurrent.locks.ReentrantLock
import java.util.function.Supplier
import kotlin.concurrent.fixedRateTimer
import kotlin.concurrent.thread
import kotlin.concurrent.withLock

/**
 * Created by SidneyXu on 2015/11/06.
 */
fun main(args: Array<String>) {
    //  Simple Thread
    thread {
        println("async")
    }
    println("sync")
    thread(start = false,
            isDaemon = true,
            name = "t1") {
        println("running")
    }.start()

    //  Thread Pool
    var service = Executors.newSingleThreadExecutor()
    service.execute {
        println("Running in a pool.")
    }

    //  Future
    val future = service.submit(
            Callable() {
                "Hello World"
            }
    )
    val result = future.get()
    println(result)
    service.shutdown()

    //  Timer
    val fixedRateTimer = fixedRateTimer(name = "timer",
            daemon = true, initialDelay = 100, period = 100) {
        println("ping!")
    }
    Thread.sleep(1000)
    fixedRateTimer.cancel()

    //  CompletableFuture
    val firstFuture = CompletableFuture<Int>()
    firstFuture.complete(10)
    println(firstFuture.get())

    service = Executors.newFixedThreadPool(10)
    val secondFuture = CompletableFuture.supplyAsync(Supplier {
        Random().nextInt(1000)
    }, service)
    println(secondFuture.get())
    service.shutdown()

    //  Synchronized
    val sync = Sync()
    sync.echo()
    println()
    sync.syncEcho()
}

class Sync {
    private var num: Int = 0
    private val lock = Object()

    private val reetLock = ReentrantLock()


    fun echo() {
        val max = 10
        val latch = CountDownLatch(max)
        (1..max).forEach {
            thread {
                print('<')
                Thread.sleep(10)
                print('>')
                latch.countDown()
            }
        }
        latch.await()
    }

    fun syncEcho() {
        val max = 10
        val latch = CountDownLatch(max)
        (1..max).forEach {
            thread {
                synchronized(lock) {
                    print('<')
                    Thread.sleep(10)
                    print('>')
                    latch.countDown()
                }
            }
        }
        latch.await()
    }

    //  jvm
    //    synchronized fun block() {
    //        println("Synchronized block")
    //    }

    fun lockEcho() {
        val max = 10
        (1..max).forEach {
            thread {
                reetLock.withLock {
                    print('<')
                    Thread.sleep(10)
                    print('>')
                }
            }
        }
    }

}