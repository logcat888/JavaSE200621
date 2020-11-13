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

 */
/*
public class Exer4 {
    public static void main(String[] args) {
        Student[] student = new Student[20];
        //给学生编号、给信息
        for (int i = 0; i < student.length; i++) {
            student[i] = new Student();
            student[i].setNumber(i + 1);
            student[i].setScore();
            student[i].setState();
        }
        //打印出3年级(state值为3）的学生信息。
        for (int i = 0; i < student.length; i++) {
            if (student[i].getState() == 3){
                System.out.println(student[i].infoShow());
            }
        }
        System.out.println("***************************");
        //使用冒泡排序按学生成绩排序，并遍历所有学生信息
        //学生成绩的排序
        for (int i = 0; i < student.length - 1; i++) {
            for (int j = 0; j < student.length - 1 -i; j++) {
                if (student[j].getScore() > student[j + 1].getScore()){
                    Student temp = student[j];
                    student[j] = student[j + 1];
                    student[j + 1] = temp;
                }
            }
        }

        //遍历所有学生的信息
        for (int i = 0; i < student.length; i++) {
            System.out.println(student[i].infoShow());
        }

        System.out.println("***************************");
        //使用冒泡排序按学生年级排序后再成绩排序，并遍历所有学生信息
        //学生年级的排序
        for (int i = 0; i < student.length - 1; i++) {
            for (int j = 0; j < student.length - 1 -i; j++) {
                if (student[j].getState() > student[j + 1].getState()){
                    Student temp = student[j];
                    student[j] = student[j + 1];
                    student[j + 1] = temp;
                }
            }
        }
        //获取不同年级学生的人数
        int[] stateTotalStudent = new int[6];
        for (int i = 0; i < student.length; i++) {
            switch (student[i].getState()){
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
        System.out.println(Arrays.toString(stateTotalStudent));//输出不同年级学生的人数

        //对各年级的学生成绩的排序，按照从小到大排序
        for (int i = 0; i < 6; i++) {//遍历1-6年级的学生
            int count = 0;
            for (int j = 0; j < stateTotalStudent[i] - 1; j++) {
                for (int k = count; k < count + stateTotalStudent[i] -1 - j; k++) {
                    if (student[k].getState() > student[k + 1].getState()) {
                        Student temp = student[k];
                        student[k] = student[k + 1];
                        student[k + 1] = temp;
                    }

                }

            }

            count += stateTotalStudent[i];
        }

            //遍历所有学生的信息
            for (int i = 0; i < student.length; i++) {
                System.out.println(student[i].infoShow());
            }
    }
}

class Student{
    private int number;//学号
    private int state;//年级
    private int score;//成绩

    public void setScore(){
        score = (int)(Math.random()*101);
    }
    public int getScore(){
        return score;
    }
    public void setState(){
        state = (int)(Math.random()*6 + 1);
    }
    public int getState(){
        return state;
    }

    public void setNumber(int number){
        this.number = number;
    }

    public int getNumber(){
        return number;
    }

    public String infoShow(){
        return "学号： " + number + "，年级为： " + state + ",成绩为：" + score;
    }
}

 */