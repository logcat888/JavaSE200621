package com.atguigu.java2;

import java.util.*;

public class HomeWork {

    public static void main(String[] args) {
        /*创建一个Set集合, 保存10个随机的20以内的整数
        再把Set中的所有数保存在另一个List集合中, 对其进行排序
        求出这个List中的数的平均值.*/
        Set set = new HashSet();
        while (set.size() != 10) {
            set.add((int) (Math.random() * 20));
        }
        //System.out.println(set);

        List list = new ArrayList(set); //直接把set集合中的元素全部添加到当前list集合中.
        //list.addAll(set); // 直接把set集合中的元素全部添加到当前list集合中.
        int[] arr = {3, 2, 1};
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        for (Object tmp : set) { // 增强for统一数组和集合的遍历.
            System.out.println(tmp);
        }

        System.out.println("****************************");

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next);
        }

        System.out.println(list);
        // 排序 :
        for (int i = 0; i < list.size() - 1; i++) {
            // 以位置为主导, 以i位置为基准位置, 找出包括基准位置到后面所有数中的最小值的下标
            int minIndex = i;
            for (int j = i + 1; j < list.size(); j++) {
                if ((Integer)list.get(j) < (Integer)list.get(minIndex)) {
                    minIndex = j;
                }
            }
            // 让最小值归位
            Object tmp = list.get(i);
            list.set(i, list.get(minIndex));
            list.set(minIndex, tmp);
        }
        // 遍历
        System.out.println(list);

        int sum = 0;
        Iterator iterator1 = list.iterator();
        while (iterator1.hasNext()) {
            Object next = iterator1.next();
            sum += (Integer)next;
        }
        double avg = (double)sum / list.size();
        System.out.println("avg = " + avg);
    }
}
