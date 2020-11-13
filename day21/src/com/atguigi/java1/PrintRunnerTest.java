package com.atguigi.java1;

public class PrintRunnerTest {

    public static void main(String[] args) {
        Runnable runner = new PrintRunner();

        Thread thread1 = new Thread(runner);
        thread1.setName("线程1");

        Thread thread2 = new Thread(runner);
        thread2.setName("线程2");

        thread1.start();
        thread2.start();
    }
}
