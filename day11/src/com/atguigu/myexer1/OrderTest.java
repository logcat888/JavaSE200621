package com.atguigu.myexer1;

/**编写Order类，有int型的orderId，String型的orderName，
 * 相应的getter()和setter()方法，两个参数的构造器，重写父类的equals()方法：
 * public boolean equals(Object obj)，并判断测试类中创建的两个对象是否相等。
 * @author chenhuiup
 * @create 2020-07-07 下午 6:04
 */
public class OrderTest {
    public static void main(String[] args) {
        Order order1 = new Order(1001,"jack ma");
        Order order2 = new Order(1001,"jack ma");
        Order order3 = null;
        System.out.println(order1.equals(order2));//true
        System.out.println(order1.equals(order3));//false

    }
}
