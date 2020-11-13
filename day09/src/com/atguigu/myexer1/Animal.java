package com.atguigu.myexer1;

/**
 * @author chenhuiup
 * @create 2020-07-04 下午 3:54
 */
public class Animal {
    private int age;

    private void eat(){
        System.out.println("多吃肉");
    }

    public void sleep(){
        eat();
        System.out.println("多睡觉");
    }
}
