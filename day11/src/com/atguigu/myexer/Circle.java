package com.atguigu.myexer;

/**
 * @author chenhuiup
 * @create 2020-07-07 上午 11:48
 */
public class Circle extends GeometicObject{

    private double radius;

    public Circle(String color, double weight, double radius) {
        super(color, weight);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    double findArea() {
       area =  3.14 * radius * radius;
        return area;
    }
}
