package com.atguigu.myexer;

/**
 * 编写Test02类，在main方法中，
 * 	（1）创建一个Rectangle[]数组，长度为5
 * 	（2）并创建5个Rectangle的矩形对象，放到数组中，矩形的长和宽随机生成[1,10.0)范围内的值
 * 	（3）遍历显示
 * 	（4）按照面积从小到大排序
 * 	（5）再次遍历显示
 * @author chenhuiup
 * @create 2020-07-03 下午 6:04
 */
public class Exer3 {
    public static void main(String[] args) {
        Rectangle[] test = new Rectangle[5];
        //为矩形对象数组初始化
        for (int i = 0; i < test.length; i++) {
            test[i] = new Rectangle(Math.random()*(9) + 1 ,Math.random()*(9) + 1 );
        }
        Exer3 testRectangle = new Exer3();
        //遍历数组的长、宽、面积
        testRectangle.showInfo(test);
        System.out.println("***********************");
        //按照面积从小到大排序
        testRectangle.sortRectangle(test);

        //遍历数组的长、宽、面积
        testRectangle.showInfo(test);
    }

    /**
     * 遍历数组的长、宽、面积
     * @param rectangles 长方形的数组
     */
    public void showInfo(Rectangle[] rectangles){
        for (int i = 0; i < rectangles.length; i++) {
            System.out.println("第" + (i + 1) + "个长方形的长为： " + rectangles[i].getLength() + "，宽为：" +
                    rectangles[i].getWidth() + "，面积为：" + rectangles[i].getArea());
        }
    }

    /**
     * 按照面积由小到达对长方形数组排序
     * @param rectangles 长方形的数组
     */
    public void sortRectangle(Rectangle[] rectangles){
        for (int i = 0; i < rectangles.length - 1; i++) {
            for (int j = 0; j < rectangles.length - 1 - i; j++) {
                if (rectangles[j].getArea() > rectangles[j + 1].getArea()){
                    swapRcetangle(rectangles,j ,j + 1);
                }

            }
        }
    }

    /**
     * 交换对象数组中的两个元素
     * @param rectangles 长方形对象数组
     * @param i 索引位置
     * @param j 索引位置
     */
    private void swapRcetangle(Rectangle[] rectangles,int i,int j){
        Rectangle temp = rectangles[i];
        rectangles[i] = rectangles[j];
        rectangles[j] = temp;
    }
}

class Rectangle{
    private double length;
    private double width;
    private double area;

    public Rectangle() {
    }

    public Rectangle(double length, double width) {
        if(length > width){
            this.length = length;
            this.width = width;
        }else {
            this.length = width;
            this.width = length;
        }

        area = length * width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getArea() {
        return length * width;
    }

}