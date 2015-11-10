package com.bookislife.jgsk.java._30_thread_future;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.*;
import java.util.function.Function;

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

        CompletableFuture<Integer> secondFuture = CompletableFuture.supplyAsync(() -> 20, service);
        CompletableFuture<String> thirdFuture = secondFuture.thenApplyAsync(integer -> integer * 10 + "");
        thirdFuture.thenAcceptAsync(System.out::println);   //  200
        CompletableFuture<Void> exceptionFuture = thirdFuture.thenAcceptAsync(s -> {
            if (Integer.valueOf(s) <= 200) {
                throw new IllegalArgumentException();
            }
        });
        exceptionFuture.exceptionally(throwable -> {
            if (throwable instanceof IllegalArgumentException) {
                System.out.println("Result is too small.");
            }
            return null;
        });
        result = thirdFuture.get();
        System.out.println(result); //  200

        service.shutdown();
    }
}
