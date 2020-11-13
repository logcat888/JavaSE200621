package com.atguigi.java;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author chenhuiup
 * @create 2020-07-23 下午 3:15
 */

//在main方法中创建并启动两个线程。第一个线程循环随机打印100以内的整数，
//直到第二个线程从键盘读取了“Q”命令。
public class SetDaemonTest {
    public static void main(String[] args) {
        Runner runner = new Runner();
        Thread thread = new Thread(runner);
        thread.start();

        KeyListener keyListener = new KeyListener(runner);
        Thread thread1 = new Thread(keyListener);
        thread1.setDaemon(true);//设置成守护线程
        thread1.start();

    }
}

class Runner implements Runnable{
    private boolean flag = true;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        while (true){
            System.out.println(Thread.currentThread().getName() + " : " + (int)(Math.random() * 100));
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("疯狂打印....");
        }
    }
}

class KeyListener implements Runnable{
   private Runner runner;
    public KeyListener(Runner runner){
        this.runner = runner;
    }
    @Override
    public void run() {
        while (true){
            BufferedReader br = null;
            try {
                br = new BufferedReader(new InputStreamReader(System.in));
                String line;
                line = br.readLine();
                if ("Q".equalsIgnoreCase(line)) {
                    runner.setFlag(false);
                    //break;//自我终结
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

}

