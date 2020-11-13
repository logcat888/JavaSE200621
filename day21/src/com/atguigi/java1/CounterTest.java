package com.atguigi.java1;

/**
 * 两个同 :
 *      多个线程 "同时" 修改 "同一" 数据
 */
public class CounterTest {

    public static void main(String[] args) {
        Runnable runner = new Counter();

        Thread thread1 = new Thread(runner);
        thread1.setName("线程1");


        Thread thread2 = new Thread(runner);
        thread2.setName("线程2");

        thread1.start();
        thread2.start();

    }
}
