package com.study.effectivejava.ch1.item7.executor;

import java.util.concurrent.*;

public class ExecutorsExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int numberOfCpu = Runtime.getRuntime().availableProcessors();

        ExecutorService service = Executors.newFixedThreadPool(10);
        Future<String> submit = service.submit(new Task());

        System.out.println(Thread.currentThread() + " hello");
        System.out.println(submit.get()); // 쓰레드로 인해 block 되는 지점

        service.shutdown();
    }

    static class Task implements Callable<String> {

        @Override
        public String call() throws Exception {
            Thread.sleep(2000L);
            return Thread.currentThread() + " world";
        }
    }


}
