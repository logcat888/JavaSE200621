package com.atguigu.myexer;

/**
 * @author chenhuiup
 * @create 2020-07-03 上午 11:53
 */
public class Exer1 {
    public static void main(String[] args) {
        Person test = new Person();
        test.setAge(6);
        System.out.println(test.getAge());

    }
}

class Person{
    private int age;

    public void setAge(int age){
        if (age > 0 && age < 130){
            this.age = age;
            return;
        }
        System.out.println("您输入的年龄非法！");

    }

    public int getAge(){
        return age;
    }
}