package com.atguigu.myexer;

/**
 * @author chenhuiup
 * @create 2020-07-20 下午 4:52
 *
 * 创建两个子线程，交替打印1-100.
 */
public class exer7 {
    public static void main(String[] args) {
        MyThread1 myThread1 = new MyThread1();
        Thread thread1 = new Thread(myThread1);
        Thread thread2 = new Thread(myThread1);

        thread1.setName("我是子线程1");
        thread2.setName("我是子线程2");
        thread1.start();
        thread2.start();
    }
}


class MyThread1 implements Runnable {

    int i = 0;

    @Override
    public void run() {
        while (i <= 100){

        synchronized (this) {
          notify();
                System.out.println(Thread.currentThread().getName() + ": " + i++);
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        }
    }
}