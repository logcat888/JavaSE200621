package com.atguigu.myexer;

/**
 * @author chenhuiup
 * @create 2020-07-04 下午 1:34
 */
public class Student extends Person{
    long number;
    int math;
    int english;
    int computer;

    public Student(long number, int math, int english, int computer) {
        this.number = number;
        this.math = math;
        this.english = english;
        this.computer = computer;
    }

    public double aver(){
        return (math + english + computer) / 3;
    }

    public int max(){
         int max = (math > english)? math:english;
         return (max > computer)? max:computer;
    }

    public int min(){
        int min = (math < english)? math:english;
        return (min < computer)? min:computer;
    }

    public String toString(){
        return "Student { number =" + number + ", math =" + math + ", english =" + english + ", computer" + computer + '}';
    }
}
