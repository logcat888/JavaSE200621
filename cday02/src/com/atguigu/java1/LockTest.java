package com.atguigu.java1;

import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.sleep;

/**
 * 解决线程安全问题的方式三：Lock锁  --- JDK 5.0新增
 *
 *  1.实例化ReentrantLock
 *  private  ReentrantLock lock = new ReentrantLock();构造器中可以传入true或false，默认为false，若为true表示公平的，多个线程依次进行，先进先出，不会出现同一个线程多次执行。
 *  2.调用锁定方法：lock()
 *  3.调用解锁方法：unlock();
 *
 * 1.面试题：synchronized与Lock的异同？
 *  相同：二者都可以解决线程安全问题
 *  不同：synchronized机制在执行完相应的同步代码以后，自动的释放同步监视器
 *        Lock需要手动的启动同步(lock())，同时结束同步也需要手动的实现(unlock())。
 *
 *   补充：1.Lock是显式锁（手动开启和关闭锁，别忘记关闭锁），synchronized是隐式锁，出了作用域自动释放
 *         2.Lock只有代码块锁，synchronized有代码块锁和方法锁
 *         3.使用Lock锁，JVM将花费较少的时间来调度线程，性能更好。并且具有更好的扩展性（提供更多的子类）
 *
 * 2.优先使用顺序：
 *    Lock ----> 同步代码块(已经进入方法体，分配了相应资源) ----> 同步方法(在方法体之外)
 *
 * 3.面试题：如何解决线程安全问题？有几种方式？
 *
 * @author chenhuiup
 * @create 2020-07-19 下午 10:10
 */

class Window implements Runnable{

    private int ticket = 100;
    //1.实例化ReentrantLock
    private  ReentrantLock lock = new ReentrantLock();//ReentrantLock()，构造器中可以传入true或false，默认为false，若为true表示公平的，多个线程依次进行，先进先出，不会出现同一个线程多次执行。
    @Override
    public void run() {
        while(true){
            //2.调用锁定方法：lock()
            lock.lock();
            try {
                if (ticket > 0) {

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ": 卖票，票号为： " + ticket);
                    ticket--;
                }else{
                    break;
                }
            } finally {
                //3.调用解锁方法：unlock();
                lock.unlock();
            }
        }
    }
}

public class LockTest {
    public static void main(String[] args) {
        Window w = new Window();

        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.start();
        t2.start();
        t3.start();

    }
}
