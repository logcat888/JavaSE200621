package com.atguigi.myexer;

/**
 * @author chenhuiup
 * @create 2020-07-21 上午 11:35
 */
public class exer4 {
    public static void main(String[] args) {
        Counter counter = new Counter();
        Thread thread1 = new Thread(counter);
        Thread thread2 = new Thread(counter);
        thread1.setName("线程1");
        thread2.setName("线程2");
        thread1.start();
        thread2.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(counter.count);

    }
}

class Counter implements Runnable{
    int count = 200;

    @Override
    public void run() {
        for (int i = 1; i <= 50; i++) {
            count -= 2;
//            try {
//                Thread.sleep(10);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            System.out.println(Thread.currentThread().getName() + ": 第" + i  + "次操作" + count);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
