package com.atguigu.myexer;

public class HusbandWifeband1 {
    public static void main(String[] args) {
        Husband1 husband = new Husband1();
        Wife1 wife = new Wife1();

        wife.name = "张三";
        wife.age = 25;
        husband.name = "李四";
        husband.age = 27;
/*        husband.wife.name = "王麻子";
        husband.wife.age = 25;*/

        husband.getInfo();
        husband.wife = wife;
        husband.wife.getInfo();
    }
}

class Husband1 {
    String name;
    int age;
    Wife1 wife;

    public void getInfo() {
        System.out.println("丈夫的姓名为： " + name + "；他的年龄为： " + age);
    }
}

class Wife1 {
    String name;
    int age;
    Husband1 husband;

    public void getInfo() {
        System.out.println("妻子的姓名为： " + name + "；她的年龄为： " + age);
    }
}