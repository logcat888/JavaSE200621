package com.atguigu.exception;

public class FinallyTest {

    public static int test() {
        int n = 10;
        try {
            return n;
        } finally {
            return ++n;//11
        }
    }

    public static int add(int a, int b) {
        int c = a + b;
        return c;
    }

    public static void main(String[] args) {
        System.out.println(test());
        /*
        int x = add(10, 20);
        System.out.println(x);
        x = add(30, 40);
        System.out.println(x);
        */
    }
}
