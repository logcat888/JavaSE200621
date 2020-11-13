package com.atguigu.myexercise;

import java.util.Arrays;

/*

对象数组题目：
定义类Student，包含三个属性：学号number(int)，年级state(int)，成绩score(int)。 创建20个学生对象，
学号为1到20，年级和成绩都由随机数确定。
问题一：打印出3年级(state值为3）的学生信息。
问题二：使用冒泡排序按学生成绩排序，并遍历所有学生信息

提示：
1) 生成随机数：Math.random()，返回值类型double;
2) 四舍五入取整：Math.round(double d)，返回值类型long。

 Student对象数组问题中涉及到的相关操作，封装进方法，测试执行。比如：打印年级是3年级的方法；
 学生数组对象的排序；遍历Student数组中对象的方法。
 */
public class Exer7 {
    public static void main(String[] args) {
        StudentSystem test = new StudentSystem(20);
        test.printState(3);//打印出3年级(state值为3）的学生信息。
        System.out.println("************按成绩高低排序*******************");
        test.sortStundets();//按成绩高低排序
        test.showStudents();//遍历Student数组
        System.out.println("************按照年级对学生数组排序*******************");
        test.sortStateStudent();//按照年级对学生数组排序
        test.showStudents();//遍历Student数组
        System.out.println("***************各年级人数****************");
        System.out.println(Arrays.toString(test.stateTotalStudentsNumber()));//各年级人数
        System.out.println("**************对各年级学生进行成绩排序*****************");
        test.stateStudentScore();//对各年级学生进行成绩排序
        test.showStudents();//遍历Student数组

    }
}

//学生信息
class Student{
    private int number;//学号
    private int state;//年级
    private int score;//分数

    public void setNumber(int number){
        this.number = number;
    }
    public int getNumber(){
        return number;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
    //输出学生信息
    public void showInfo(){
        System.out.println("学号为： " + number + ", 年级为： " + state + ", 分数： " + score);
    }
}

//学生管理系统
class StudentSystem{
    Student[] students;
    int totalNumberStudents;

    //制定学生数组的长度,并赋值年级和分数
    StudentSystem(int  totalNumberStudents){
        students = new Student[totalNumberStudents];
        for (int i = 0; i < students.length; i++) {
            students[i] = new Student();
            students[i].setNumber(i+1);
            students[i].setScore((int)(Math.random()*101));//赋值学生分数【0，100】
            students[i].setState((int) (Math.random()*6 + 1));//赋值学生年级【0,7】
        }
    }

    //打印某年级的学生信息
    public void printState(int state){
        for (int i = 0; i < students.length; i++) {
           if (students[i].getState() == state){
               students[i].showInfo();
           }
        }
    }

    //对学生数组成绩的排序，从小到大
    public void sortStundets(){
        for (int i = 0; i < students.length - 1; i++) {
            for (int j = 0; j < students.length -1 -i; j++) {
                if (students[j].getScore() > students[j + 1].getScore()) {
//                    Student temp = students[j];
//                    students[j] = students[j + 1];
//                    students[j + 1] = temp;
                    swap(students, j, j + 1);
                }
            }
        }
    }

    //对学生数组遍历
    public void showStudents(){
        for (int i = 0; i < students.length; i++) {
            students[i].showInfo();
        }
    }

    //按照年级对学生数组排序


    public void sortStateStudent(){
        for (int i = 0; i < students.length - 1; i++) {
            for (int j = 0; j < students.length - 1 -i; j++) {
                if (students[j].getState() > students[j + 1].getState()){
                    swap(students,j,j + 1);
                }
            }
        }
    }

    //统计各年级学生的人数,并返回一个各年级人数数组
    public int[] stateTotalStudentsNumber(){
        int[] stateTotalStudent = new int[6];
        for (int i = 0; i < students.length; i++) {
            switch (students[i].getState()){
                case 1:
                    stateTotalStudent[0] += 1;
                    break;
                case 2:
                    stateTotalStudent[1] += 1;
                    break;
                case 3:
                    stateTotalStudent[2] += 1;
                    break;
                case 4:
                    stateTotalStudent[3] += 1;
                    break;
                case 5:
                    stateTotalStudent[4] += 1;
                    break;
                case 6:
                    stateTotalStudent[5] += 1;
                    break;
            }

        }
        return stateTotalStudent;
    }

    //按照年级排序好的学生数组，对学生成绩进行排序

    public void stateStudentScore(){
        sortStateStudent();//按照年级对学生数组排序
        int[] array = stateTotalStudentsNumber();//各年级人数的数组
        for (int i = 0; i < 6; i++) {//遍历1-6年级的学生
            int count = 0;
            for (int j = 0; j < array[i] - 1; j++) {
                for (int k = count; k < count + array[i] -1 - j; k++) {
                    if (students[k].getState() > students[k + 1].getState()) {
                        swap(students,k,k + 1);
                    }

                }

            }

            count += array[i];
        }
    }

    //交换两个数组元素
    public void swap(Student[] students,int x,int y){
        Student temp = students[x];
        students[x] = students[y];
        students[y] = temp;
    }

}