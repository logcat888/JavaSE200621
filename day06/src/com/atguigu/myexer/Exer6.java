package com.atguigu.myexer;
/*
声明一个日期类型MyDate：有属性：年year,月month，日day。创建2个日期对象，分别赋值为：你的出生日期，你对象的出生日期，并显示信息。
 */
public class Exer6 {
    public static void main(String[] args) {
        MyData i = new MyData();
        MyData you = new MyData();

        i.show(1999,9,9);
        you.show(2000,2,2);
    }
}

class MyData{
    int year;
    int month;
    int day;

    public void show(int year,int month,int day){
        this.year = year;
        this.month = month;
        this.day = day;
        System.out.println("出生于" + this.year + "年" + this.month + "月" + this.day + "日");
    }
}
