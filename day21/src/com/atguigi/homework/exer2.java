package com.atguigi.homework;

import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * @author chenhuiup
 * @create 2020-07-23 下午 2:08
 */
///给定一个字符串, 统计每个字符出现的次数
public class exer2 {
    @Test
    public void test(){
        String str = new String("sdfasdfasdsdfwefwefba的是否具备发生佛为你拉fw 下文女efsdnvi");
        HashMap hashMap = new HashMap();
        Integer integer = 1;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (hashMap.containsKey(c)){
                hashMap.put(c,(Integer)hashMap.get(c) + 1);
            }else {
                hashMap.put(c,integer);
            }
        }
        Set set = hashMap.entrySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test1(){
        String str = new String("sdfasdfasdsdfwefwefba的是否具备发生佛为你拉fw 下文女efsdnvi");
        HashMap<Character,Integer> hashMap = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            Integer count = hashMap.get(c);
            if (count == null){
                count = 0;
            }
            hashMap.put(c,count);
        }
    }

    @Test
    public void test2(){
        String str = new String("sdfasdfasdsdfwefwefba的是否具备发生佛为你拉fw 下文女efsdnvi");
        int[] arr = new int[65535];
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            arr[c] += 1;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0){
                System.out.println((char)i + " = " + arr[i]);
            }
        }
    }
    @Test
    public void test3(){
        int i = 0;
        i = i++;
        System.out.println(i);
    }

}
