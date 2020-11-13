package com.atguigi.myexer;

import java.util.ArrayList;

/**
 * @author chenhuiup
 * @create 2020-07-21 上午 10:29
 * <p>
 * /*编写程序，在main方法中创建一个线程。线程每隔一定时间（200ms以内的随机时间）产生一个0-100之间的随机整数，
 * 打印后将该整数放到集合中；
 * 共产生100个整数，全部产生后，睡眠30秒，然后将集合内容打印输出；
 * 在main线程中，唤醒上述睡眠的线程，使其尽快打印集合内容。
 */
public class exer2 {
    public static void main(String[] args) {
        MyRunnable2 myRunnable2 = new MyRunnable2();
        Thread thread = new Thread(myRunnable2);
        thread.start();
        //观察者，不断地观察目标，有时间间隔
        while (!myRunnable2.isFlag()){
            try {
                thread.sleep(10);//静态方法，与调用无关，押谁的栈谁就谁就。
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        thread.interrupt();
        System.out.println(myRunnable2.getList());

    }
}

class MyRunnable2 implements Runnable {
    ArrayList<Integer> list = new ArrayList<>();

    int count = 0;
    private boolean flag = false;

    public ArrayList<Integer> getList() {
        return list;
    }


    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        while (count <= 100) {
            try {
                Thread.sleep((int) (Math.random() * 20));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list.add((int) (Math.random() * 100));
            count++;
        }
        System.out.println("我要睡30秒了");

        flag = true;
        try {
            Thread.sleep(30 * 1000);
            System.out.println("我睡的真香");
            System.out.println(Thread.currentThread().getName());
            System.out.println(list);
        } catch (InterruptedException e) {
            System.out.println("我的睡眠被打断了");
        }

    }
}
