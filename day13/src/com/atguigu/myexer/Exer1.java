package com.atguigu.myexer;

/**
 * 1、声明抽象父类Person，包含抽象方法public abstract void eat();
 * 	2、声明子类中国人Chinese，重写抽象方法，打印用筷子吃饭
 * 	3、声明子类美国人American，重写抽象方法，打印用刀叉吃饭
 * 	4、声明子类印度人Indian，重写抽象方法，打印用手抓饭
 * 	5、声明测试类Test11，创建Person数组，存储各国人对象，并遍历数组，调用eat()方法
 * @author chenhuiup
 * @create 2020-07-10 下午 5:31
 */
public class Exer1 {
    public static void main(String[] args) {
        Person[] person = new Person[]{new Chinese(),new American(),new Indian()};//为person添加3个对象元素
       //并遍历数组，调用eat()方法
        for (int i = 0; i < person.length; i++) {
            System.out.print(person[i]);
            person[i].eat();
        }
    }
}

abstract class Person{
    public abstract void eat();//表示吃饭的方法

    @Override
    public String toString() {
        return "Person{}";
    }
}

class Chinese extends Person{

    @Override
    public void eat() {
        System.out.println("用筷子吃饭");
    }

    @Override
    public String toString() {
        return "Chinese: ";
    }
}

class American extends Person{

    @Override
    public void eat() {
        System.out.println("用刀叉吃饭");
    }

    @Override
    public String toString() {
        return "American: " ;
    }
}

class Indian extends Person{

    @Override
    public void eat() {
        System.out.println("用手抓饭");
    }

    @Override
    public String toString() {
        return "Indian: ";
    }
}

