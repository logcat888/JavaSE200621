package com.atguigu.myexer;

public class Exer1 {
    public static void main(String[] args) {
       Student student = new Student();
       student.name = "苟三";
       student.gender = "男";
       student.age = 15;
       student.id = 2222222;
       student.score = 55;
       String info = student.say();
        System.out.println(info);
    }
}

class Student{
    String name;
    String gender;
    int age;
    int id;
    double score;

    public String say(){
        String info = "name: " + name + ",gender: " + gender + ",age:" + age + ",id:" + id + ",score" + score;
        return info;
    }
}
