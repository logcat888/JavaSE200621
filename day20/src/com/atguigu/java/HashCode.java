package com.atguigu.java;

import java.util.Objects;

/**
 * hashCode()方法用于返回当前对象的哈希表.
 * 哈希码 也称为 散列码, 或者称为 特征码.
 * 如果两个对象的equals为true, 说明两个对象的内容是相等的. 内容相等, 依赖内容所计算的特征码必须一样.
 * 如果两个对象的equals为false, 说明两个对象的内容不相等, 内容不等, 对象在内存中必须散列.
 *
 * 如果两个对象的哈希码相等, 两个对象的equals必须为true
 * 如果两个对象的哈希码不等, 两个对象的equals必须为false;
 */

class Point extends Object {

    private int x;
    private int y;

    public Point() {}

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    /** 这是Object类中的equals方法. 这个方法不能完全对象的内容的比较, 所以很烂 !!!
    public boolean equals(Object obj) {
        return (this == obj);
    }*/

    /*
    @Override
    public boolean equals(Object obj) { // 重写的方法再去完成对象的内容的比较
        if (obj instanceof Point) {
            Point p2 = (Point)obj;
            if (this.x == p2.x && this.y == p2.y) {
                return true;
            }
        }
        return false;
    }

    public native int hashCode();

    @Override
    public int hashCode() { // 要想体现它的特征性, 必须由所有属性参与才合适 .
        int h = Integer.parseInt(x * 10 + "" + y * 10);
        return h;
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x &&
                y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

public class HashCode {
    public static void main(String[] args) {
        Point p1 = new Point(30, 20);
        Point p2 = new Point(30, 20);
        System.out.println(p1 == p2); // false
        System.out.println(p1.equals(p2)); //  比较对象的内容是否相等

        System.out.println(p1.hashCode());
        System.out.println(p2.hashCode());
    }
}
