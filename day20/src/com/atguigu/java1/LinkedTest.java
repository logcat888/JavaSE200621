package com.atguigu.java1;

/**
 * @author dexter
 * @create 2020-07-15
 */
public class LinkedTest {
    public static void main(String[] args) {
        Linked link = new Linked();
        link.add(3);
        link.add(1);
        link.add(4);
        link.add(5);
        link.add(2);
        link.add(6);
        link.add(8);
        link.add(7);
        link.add(9);

        link.trave();
        System.out.println("********************");

        link.quickSort();
        link.trave();
    }
}
