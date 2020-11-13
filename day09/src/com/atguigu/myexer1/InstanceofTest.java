package com.atguigu.myexer1;

/**
 * @author chenhuiup
 * @create 2020-07-04 下午 2:20
 */
public class InstanceofTest {
    public static void main(String[] args) {
        Circle test = new Cylinder();

        System.out.println(test instanceof Circle);//ture
        System.out.println(test instanceof Cylinder);//true
        System.out.println(test instanceof InstanceofCylinder1);//false


    }

}
