package com.atguigu.java1;

import org.junit.Test;

public class WrapperTest {

    @Test
    public void test1() {
        Integer i = new Integer(1);
        Integer j = new Integer(1);
        System.out.println(i == j); // false.

        Integer m = 1; // Integer.valueOf(1)
        Integer n = 1;
        System.out.println(m == n); // true

        Integer x = 128;
        Integer y = 128;
        System.out.println(x == y); // false

    }
}
