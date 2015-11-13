package com.bookislife.jgsk.java._30_thread_future;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.*;

/**
 * Created by SidneyXu on 2015/11/06.
 */
public class App {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //  Simple Thread
        new Thread(() -> {
            System.out.println("async");
        }, "thread-01").start();
        System.out.println("sync");

        //  Thread Pool
        ExecutorService service = Executors.newSingleThreadExecutor();
        service.execute(() -> System.out.println("Running in a pool."));

        //  Future
        Callable<String> callable = () -> "Hello World";
        Future<String> future = service.submit(callable);
        String result = future.get();
        System.out.println(result);
        service.shutdown();

        //  Timer
        Timer timer = new Timer("timer", true);
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("ping!");
            }
        };
        timer.schedule(task, 100, 100);
        Thread.sleep(1000);
        timer.cancel();

        //  CompletableFuture
        service = Executors.newFixedThreadPool(10);
        CompletableFuture<Integer> firstFuture = new CompletableFuture<>();
        firstFuture.complete(10);
        int value = firstFuture.get();
        System.out.println(value);  //  10

        //  Create an instance
        CompletableFuture<Integer> secondFuture = CompletableFuture.supplyAsync(() -> {
            //  long running
            return new Random().nextInt(1000);
        }, service);

        //  Transforming and acting on one CompletableFuture
        CompletableFuture<String> thirdFuture = secondFuture.thenApplyAsync(integer -> {
            if (integer < 500) {
                throw new IllegalArgumentException();
            }
            return "" + integer;
        });

        //  Running code on completion
        CompletableFuture<Void> lastFuture = thirdFuture.thenAcceptAsync(s -> System.out.println("Result is " + s));

        //  Error handling of single CompletableFuture
        CompletableFuture<String> safe1 = thirdFuture.exceptionally(throwable -> {
            //  throwable is CompletionException
            if (throwable != null && (throwable.getCause() instanceof IllegalArgumentException)) {
                return "Too small.";
            } else if (throwable != null) {
                return throwable.getMessage();
            }
            return null;
        });
        CompletableFuture<String> safe2 = thirdFuture.handleAsync((s, throwable) -> {
            //  throwable is CompletionException
            if (throwable != null && (throwable.getCause() instanceof IllegalArgumentException)) {
                return "Result is too small.";
            } else if (throwable != null) {
                return throwable.getMessage();
            }
            return s;
        });

        result = safe1.get();
        System.out.println("Safe1 is " + result);
        result = safe2.get();
        System.out.println("Safe2 is " + result);

        service.shutdown();

        //  Synchronized
        Sync sync = new Sync();
        sync.echo();
        System.out.println();
        sync.syncEcho();
    }


}

class Sync {
    public final Object lock = new Object();

    public void echo() {
        int max = 10;
        CountDownLatch latch = new CountDownLatch(max);
        for (int i = 0; i < max; i++) {
            new Thread(() -> {
                System.out.print("<");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.print(">");
                latch.countDown();
            }).start();
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void syncEcho() {
        int max = 10;
        CountDownLatch latch = new CountDownLatch(max);
        for (int i = 0; i < max; i++) {
            new Thread(() -> {
                synchronized (lock) {
                    System.out.print("<");
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.print(">");
                }
            }).start();
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void block() {
        System.out.println("Synchronized block");
    }

}
