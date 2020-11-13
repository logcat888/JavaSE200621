package com.atguigu.myexer1;

/**
 * @author chenhuiup
 * @create 2020-07-04 下午 1:55
 */
public class Cylinder extends Circle{
    private double length;//圆柱的长

    public Cylinder(){
        length = 1;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    /**
     *
     * @return 返回圆柱的体积
     */
    public double findVolume(){
        return super.findArea() * length;
    }

    /**
     *
     * @return 返回圆柱的表面积
     */
    public double findArea(){
        return super.findArea() * 2 + getRadius() * length;
    }
}
