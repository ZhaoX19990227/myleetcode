package com.zx.easy.按序打印1114;

import java.util.concurrent.Semaphore;

/**
 * 给你一个类：
 *
 * public class Foo {
 *   public void first() { print("first"); }
 *   public void second() { print("second"); }
 *   public void third() { print("third"); }
 * }
 * 三个不同的线程 A、B、C 将会共用一个 Foo 实例。
 *
 * 线程 A 将会调用 first() 方法
 * 线程 B 将会调用 second() 方法
 * 线程 C 将会调用 third() 方法
 * 请设计修改程序，以确保 second() 方法在 first() 方法之后被执行，third() 方法在 second() 方法之后被执行。
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出："firstsecondthird"
 * 解释：
 * 有三个线程会被异步启动。
 * 输入 [1,2,3] 表示线程 A 将会调用 first() 方法，
 * 线程 B 将会调用 second() 方法，
 * 线程 C 将会调用 third() 方法。
 * 正确的输出是 "firstsecondthird"。
 */
public class Foo03 {
    //声明两个 Semaphore变量
    private Semaphore spa,spb;
    public Foo03() {
        //初始化Semaphore为0的原因：如果这个Semaphore为零，如果另一线程调用(acquire)这个Semaphore就会产生阻塞，便可以控制second和third线程的执行
        spa = new Semaphore(0);
        spb = new Semaphore(0);
    }
    public void first(Runnable printFirst) throws InterruptedException {
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            //只有等first线程释放Semaphore后使Semaphore值为1,另外一个线程才可以调用（acquire）
            spa.release();
    }
    public void second(Runnable printSecond) throws InterruptedException {
            //只有spa为1才能执行acquire，如果为0就会产生阻塞
            spa.acquire();
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            spb.release();
    }
    public void third(Runnable printThird) throws InterruptedException {
            //只有spb为1才能通过，如果为0就会阻塞
            spb.acquire();
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
    }
}