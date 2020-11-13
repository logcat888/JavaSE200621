package com.atguigu.myexer1;

/**
 * @author chenhuiup
 * @create 2020-07-04 下午 1:59
 */
public class CylinderTest {
    public static void main(String[] args) {
        Cylinder test = new Cylinder();

        test.setLength(10);
        test.setRadius(2);

        double volume = test.findVolume();
        volume = Math.round(volume * 100) / 100.0;
        double area = test.findArea();
        System.out.println("圆柱的表面积为： " + area + ",圆柱的体积为: " + volume);
    }
}
