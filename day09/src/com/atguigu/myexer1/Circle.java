package com.atguigu.myexer1;

/**
 * @author chenhuiup
 * @create 2020-07-04 下午 1:52
 */
public class Circle {
    private double radius;//半径

    public Circle(){
        radius = 1;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    /**
     *
     * @return 返回圆的面积
     */
    public double findArea(){
        return Math.PI * radius * radius;
    }
}
