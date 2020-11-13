package com.atguigi.java1;

public class TestDeadLock {

    static StringBuilder s1 = new StringBuilder();
    static StringBuilder s2 = new StringBuilder();

    public static void main(String[] args) {
        new Thread() {
            public void run() {
                synchronized (s1) {
                    s2.append("A");
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (s1) {
                        s2.append("B");
                        System.out.print(s1);
                        System.out.print(s2);
                    }
                }
            }
        }.start();

        new Thread() {
            public void run() {
                synchronized (s2) {
                    s2.append("C");
                    synchronized (s2) {
                        s1.append("D");
                        System.out.print(s2);
                        System.out.print(s1);
                    }
                }
            }
        }.start();
    }
}
