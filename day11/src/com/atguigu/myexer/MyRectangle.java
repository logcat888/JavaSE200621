package com.atguigu.myexer;

/**
 * @author chenhuiup
 * @create 2020-07-07 上午 11:48
 */
public class MyRectangle extends GeometicObject{
    private double width;
    private double height;

    public MyRectangle(String color, double weight, double width, double height) {
        super(color, weight);
        if (height > width){
            this.width = width;
            this.height = height;
        }else {
            this.width = height;
            this.height = width;
        }
    }

    @Override
    double findArea() {
        area = width * height;
        return area;
    }
}
