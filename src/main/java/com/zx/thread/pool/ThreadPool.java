package com.zx.thread.pool;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPool {
    public static void main(String[] args) throws InterruptedException {
        // corePoolSize： maximumPoolSize：4 KeepAliveTIme：3 阻塞队列 拒绝策略
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 4, 3,
                TimeUnit.SECONDS, new SynchronousQueue<>(), new
                ThreadPoolExecutor.AbortPolicy());
        for (int i = 0; i < 7; i++) {
            int finalI = i;
            executor.execute(() -> {
                System.out.println("prepare to execute thread i:" + finalI);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException exception) {
                    exception.printStackTrace();
                }
                System.out.println("finish to execute thread " + finalI);
            });
        }
        TimeUnit.SECONDS.sleep(1);
        System.out.println("pool size:" + executor.getPoolSize());
        TimeUnit.SECONDS.sleep(5);
        System.out.println("pool size:" + executor.getPoolSize());
        executor.shutdownNow();
    }
}