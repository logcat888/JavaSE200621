package com.atguigu.java1;

class Student implements Comparable {

    private int id;
    private String name;
    private int grade;
    private double score;

    public Student() {
    }

    public Student(int id, String name, int grade, double score) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", score=" + score +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        if (!(o instanceof Student)) {
            return 0x7FFFFFFF;
        }
        Student s2 = (Student)o;
        if (this.score > s2.score) {
            return 1;
        } else if (this.score < s2.score) {
            return -1;
        }
        return 0;
    }
}


public class ComparableTest {

    public static void main(String[] args) {
        Student s1 = new Student(1, "小明", 5, 80);
        Student s2 = new Student(2, "小丽", 2, 90);
        System.out.println(s1.compareTo(s2));
        Student[] arr = new Student[5];
        arr[0] = s1;
        arr[1] = s2;
        arr[2] = new Student(3, "小刚", 3, 20);
        arr[3] = new Student(4, "小花", 1, 100);
        arr[4] = new Student(5, "小芳", 6, 70);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println("**********************************");
        // 排序 : 冒泡
        ComparableUtil.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println("**********************************");

        String[] arr2 = {"我和你", "BC", "1242342", "afksjdf", "lsjdfs"};
        ComparableUtil.sort(arr2);

        for (int i = 0; i < arr2.length; i++) {
            System.out.println(arr2[i]);
        }
    }
}
