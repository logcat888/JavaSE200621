package com.atguigu.myexercise;
/*
编写程序，声明一个method方法，在方法中打印一个10*8 的*型矩形，在main方法中调用该方法。

 */
public class Exer1 {
    public static void main(String[] args) {
//        Exer1 test = new Exer1();
//        test.printMethod(10,8);
        new Exer1().printMethod(10,8);

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

}
