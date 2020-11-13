package com.atguigu.myexer;

/**
 * 定义一个接口用来实现两个对象的比较。
 * interface CompareObject{
 * 	public int compareTo(Object o);   //若返回值是 0 , 代表相等; 若为正数，代表当前对象大；负数代表当前对象小
 *  }
 * 定义一个Circle类，声明redius属性，提供getter和setter方法
 * 定义一个ComparableCircle类，继承Circle类并且实现CompareObject接口。
 * 在ComparableCircle类中给出接口中方法compareTo的实现体，用来比较两个圆的半径大小。
 * 定义一个测试类InterfaceTest，创建两个ComparableCircle对象，调用compareTo方法比较两个类的半径大小。
 * 思考：参照上述做法定义矩形类Rectangle和ComparableRectangle类，
 * 在ComparableRectangle类中给出compareTo方法的实现，比较两个矩形的面积大小。
 * @author chenhuiup
 * @create 2020-07-10 下午 5:44
 */
public interface InterfaceTest {
    public static void main(String[] args) {
        ComparableCircle comparableCircle1 = new ComparableCircle(1);
        ComparableCircle comparableCircle2 = new ComparableCircle(1);
        int result = comparableCircle1.compareTo(comparableCircle2);
        switch(result){
            case 1:
                System.out.println("comparableCircle1的半径大");
                break;
            case 0:
                System.out.println("两个圆的半径一样");
                break;
            case -1:
                System.out.println("comparableCircle2的半径大");
                break;
            default:
                System.out.println("无法比较");
        }
    }

}
interface CompareObject {
    public int compareTo(Object o);
}

class Circle{
    private double radius;

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}

class ComparableCircle extends Circle implements CompareObject{
    public ComparableCircle() {
    }

    public ComparableCircle(double radius) {
        super(radius);
    }

    /**
     * //若返回值是 0 , 代表相等; 若为正数，代表当前对象大；负数代表当前对象小
     * @param o  被比较的对象
     * @return    比较的结果
     */
    @Override
    public int compareTo(Object o) {
        if (this == o){
            return 0;
        }
        if (o == null || o.getClass() != this.getClass())
            return 2;
        ComparableCircle other = (ComparableCircle)o;
        if (getRadius() > other.getRadius()){
            return 1;
        }else if (getRadius() == other.getRadius()){
            return 0;
        }
        else {
            return -1;
        }

    }
}