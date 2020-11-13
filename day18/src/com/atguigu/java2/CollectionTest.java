package com.atguigu.java2;

import org.junit.Test;

import java.util.*;

/**
 * 泛型 : generic 技术, 解决类型的安全问题.
 * 用在集合中作用就是使得集合中的对象的类型固定. 使用就更安全
 * 使用 : 集合类<元素类型> = new 子类<元素类型>(). <>中的内容称为泛型的类型参数.
 * 像数组 : 元素类型[] arr;
 *
 * 使用泛型后, 添加元素时只能添加固定类型的元素, 获取元素时直接获取到固定类型的元素.不需要造型.
 */

class Student implements Comparable {

    private int id;
    private String name;
    private int grade;
    private double score;

    public Student() {}

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
        return (int)(this.score - ((Student)o).score);
    }
}

public class CollectionTest {

    @Test
    public void test4() {
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(11);
        list.add(22);
        list.add(44);
        list.add(55);
        list.add(50);
        list.add(70);
        list.add(20);

        System.out.println(list);

        Iterator<Integer> iterator = list.iterator();

        list.remove(2);

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println(list);
    }

    @Test
    public void test3() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add((int)(Math.random() * 20));
        }
        System.out.println(list);
        Collections.sort(list); // 排序
        System.out.println(list);
        Collections.reverse(list); // 反转
        System.out.println(list);
        Collections.shuffle(list); // 洗牌
        System.out.println(list);

        System.out.println(Collections.max(list));
        System.out.println(Collections.min(list));
    }

    @Test
    public void test2() {
        Set<Integer> set = new HashSet<Integer>();
        while (set.size() != 10) {
            set.add((int) (Math.random() * 20));
        }
        //set.add("abc"); 体现类型安全
        //System.out.println(set);
        List<Integer> list = new ArrayList<Integer>(set); //直接把set集合中的元素全部添加到当前list集合中.
        //list.addAll(set); // 直接把set集合中的元素全部添加到当前list集合中.
        int[] arr = {3, 2, 1};
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        for (Integer tmp : set) { // 增强for统一数组和集合的遍历.
            System.out.println(tmp);
        }

        System.out.println("****************************");

        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            System.out.println(next);
        }

        System.out.println(list);
        // 排序 :
        for (int i = 0; i < list.size() - 1; i++) {
            // 以位置为主导, 以i位置为基准位置, 找出包括基准位置到后面所有数中的最小值的下标
            int minIndex = i;
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j) < list.get(minIndex)) {
                    minIndex = j;
                }
            }
            // 让最小值归位
            Integer tmp = list.get(i);
            list.set(i, list.get(minIndex));
            list.set(minIndex, tmp);
        }
        // 遍历
        System.out.println(list);

        int sum = 0;
        Iterator<Integer> iterator1 = list.iterator();
        while (iterator1.hasNext()) {
            Integer next = iterator1.next();
            sum += next;
        }
        double avg = (double)sum / list.size();
        System.out.println("avg = " + avg);
    }

    @Test
    public void test1() {
        Set<Student> set = new TreeSet<Student>(new Comparator() {
                                                        @Override
                                                        public int compare(Object o1, Object o2) {
                                                            return ((Student)o1).getGrade() - ((Student)o2).getGrade();
                                                        }
                                                 });

        set.add(new Student(1, "小明", 5, 80));
        set.add(new Student(2, "小丽", 4, 20));
        set.add(new Student(3, "小花", 6, 90));
        set.add(new Student(4, "小刚", 1, 100));
        set.add(new Student(5, "小伟", 3, 99));

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next);
        }

        // 求全校最高分
        double max = -1;
        for (Student tmp : set) {
            if (tmp.getScore() > max) {
                max = tmp.getScore();
            }
        }
        System.out.println("max = " + max);

    }
}
