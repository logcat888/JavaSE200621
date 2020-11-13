package com.atguigu.myexercise;
/*
修改上一个程序，在method方法中，除打印一个10*8的*型矩形外，
再计算该矩形的面积，并将其作为方法返回值。在main方法中调用该方法，接收返回的面积值并打印。
 */
public class Exer2 {
    public static void main(String[] args) {
//        Exer1 test = new Exer1();
//        test.printMethod(10,8);
        int area = new Exer2().findArea(10,8);
        System.out.println("面积为： " + area);
    }



    public void printMethod(int length,int width){

        /**
         *
         */
        for (int i = 0; i < length;i++){
            for (int j = 0;j < width;j++ ){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public int findArea(int length,int width){
        for (int i = 0; i < length;i++){
            for (int j = 0;j < width;j++ ){
                System.out.print("* ");
            }
            System.out.println();
        }

        return length * width;
    }

}
