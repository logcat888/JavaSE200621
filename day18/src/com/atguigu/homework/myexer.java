package com.atguigu.homework;

import org.junit.Test;

import java.util.*;

/**
 * @author chenhuiup
 * @create 2020-07-17 上午 9:57
 *
 * 创建一个Set集合，保存10个随机的20以内的整数
 * 再把Set中的所有数保存在另一个List集合中，对其进行排序，求出这个List中的数的平均值。
 *
 */
public class myexer {

    @Test
    public void test1(){
       Set set = new HashSet();
       while (set.size() != 10){
           set.add((int)(Math.random()*20));
       }
        System.out.println(set);


       List list = new ArrayList();
       list.addAll(set);
        System.out.println(list);
//        Collections.sort(list);
//        System.out.println(list);
        int minindex;

        //选择排序
        for (int i = 0; i < list.size(); i++) {
//            //找到最小的元素
//            flag = (Integer) list.get(i);
//            for (int j = i + 1; j < set.size(); j++) {
//                if (flag > (Integer)list.get(j)){
//                    flag = (Integer)list.get(j);
//                }
//            }
//            //获取最小元素的索引
//            int num = list.indexOf(flag);
//            //交换元素
//            Object temp = list.get(i);//保存i索引的对象
//            list.set(i,flag);
//            list.set(num,temp);
            minindex = i;//初始最小值索引
            for (int j = i + 1; j <list.size();j++){//获取最小值索引
                if ((Integer)list.get(j) < (Integer)list.get(minindex)){
                    minindex = j;
                }
            }
            //最小值归位
            Object temp = list.get(i);
            list.set(i,list.get(minindex));
            list.set(minindex,temp);
        }
        System.out.println(list);
    }

    @Test
    public void test3(){
        char[] arr = new char[]{'1','2','3'};
        System.out.println(arr);
        int[] arr1 = new int[]{1,2,3};
        System.out.println(arr1);
        byte[] arr2 = new byte[]{1,2,3};
        System.out.println(arr2);

    }
}
