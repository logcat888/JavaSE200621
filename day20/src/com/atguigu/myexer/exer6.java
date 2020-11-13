package com.atguigu.myexer;

/**
 * @author chenhuiup
 * @create 2020-07-20 下午 4:40
 *
 *
 * 创建一个子线程，在线程中输出1-100之间的偶数，主线程输出1-100之间的奇数
 *
 */
public class exer6 {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        Thread thread = new Thread(myThread);

        thread.setName("子线程");
        Thread.currentThread().setName("主线程");
        thread.start();
        for (int i = 0; i < 101; i++) {
            if ((i & 1) == 1){
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
    }
}

class MyThread implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 101; i++) {
            if ((i & 1) == 0){
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
    }
}
