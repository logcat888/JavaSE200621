package com.atguigu.java;

public class MathTest {

    public static void main(String[] args) {
        // 产生一个随机的1~10的整数
        int n = (int) (Math.random() * 10 + 1);
        System.out.println(n);
    }

    class B {
        void test2() {}
    }

    static class A {
        int test() {
           return 1;
        }
    }
}
