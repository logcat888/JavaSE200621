package com.atguigu.java1;

interface CompareObject {
    public int compareTo(Object o);   //若返回值是 0 , 代表相等; 若为正数，代表当前对象大；负数代表当前对象小
}

class Circle {

    private int radius;

    public Circle() {
    }

    public Circle(int radius) {
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                '}';
    }
}

class ComparableCircle extends Circle implements CompareObject {

    public ComparableCircle() {
    }

    public ComparableCircle(int radius) {
        super(radius);
    }

    @Override
    public int compareTo(Object o) {
        //若返回值是 0 , 代表相等; 若为正数，代表当前对象大；负数代表当前对象小
        if (o instanceof ComparableCircle) {
            ComparableCircle circle2 = (ComparableCircle) o; // 是不是强制类型转换? 造型.
            if (this.getRadius() > circle2.getRadius()) { // 左大右小
                return 1;
            } else if (this.getRadius() < circle2.getRadius()) { // 左小右大
                return -1;
            }
            return 0;
        }
        return 0x7FFFFFFF;
    }
}

public class InterfaceWork {

    public static void main(String[] args) {
        // 用户, 使用面向接口的思想, 子类对象具体是什么不重要, 重要的是对象一定是接口类型.足矣.
        //若返回值是 0 , 代表相等; 若为正数，代表当前对象大；负数代表当前对象小
        CompareObject obj1 = new ComparableCircle(200);
        CompareObject obj2 = new ComparableCircle(190);
        int ret = obj1.compareTo(obj2);
        if (ret == 0x7FFFFFFF) {
            System.out.println("对象不可比");
        } else {
            if (ret > 0) {
                System.out.println(obj1 + " 大于 " + obj2);
            } else if (ret < 0) {
                System.out.println(obj1 + " 小于 " + obj2);
            } else {
                System.out.println(obj1 + " 等于 " + obj2);
            }
        }
    }
}
