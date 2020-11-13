package com.atguigu.java;

import org.junit.Test;

import java.util.*;

public class GenericTest2 {

    public static Comparable max(Collection<? extends Comparable> col) {
        // 找出最大值
        Iterator<? extends Comparable> iterator = col.iterator();
        Comparable max = iterator.next();
        while (iterator.hasNext()) {
            Comparable next = iterator.next();
            if (next.compareTo(max) > 0) {
                max = next;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list1.add((int) (Math.random() * 20));
        }
        System.out.println(list1);
        System.out.println(max(list1));

        List<Double> list2 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list2.add((Math.random() * 20));
        }
        System.out.println(list2);
        System.out.println(max(list2));

        Set<Float> set1 = new HashSet<Float>();
        for (int i = 0; i < 10; i++) {
            set1.add((float)Math.random() * 10);
        }
        System.out.println(set1);
        System.out.println(max(set1));

        Set<String> set2 = new HashSet<String>();
        set2.add("999");
        set2.add("去就IC");
        set2.add("asdlfjlakj");
        set2.add("SFASDFAdf");
        set2.add("oiiiiasdf");

        System.out.println(max(set2));

    }

    // 写一个方法double max(List list)

    public static Number max2(List<? extends Number> list) {
        // 找出最大值
        Number max = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            Number number = list.get(i);
            if (number.doubleValue() > max.doubleValue()) {
                max = number;
            }
        }
        return max;
    }

    public static double max1(List<? extends Number> list) {
        // 找出最大值
        double max = list.get(0).doubleValue();
        for (int i = 1; i < list.size(); i++) {
            Number number = list.get(i);
            if (number.doubleValue() > max) {
                max = number.doubleValue();
            }
        }
        return max;
    }

    // 在测试方法中创建两个List,一个是泛型是整数的, 放一些随机整数, 另一个泛型是Double型, 放一些随机数, 通过方法获取这两个集合的最大值
    public static void main2(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list1.add((int) (Math.random() * 20));
        }
        System.out.println(list1);
        System.out.println(max(list1));

        List<Double> list2 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list2.add((Math.random() * 20));
        }
        System.out.println(list2);
        System.out.println(max(list2));
    }

    // List<? extends Number> 适用于从集合中获取元素的操作.
    public static double avg(List<? extends Number> list) {
        double sum = 0;
        for (int i = 0; i < list.size(); i++) {
            Number number = list.get(i);
            sum += number.doubleValue();
        }
        return sum / list.size();
    }


    @Test
    public void test4() {
        List<Integer> list1 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list1.add((int) (Math.random() * 20));
        }
        System.out.println(list1);
        System.out.println(avg(list1));

        List<Double> list2 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list2.add((Math.random() * 20));
        }
        System.out.println(list2);
        System.out.println(avg(list2));
    }

    @Test
    public void test3() {
        List<Integer> list1 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list1.add((int) (Math.random() * 20));
        }
        //List<?> list = new ArrayList<Object>();
        List<? super Number> list2 = null; // list2集合中可以保存Number及其未知父类的对象
        list2.add(3.22); // 可以添加元素
        list2.add(500);
        list2.add(null);

        Object object = list2.get(0); // 不太适用于获取元素.

        List<? extends Number> list3 = null; // list3集合中可以保存Number及其未知子类的对象
        //list3.add(200); 不可以添加元素.
        //list3.add(null);
        //list3.add(3.22);
        Number number = list3.get(0); // 适用于获取元素.

    }

    public void travel(List<?> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    @Test
    public void test2() {
        List<Integer> list1 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list1.add((int) (Math.random() * 20));
        }
        travel(list1);

        List<Double> list2 = new ArrayList<Double>();
        for (int i = 0; i < 10; i++) {
            list2.add((Math.random() * 20));
        }
        travel(list2);
    }

    @Test
    public void test1() {
        //List<Number> list = new ArrayList<Integer>();
        //list.add(3.22); // 左面的集合中的类型是Number
        // 实际的却是Integer.
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add((int)(Math.random() * 20));
        }

        // ? 表示未知类型.
        List<?> list2 = list; // List2集合不适合添加元素
        //list2.add(300);
        //list2.add("abc");
        list2.add(null);

        Object tmp = list2.get(0); // 适用于访问集合.

    }
}
