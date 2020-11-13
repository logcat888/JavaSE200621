package com.atguigu.myexercise;
/*
编写程序，定义三个重载方法并调用。方法名为mOL。
三个方法分别接收一个int参数、两个int参数、一个字符串参数。分别执行平方运算并输出结果，相乘并输出结果，输出字符串信息。
在主类的main ()方法中分别用参数区别调用三个方法。

 */
public class Exer5 {
    public static void main(String[] args) {
        OverLoad overLoad = new OverLoad();
        overLoad.mOL(3);
        overLoad.mOL(3,4);
        overLoad.mOL("helloworld");
    }
}

class OverLoad{


    public void mOL(int x){
        System.out.println(x + "的平方为：" + x * x);
    }

    public void mOL(int x,int y){
        System.out.println(x + "和" + y + "的乘积为：" + x * y);
    }

    public void mOL(String string){
        System.out.println(string);
    }
}
