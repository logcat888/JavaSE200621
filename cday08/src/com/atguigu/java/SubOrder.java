package com.atguigu.java;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenhuiup
 * @create 2020-07-16 上午 10:55
 */
public class SubOrder extends Order<Integer> {//SubOrder<T>:不再是泛型类

    public static <E> List<E> copyFromArrayToList(E[] arr){
        ArrayList<E> list = new ArrayList<>();
        for (E e: arr) {
            list.add(e);
        }
        return list;
    }
}
