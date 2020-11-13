package com.atguigi.java1;

class Singleton {

    private static Singleton only;

    private Singleton() {}

    public static Singleton getInstance() {
        if (only == null) {
            synchronized ("") {
                if (only == null) {
                    only = new Singleton();
                }
            }
        }
        return only;
    }
}

public class SingletonTest {

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Singleton instance = Singleton.getInstance();
                System.out.println(Thread.currentThread().getName() + " : " + instance);
            }
        };

        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();
    }
}
