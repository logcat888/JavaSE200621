package com.atguigu.java;

/**
 * 例子：创建三个c窗口卖票，总票数为100张。使用实现Runnable接口的方式。
 *存在线程的安全问题，待解决。
 *
 * @author chenhuiup
 * @create 2020-07-13 上午 12:16
 */
class Window1 implements Runnable{
    private int ticket = 100;
    @Override
    public void run() {
        while(true){
            if (ticket > 0){
                System.out.println(Thread.currentThread().getName() + ": 卖票，票号为： " + ticket);
                ticket--;
            }else{
                break;
            }

        }
    }
}

public class WindowTest1 {
    public static void main(String[] args) {
        Window1 window1 = new Window1();

        Thread t1 = new Thread(window1);
        Thread t2 = new Thread(window1);
        Thread t3 = new Thread(window1);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }

}
