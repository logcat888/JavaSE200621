package com.atguigu.myexer;

/**
 * @author chenhuiup
 * @create 2020-07-07 上午 11:49
 */
public class GeometricTest {
    public static void main(String[] args) {
        GeometricTest test = new GeometricTest();
        Circle circle1 = new Circle("white",5,4);
        Circle circle2 = new Circle("white",5,4);
        System.out.println(test.equalsArea(circle1,circle2));

    }

    public boolean equalsArea(GeometicObject geometicObject1,GeometicObject geometicObject2){
        return geometicObject1.equals(geometicObject2);
    }

    public double displayGeometricObject(GeometicObject geometicObject){

        return geometicObject.getArea();
    }
}
