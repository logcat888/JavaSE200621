package com.atguigu.java3;

public class MethodOrder {

    public static void test() {
        System.out.println("test");
    }

    public static int add(int a, int b) {
        test();
        System.out.println("add");
        return a + b;
    }

    public static void main(String[] args) {
        System.out.println("main 1");
        add(2, 5);
        System.out.println("main2");
    }
}
