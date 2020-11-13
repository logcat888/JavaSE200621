package com.atguigu.myexer;

import org.junit.Test;

import java.util.*;

/**
 *
 * 在当前项目下创建新的文本文件, 起名 test.properties, 里面写一些配置信息, 然后读取所有属性值.
 *
 * 1.请从命令行参数获取 10个整数字符串,并将它们转为整数并保存到List中，并按倒序、从大到小的顺序显示出来
 *
 * 2.请把学生名与考试分数录入到Map中，并按分数显示前三名成绩学员的名字。
 *
 * 总结ArrayList源码.
 *
 * 创建一个文件, 读取文件内容并打印输出
 *
 * 把文件内容读入一个集合, 排序后倒序打印...
 * @author chenhuiup
 * @create 2020-07-18 上午 9:56
 */
public class homework1 {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < args.length; i++) {
            list.add(Integer.parseInt(args[i]));
        }
        Collections.sort(list);
        Collections.reverse(list);
        System.out.println(list);
    }

    @Test
    public void test(){
        Map<String,Integer> map = new HashMap<>();
        map.put("Tom",99);
        map.put("Ace",95);
        map.put("Bob",99);
        map.put("Cat",78);
        map.put("Dog",65);
        map.put("Eat",73);
        System.out.println(map);

        TreeMap<Integer, String> treeMap = new TreeMap<>(new Comparator<Integer>(){

            @Override
            public int compare(Integer o1, Integer o2) {
                int n = o1 - o2;
                if (n == 0){
                    n = 1;
                }
                return -n;
            }
        });
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator1 = entries.iterator();
        while (iterator1.hasNext()){
            Map.Entry<String, Integer> entry1 = iterator1.next();
            treeMap.put(entry1.getValue(),entry1.getKey());
        }

        System.out.println(treeMap);
        Set<Map.Entry<Integer, String>> set = treeMap.entrySet();
        Iterator<Map.Entry<Integer, String>> iterator = set.iterator();
        int count = 0;
        while(iterator.hasNext()){
            if (count++ == 3){
                break;
            }
            Map.Entry<Integer,String> entry = iterator.next();
            System.out.println(entry);
        }
    }


    @Test
    public void test1(){
        Map<String,Integer> map = new HashMap<>();
        map.put("Tom",99);
        map.put("Ace",95);
        map.put("Bob",99);
        map.put("Cat",78);
        map.put("Dog",65);
        map.put("Eat",73);
        System.out.println(map);

        List<Map.Entry<String, Integer>> list =new ArrayList<>();
        Set<Map.Entry<String, Integer>> set = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = set.iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Integer> next = iterator.next();
            list.add(next);
        }

        System.out.println(list);

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                int n = o1.getValue() - o2.getValue();
                if (n == 0){
                    n = 1;
                }

                return -n;
            }
        });

        Iterator<Map.Entry<String, Integer>> iterator1 = list.iterator();
        int count = 0;
        while (iterator1.hasNext()){
            if (count == 3){
                break;
            }
            System.out.println(iterator1.next());
            count++;
        }
        HashSet hashSet = new HashSet();
    }
}
