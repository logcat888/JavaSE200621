package com.atguigu.myexer;

/**
 * @author chenhuiup
 * @create 2020-07-04 下午 1:48
 */
public class KidTest {
    public static void main(String[] args) {
        Kids kids = new Kids();

        kids.sex = 1;
        kids.salary = 1000;
        kids.yearsOld = 6;

        kids.employeed();
        kids.manOrWoman();
        kids.printAge();
    }
}
