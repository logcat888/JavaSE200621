package com.atguigu.homework;

import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author chenhuiup
 * @create 2020-07-17 上午 10:42
 *
 * /*编写程序，在main方法中创建Map集合（使用泛型），用来存放圆的半径（key）和面积（value）；
 * 以半径为key，面积为value，将半径1-50的圆面积数据(直接取整)保存其中；
 * 将Map中的半径数据取至Set集合中；
 * 遍历Set集合的半径，逐一从Map中取出对应的面积值，并将半径和面积打印出来。
 */
public class exer1 {

    @Test
    public void test1(){
        Map<Integer, Double> map = new HashMap<>();
        int key = 1;
        while (key != 51){//将半径1-50的圆面积数据(直接取整)保存在map中
            map.put(key,3.14 * key * key);
            key++;
        }
        System.out.println(map);

        Set<Integer> set = map.keySet();
       Iterator<Integer> iterator = set.iterator();
       while(iterator.hasNext()){
           Integer key1 = iterator.next();
           Double value = map.get(key1);
           System.out.println("半径为" + key1 + ",面积为" + value);
       }
    }

    /*
    public static int hashCode(int value) {//Integer 的hashCode()返回数值，不具有散列性
        return value;
    }

    static final int hash(Object key) {//HashMap获取key的hash值
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16); //1的hash为1，2的hash为2
    }


    final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
                   boolean evict) {
        Node<K,V>[] tab; Node<K,V> p; int n, i;
        if ((tab = table) == null || (n = tab.length) == 0)
            n = (tab = resize()).length;
        if ((p = tab[i = (n - 1) & hash]) == null)//判断Node中的i位置上是否有值，进行&运算（hash多少就表现为多少），没有就存储。n是数组长度。
                                                    //1的索引是1，2的索引为2，所有Integer存储的时候表现为顺序。
            tab[i] = newNode(hash, key, value, null);


     */
}
