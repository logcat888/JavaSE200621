package com.atguigu.myerxer;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author chenhuiup
 * @create 2020-07-22 下午 1:41
 * <p>
 * 编写程序，在main方法中创建两个线程。线程1每隔一定时间（200ms以内的随机时间）产生一个0-100之间的随机整数，
 * 打印后将该整数放到集合中；
 * 共产生100个整数，全部产生后，睡眠30秒；
 * 在线程2中，唤醒上述睡眠的线程1，并获取线程1中的集合并打印集合内容。
 */
public class exer2 {
    public static void main(String[] args) {
        MyRunner1 myRunner1 = new MyRunner1();
        Thread thread = new Thread(myRunner1);
        thread.start();
        MyRunner2 myRunner2 = new MyRunner2(myRunner1, thread);
        Thread thread1 = new Thread(myRunner2);
        thread1.start();

    }
}

class MyRunner1 implements Runnable {
    ArrayList list = new ArrayList();

    public ArrayList getList() {
        return list;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    private boolean flag = false;

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep((int) (Math.random() * 200));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int num = (int) (Math.random() * 100);
            System.out.println(num);
            list.add(num);
        }
        System.out.println("我要睡30秒了");
        flag = true;
        try {
            Thread.sleep(30 * 1000);
        } catch (InterruptedException e) {
            System.out.println("睡不到30秒，不开心");
        }

    }
}

class MyRunner2 implements Runnable {
    private MyRunner1 runner1;
    private Thread thread;

    public MyRunner2(MyRunner1 runner1, Thread thread) {
        this.runner1 = runner1;
        this.thread = thread;
    }


    @Override
    public void run() {
        while (!runner1.isFlag()) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        thread.interrupt();
        Iterator iterator = runner1.getList().iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}
