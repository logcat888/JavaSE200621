package com.atguigu.collection;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetExer {

    public static void main(String[] args) {
        Set set = new TreeSet(new Comparator() {
                                    @Override
                                    public int compare(Object o1, Object o2) {
                                        return (int)(((Person)o1).getWeight() - ((Person)o2).getWeight());
                                    }
                             });

        Person p1 = new Person("张三", 30, "男", 90);
        Person p2 = new Person("李四", 40, "女", 50);
        Person p3 = new Person("王五", 10, "男", 70);
        Person p4 = new Person("王六", 50, "男", 30);

        set.add(p1);
        set.add(p2);
        set.add(p3);
        set.add(p4);

        for (Object obj : set) {
            System.out.println(obj);
        }
    }

    public static void main3(String[] args) {
        Person p1 = new Person("张三", 30, "男", 90);
        Person p2 = new Person("李四", 40, "女", 50);
        Person p3 = new Person("王五", 10, "男", 70);

        Set set = new TreeSet();
        set.add(p1);
        set.add(p2);
        set.add(p3);

        for (Object obj : set) {
            System.out.println(obj);
        }
    }

    public static void main2(String[] args) {
        // 写一个类Person, name,age,gender, 创建几个对象, 有内容相同的对象, 添加到HashSet集合中
        // 如果想让HashSet帮助去重, 怎么做???
        Person p1 = new Person("张三", 30, "男", 20);
        Person p2 = new Person("李四", 40, "女", 70);
        Person p3 = new Person("张三", 30, "男", 30);

        Set hashSet = new HashSet();
        hashSet.add(p1);
        hashSet.add(p2);
        hashSet.add(p3);

        for (Object obj : hashSet) {
            System.out.println(obj);
        }
    }
}
