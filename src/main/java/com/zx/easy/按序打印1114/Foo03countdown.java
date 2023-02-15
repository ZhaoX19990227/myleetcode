package com.zx.easy.按序打印1114;

import java.util.concurrent.CountDownLatch;

/**
 * 给你一个类：
 * <p>
 * public class Foo {
 * public void first() { print("first"); }
 * public void second() { print("second"); }
 * public void third() { print("third"); }
 * }
 * 三个不同的线程 A、B、C 将会共用一个 Foo 实例。
 * <p>
 * 线程 A 将会调用 first() 方法
 * 线程 B 将会调用 second() 方法
 * 线程 C 将会调用 third() 方法
 * 请设计修改程序，以确保 second() 方法在 first() 方法之后被执行，third() 方法在 second() 方法之后被执行。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出："firstsecondthird"
 * 解释：
 * 有三个线程会被异步启动。
 * 输入 [1,2,3] 表示线程 A 将会调用 first() 方法，
 * 线程 B 将会调用 second() 方法，
 * 线程 C 将会调用 third() 方法。
 * 正确的输出是 "firstsecondthird"。
 */
/*
CountDownLatch
 */
public class Foo03countdown {
    private CountDownLatch countDownLatch1;
    private CountDownLatch countDownLatch2;

    public Foo03countdown() {
        countDownLatch1 = new CountDownLatch(1);
        countDownLatch2 = new CountDownLatch(1);
    }
    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        countDownLatch1.countDown();
    }
    public void second(Runnable printSecond) throws InterruptedException {
        countDownLatch1.await();
        printSecond.run();
        countDownLatch2.countDown();
    }
    public void third(Runnable printThird) throws InterruptedException {
        countDownLatch2.await();
        printThird.run();
    }
}
