package com.atguigi.myexer;

/**
 * @author chenhuiup
 * @create 2020-07-23 下午 5:01
 */
public class exer8 {

    public static void main(String[] args) {
        Runnable runnable = new Runnable(){

            @Override
            public void run() {
                Singleton singleton = Singleton.getInstance();
                System.out.println(Thread.currentThread().getName() + singleton);
            }
        };

        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();

    }
}

class Singleton{

    private Singleton(){}

    private static Singleton instance;

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized ("") {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}


