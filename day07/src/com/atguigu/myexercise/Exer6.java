package com.atguigu.myexercise;
/*
定义三个重载方法max()，第一个方法求两个int值中的最大值，第二个方法求两个double值中的最大值，
第三个方法求三个double值中的最大值，并分别调用三个方法。
 */
public class Exer6 {
    public static void main(String[] args) {
        System.out.println("6和8的最大值为：" + new Exer6().max(6,8));
        Exer6 exer6 = new Exer6();
        double max = exer6.max(6.0,8.0);
        System.out.println("6.0和8.0的最大值为：" + max);
        System.out.println("9.9,5.0和7.5三者之间的最大值为：" + exer6.max(9.9,5.0,7.5));


    }

    public int max(int x,int y){
        return (x > y)? x:y;
    }

    public double max(double x,double y){
        return (x > y)? x:y;
    }

    public double max(double x,double y,double z){
        return (max(x,y) > z)? max(x, y):z;
    }
}


