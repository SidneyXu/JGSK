package com.bookislife.jgsk.groovy._30_thread_future

import groovy.transform.Synchronized

import java.util.concurrent.Callable
import java.util.concurrent.CompletableFuture
import java.util.concurrent.CountDownLatch
import java.util.concurrent.Executors

/**
 * Created by SidneyXu on 2015/11/10.
 */
class App {

    public static void main(String[] args) {
        //  Simple Thread
        new Thread(new Runnable() {
            @Override
            void run() {
                println("async")
            }
        }).start()
        println("sync")

        //  Thread Pool
        def service = Executors.newSingleThreadExecutor()
        service.execute(new Runnable() {
            @Override
            void run() {
                println("Running in a pool.")
            }
        })

        //  Future
        def callable = new Callable() {
            @Override
            Object call() throws Exception {
                return "Hello World"
            }
        }
        def future = service.submit(callable)
        def result = future.get()
        println(result)
        service.shutdown()

        //  Timer
        def timer = new Timer("timer", true)
        def task = new TimerTask() {
            @Override
            void run() {
                println("ping!")
            }
        }
        timer.schedule(task, 100, 100)
        Thread.sleep(1000)
        timer.cancel()

        //  CompletableFuture
        def firstFuture = new CompletableFuture()
        firstFuture.complete(10)
        println(firstFuture.get())

        //  Synchronized
        def sync = new Sync()
        sync.echo()
        println()
        sync.syncEcho()
    }


}

class Sync {
    private final lock = new Object()

    def echo() {
        def max = 10
        def latch = new CountDownLatch(max)
        (1..max).each {
            new Thread(new Runnable() {
                @Override
                void run() {
                    print('<')
                    Thread.sleep(10)
                    print('>')
                    latch.countDown()
                }
            }).start()
        }
        latch.await()
    }

    def syncEcho() {
        def max = 10
        def latch = new CountDownLatch(max)
        (1..max).each {
            new Thread(new Runnable() {

                @Override
                void run() {
                    info()
                    latch.countDown()
                }
            }).start()
        }
        latch.await()
    }

    @Synchronized("lock")
    def info() {
        print('<')
        Thread.sleep(10)
        print('>')
    }

    @Synchronized
    def block() {

    }

}
