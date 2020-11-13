package com.atguigi.java1;

//编写一个线程程序（Counter类），声明实例变量counter，
// 初值为200。在run方法中循环50次，每次对counter做减2操作（用-=实现），
// 睡眠10毫秒，并打印counter值，然后继续下一次循环；
public class Counter implements Runnable {

    private int counter = 200;

    @Override
    //public synchronized void run() { // 相当于把此方法全部锁定, 同一时间只能有一个线程执行此方法
    public void run() {
        //synchronized (this) { // 锁的粒度太大
            for (int i = 0; i < 50; i++) {
                synchronized ("") { // (互斥锁), 任意对象都可以作锁. 最好使用一个唯一对象.
                    // 同步块中的代码具有原子性.
                    counter -= 2;
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " : " + counter);
                }
            }
        //}
    }
}
