package com.bookislife.jgsk.kotlin._30_thread_future

import java.util.Random
import java.util.concurrent.Callable
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executors
import java.util.function.Supplier
import kotlin.concurrent.fixedRateTimer
import kotlin.concurrent.thread

/**
 * Created by SidneyXu on 2015/11/06.
 */
fun main(args: Array<String>) {
    //  Simple Thread
    thread() {
        println("async")
    }
    println("sync")

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
}