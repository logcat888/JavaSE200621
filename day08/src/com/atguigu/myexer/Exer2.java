package com.atguigu.myexer;

/**
 * 编写两个类，TriAngle和TriAngleTest，其中TriAngle类中声明私有的底边长base和高height，
 * 同时声明公共方法访问私有变量。此外，提供类必要的构造器。另一个类中使用这些公共方法，计算三角形的面积。
 *
 * @author chenhuiup
 * @create 2020-07-03 下午 5:57
 */
public class Exer2 {
    public static void main(String[] args) {
        TriAngle test = new TriAngle(3,4);
        System.out.println("三角形面积为：" + test.findArea());
    }
}

class TriAngle {
    private double base;
    private double height;

    public TriAngle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getBase() {
        return base;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double findArea(){
        return base * height * 0.5;
    }
}
