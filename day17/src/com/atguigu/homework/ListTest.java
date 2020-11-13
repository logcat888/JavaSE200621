package com.atguigu.homework;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author chenhuiup
 * @create 2020-07-15 下午 2:33
 */
public class ListTest {

    @Test
    public void test1(){
        List list = new ArrayList();
        for (int i = 0; i < 10; i++) {
            list.add((int)(Math.random()*21));
        }
        System.out.print(list);
        System.out.println(list.remove(3));
        System.out.println(list);
        System.out.println();
        list.clear();
        System.out.println(list.size());

        int num = 0;
        for (int i = 0; i < 10;) {
            num = (int)(Math.random()*21);
            if (!list.contains(num)){
                list.add(num);
                i++;
            }
        }
        System.out.println(list.size());
        System.out.println(list);

        Object[] objects = list.toArray();

        Arrays.sort(objects, new Comparator() {

            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Integer && o1 instanceof Integer){
                    Integer t1 = (Integer) o1;
                    Integer t2 = (Integer) o2;
                    return t1 - t2;
                }
                throw new RuntimeException("输入类型不一致");
            }
        });

        for (Object obj:objects){
            System.out.print(obj + " ");
        }

////        for (int i = 0; i < list.size() - 1; i++) {
////            for (int j = 0; j < list.size() - 1 -i; j++) {
//////
////            }
//        }
    }
}
