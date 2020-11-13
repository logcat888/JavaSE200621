package com.atguigu.homework;

import org.junit.Test;

import java.util.*;

/**
 * @author chenhuiup
 * @create 2020-07-17 下午 3:41
 *
 * // 写一个方法double max(List list)
 * // 在测试方法中创建两个List,一个是泛型是整数的, 放一些随机整数, 另一个泛型是Double型,
 * 放一些随机数, 通过方1法获取这两个集合的最大值
 */
public class exer3 {

    static double max(List<? extends Number> list){
        double max = list.get(0).doubleValue();
        for (int i = 1; i < list.size(); i++) {
            if (max < list.get(i).doubleValue()){
                max = list.get(i).doubleValue();
            }
        }
        return max;
    }

    static Number max1(List<? extends Number> list){
        Number max = list.get(0);
        Iterator<? extends Number> iterator = list.iterator();
        while (iterator.hasNext()){
            Number next = iterator.next();
            if (next.doubleValue() > max.doubleValue()){
                max = next;
            }
        }
        return max;
    }

    static Number max2(Collection<? extends Number> list){
        Iterator<? extends Number> iterator = list.iterator();
        Number max;
        if (iterator.hasNext()) {
            max = iterator.next();
        }else {
            return null;
        }
        while (iterator.hasNext()){
            Number next = iterator.next();
            if (next.doubleValue() > max.doubleValue()){
                max = next;
            }
        }
        return max;
    }

    static Comparable max3(Collection<? extends Comparable> list){
        Iterator<? extends Comparable> iterator = list.iterator();
        Comparable max;
        if (iterator.hasNext()) {
            max = iterator.next();
        }else {
            return null;
        }
        while (iterator.hasNext()){
            Comparable next = iterator.next();
            if (next.compareTo(max) > 0){
                max = next;
            }
        }
        return max;
    }

    @Test
    public void test4(){//max方法返回Number类型
        List<Integer> list1 = new ArrayList<Integer>();
        while(list1.size() != 10){
            list1.add((int)(Math.random()*20));
        }
        Set set2 = new HashSet();
        set2.add("95");
        set2.add("我是");
        set2.add("wosj");
        set2.add("哈哈");

        System.out.println(list1);
        System.out.println(set2);
        System.out.println(max3(list1));
        System.out.println(max3(set2));
    }

    @Test
    public void test3(){//max2方法返回Number类型,参数类型可以使List或Set
        List<Integer> list1 = new ArrayList<Integer>();
        while(list1.size() != 10){
            list1.add((int)(Math.random()*20));
        }
        Set<Double> set2 = new HashSet<>();
        while(set2.size() != 10){
            set2.add(Math.random()*20);
        }
        System.out.println(list1);
        System.out.println(set2);
        System.out.println(max2(list1));
        System.out.println(max2(set2));
    }

    @Test
    public void test2(){//max1方法返回Number类型
        List<Integer> list1 = new ArrayList<Integer>();
        while(list1.size() != 10){
            list1.add((int)(Math.random()*20));
        }
        List<Double> list2 = new ArrayList<>();
        while(list2.size() != 10){
            list2.add(Math.random()*20);
        }

        System.out.println(max1(list1));
        System.out.println(max1(list2));
    }

    @Test
    public void test1(){//max方法只能返回double类型
        List<Integer> list1 = new ArrayList<Integer>();
        while(list1.size() != 10){
            list1.add((int)(Math.random()*20));
        }
        List<Double> list2 = new ArrayList<>();
        while(list2.size() != 10){
            list2.add(Math.random()*20);
        }

        System.out.println(max(list1));
        System.out.println(max(list2));
    }
}
