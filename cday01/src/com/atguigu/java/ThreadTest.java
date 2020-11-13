package com.atguigu.java;

/**
 * 多线程的创建：方式一：继承于Thread类
 * 1. 创建一个继承于Thread类的子类
 * 2. 重写Thread类的run()  --->将此线程执行的操作声明在run()中，由于Thread实现的Runnable的run()没有抛异常，所以其实现类或子类也不能抛异常。
 * 3. 创建Thread类的子类对象
 * 4. 通过此对象调用start():①启动当前线程  ② 调用当前线程的run()
 *
 * 例子：遍历100以内的所有偶数
 *
 * @author chenhuiup
 * @create 2020-07-12 下午 9:34
 */
//1.创建一个继承于Thread类的子类
class MyThread extends Thread {
    //2. 重写Thread类的run()

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}


public class ThreadTest {
    public static void main(String[] args) {
        //3. 创建Thread类的子类的对象
        MyThread t1 = new MyThread();

        //4.通过此对象调用start():①启动当前线程  ② 调用当前线程的run()
        t1.start();
        //问题一：我们不能通过直接调用run()的方式启动线程。
//        t1.run();仅仅是调用对象的方法，没有启动新的线程

        //问题二：再启动一个线程，遍历100以内的偶数
        //不可以还让已经start()的线程去执行，会报IllegalThreadStateException。内部会有线程计数器进行线程状态的控制，初次启动为0。当不为0时就会报异常。
//        t1.start();
        //我们需要重新创建一个线程的对象
        MyThread t2 = new MyThread();
        t2.start();
        //如下操作仍然是在main线程中执行的。
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 1){
                System.out.println(Thread.currentThread().getName() + ":" + i + "************main()***********");
            }
        }
    }
}
