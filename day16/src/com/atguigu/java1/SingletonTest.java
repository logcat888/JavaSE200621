package com.atguigu.java1;

class Singleton {

    private static Singleton only = new Singleton();

    private String name;

    public static Singleton getInstance() {
        return only;
    }

    private Singleton() {}

}

public class SingletonTest {

    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        System.out.println(s1 == s2);
    }
}
