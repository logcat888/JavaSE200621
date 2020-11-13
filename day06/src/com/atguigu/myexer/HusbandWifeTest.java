package com.atguigu.myexer;

public class HusbandWifeTest {
    public static void main(String[] args) {
        Husband husband = new Husband();
//        Wife wife = new Wife();

//        wife.name = "张三";
//        wife.age = 25;
        husband.name = "李四";
        husband.age = 27;
        husband.wife = new Wife();
        husband.wife.name = "王麻子";
        husband.wife.age = 25;
//        wife.getInfo(husband);
        husband.getInfo(husband.wife);
    }
}

class Husband{
    String name;
    int age;
    Wife wife;

    public void getInfo(Wife wife){
        this.wife = wife;
        System.out.println("丈夫的姓名为： " + name + "；他的年龄为： " + age);
        System.out.println("他妻子的姓名为： " + this.wife.name + "；她的年龄为： " + this.wife.age);
    }
}

class Wife{
    String name;
    int age;
    Husband husband;

    public void getInfo(Husband husband){
        System.out.println("妻子的姓名为： " + name + "；她的年龄为： " + age);
        System.out.println("她丈夫的姓名为： " + husband.name + "；他的年龄为： " + husband.age);
    }
}