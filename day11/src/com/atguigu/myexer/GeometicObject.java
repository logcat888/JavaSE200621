package com.atguigu.myexer;

import java.util.Objects;

/**
 * @author chenhuiup
 * @create 2020-07-07 上午 11:47
 */
public abstract class GeometicObject {
    protected String color;
    protected double weight;
    protected double area;

    protected GeometicObject(String color, double weight) {
        this.color = color;
        this.weight = weight;
    }

    abstract double findArea();

    public void setArea(double area) {
        this.area = area;
    }

    public double getArea() {
        return area = findArea();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        GeometicObject other = (GeometicObject)obj;
        return area == other.area;
    }


//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        GeometicObject that = (GeometicObject) o;
//        return Double.compare(that.area, area) == 0;
//    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(area);
//    }
}
