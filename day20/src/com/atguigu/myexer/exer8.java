package com.atguigu.myexer;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Thread.sleep;

/**
 * @author chenhuiup
 * @create 2020-07-20 下午 5:54
 *
 * //在main方法中创建并启动1个线程。线程循环随机打印100以内的整数，直到主线程从键盘读取了“Q”命令。
 */
public class exer8 {
    public static void main(String[] args) {
        MyThread3 myThread3 = new MyThread3();
        Thread thread = new Thread(myThread3);
        thread.setName("子线程");
        thread.start();

        //请键盘获取命令
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            String data;
            while ((data = br.readLine())!= null){
                if ("Q".equals(data)){
                    myThread3.setFlag(false);
                    System.out.println("打印结束");
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class MyThread3 implements Runnable{
    private boolean flag = true;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {

        while (flag){
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread() + ":" + ((int)(Math.random() * 100)));
        }
    }
}
