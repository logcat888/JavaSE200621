package com.atguigi.java;

/**
 * 程序 : 可以执行的保存在硬盘上静态代码
 * 进程 : 正在内存中执行中的程序, 有生命周期. 多进程也可以多任务.
 * 线程 : 进程中的子任务, 也用于实现多任务
 *
 * 创建并启动线程的方式
 *      1) 实现的方式 : 它比继承的方式更好, 避免单继承局限, 方便的用于共享数据
 *          写一个具体类, 实现Runnable, 实现其中的run()方法, 这个方法就是线程体.
 *          创建这个具体类的对象, 并把它作为实参再传递给Thread对象的构造中, 创建线程对象
 *          调用线程对象的start()
 *
 *      2) 继承的方式 : 不利于共享数据
 *          写一个具体类, 继承Thread, 并重写run方法. 否则这个run方法是空的.run()是线程体
 *          创建具体类对象, 相当于创建了Thread对象
 *          调用对象的start方法.
 *
 * void start():  启动线程，并执行对象的run()方法, 激活新栈
 * run():  线程在被调度时执行的操作
 * String getName():  返回线程的名称
 * void setName(String name):设置该线程名称
 * static currentThread(): 返回当前线程, 此方法压入哪个栈, 就获取哪个栈的线程对象
 * getPriority() ：返回线程优先值, 优先级最高为10, 最小为1
 * setPriority(int newPriority) ：改变线程的优先级
 * static  void  sleep(long millis)：(指定时间:毫秒)
 * 令当前活动线程在指定时间段内放弃对CPU控制,使其他线程有机会被执行,时间到后重排队。
 * 抛出InterruptedException异常
 *
 * 解除sleep阻塞的方法 : 1) 自然醒, 2) 被别的线程调用了本线程对象的interrupt().
 *
 * 线程生命周期
 *                        阻塞   sleep()
 *               sleep时间到     b.join()
 *               b线程执行完毕   wait()
 *               notify()          |
 *                  |   获取CPU执行权
 * 新建 ---------> 就绪 --------------> 运行 -------------->死亡
 *       start()       <--------------          run()结束
 *                       失去cpu执行权           stop()
 *
 * 当前线程的同步方法、同步代码块执行结束
 * 当前线程在同步代码块、同步方法中遇到break、return终止了该代码块、该方法的继续执行。
 * 当前线程在同步代码块、同步方法中出现了未处理的Error或Exception，导致异常结束
 * 当前线程在同步代码块、同步方法中执行了锁对象的wait()方法，当前线程暂停，并释放锁。
 *
 */

class MyThread extends Thread {

    @Override
    public void run() {
        try {
            Thread.sleep(30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
        }
    }
}

public class ThreadTest {

    public static void main(String[] args) {
        Thread myThread = new MyThread();
        myThread.start();

        try {
            myThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
        }
    }

}
