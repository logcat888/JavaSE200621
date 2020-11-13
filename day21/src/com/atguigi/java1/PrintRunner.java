package com.atguigi.java1;

public class PrintRunner implements Runnable {

    int n = 1;

    //使用两个线程打印 1-100. 线程1, 线程2 交替打印
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            synchronized ("") {
                System.out.println(Thread.currentThread().getName() + " : " + n++);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                "".notify();
                if (i < 49) {
                    try {
                        "".wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }


}
