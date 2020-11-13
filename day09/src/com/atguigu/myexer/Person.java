package com.atguigu.myexer;

/**
 * @author chenhuiup
 * @create 2020-07-04 下午 1:28
 */
public class Person {
    String name;
    char sex;
    int age;

    public Person(){

    }

    public Person(String name,char sex,int age){
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public String toString(){
        return "Person { name=" + name + '\'' + ", sex=" + sex + ", age=" + age + '}';
    }


//    @Override
//    public String toString() {
//        return "Person{" +
//                "name='" + name + '\'' +
//                ", sex=" + sex +
//                ", age=" + age +
//                '}';
//    }
}
