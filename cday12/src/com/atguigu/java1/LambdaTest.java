package com.atguigu.java1;

import org.junit.Test;

import java.util.Comparator;

/**
 * Lmabda表达式的使用
 * @author chenhuiup
 * @create 2020-08-02 下午 10:40
 */
public class LambdaTest {

    @Test
    public void test1(){
        Runnable r1 = new Runnable(){

            @Override
            public void run() {
                System.out.println("我爱北京天安门");
            }
        };
        r1.run();
        System.out.println("*******************");

        Runnable r2 = () -> System.out.println("我爱北京故宫");

        r2.run();
    }

    @Test
    public void test2(){
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        };
        com1.compare(12,23);
        System.out.println("*****************");
        //Lambda表达式的写法
        Comparator<Integer> com2 = (o1,o2) ->Integer.compare(o1,o2);
        int compare = com2.compare(35, 14);
        System.out.println(compare);

        System.out.println("**************");

        //方法引用
        Comparator<Integer> com3 = Integer :: compare;
        int compare1 = com3.compare(18, 35);
        System.out.println(compare1);

    }
}
