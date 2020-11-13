package com.atguigu.exception;

import java.io.EOFException;
import java.io.IOException;

abstract class Base {

    public static void test2() {
        System.out.println("Base static...");
    }

    abstract Object test(int a);
}

class Sub extends Base {

    public static void test2() {
        System.out.println("Sub static...");
    }

    // 方法签名一致. 返回值类型, 方法名, 参数列表
    public @Override String test(int a) throws Error {
        System.out.println("sub test()..");
        return null;
    }

}

public class OverrideTest {

    public static void main(String[] args) {
        Base base = new Sub();
        base.test2();

        try {
            base.test(5);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
