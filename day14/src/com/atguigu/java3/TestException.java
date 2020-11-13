package com.atguigu.java3;

public class TestException {

    /*编写TestException类，在main方法中接收两个命令行参数，将它们转换为整数，并用第一个数除以第二个数，打印结果。
    在命令行运行程序，给出两个参数，测试以下情况，观察运行结果：
    其中某个参数不是数字
    什么都不传入
    第二个参数为0 */
    public static void main(String[] args) {
        System.out.println("main begin");

        //System.out.println(1.0 / 0); // Infinity
        //System.out.println(0.0 / 0); // NaN - Not a Number


        int n1 = Integer.parseInt(args[0]);
        int n2 = Integer.parseInt(args[1]);
        int n3 = n1 / n2;
        System.out.println(n1 + " / " + n2 + " = " + n3) ;

        System.out.println("我是核心代码");
    }
}
