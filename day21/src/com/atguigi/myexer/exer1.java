package com.atguigi.myexer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author chenhuiup
 * @create 2020-07-21 上午 9:25
 */
public class exer1 {
    public static void main(String[] args) {
        MyRunner myRunner = new MyRunner();
        MyThread myThread = new MyThread(myRunner);
        Thread thread1 = new Thread(myRunner);

        thread1.start();
        myThread.start();

    }
}

class MyRunner implements Runnable{

    private boolean flag = true;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        while(flag){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ":" + (int)(Math.random()*100));
        }
        System.out.println("打印结束");
    }
}

class MyThread extends Thread{
    private boolean flag = true;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
    private MyRunner myRunner;

    public MyThread(MyRunner myRunner){
        this.myRunner = myRunner;
    }

    @Override
    public void run() {
        BufferedReader br = null;
        try {
           br = new BufferedReader(new InputStreamReader(System.in));
            while (flag){
                String string = br.readLine();
                if ("Q".equalsIgnoreCase(string)){
                    flag = false;
                    myRunner.setFlag(false);
                }
                System.out.println("结束循环");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}