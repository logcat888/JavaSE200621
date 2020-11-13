package com.atguigu.java2;

import org.junit.Test;

import java.util.*;

/**
 * 集合Collection
 *      Set : 无序不可重复
 *          HashSet : 使用哈希算法实现的Set集合
 *              优点 : 全是优点
 *              缺点 : 唯一缺点就是费内存.
 *          TreeSet : 基于二叉搜索树(红黑树)实现的Set集合. 适用场景 : 频繁检索, 内存要求低的场景.
 *              优点 : 对内存要求低, 检索速度非常快, 因为是基于二分法.
 *              缺点 : 插入和删除速度慢, 因为要有大量的比较和平衡.
 *      List : 有序可重复
 *          ArrayList : 基于数组实现的List集合. 适用场景 : 存档数据, 偶尔进行检索.
 *              缺点 : 对内存要求高, 要求连续, 非末端修改最慢.
 *              优点 : 检索速度快, 末端操作快
 *          LinkedList : 基于链表实现的List集合. 适用场景 : 频繁的修改数据的场合.
 *              优点 : 对内存要求低, 插入和删除操作都非常快.
 *              缺点 : 检索速度最慢
 */


public class Work {

    @Test
    public void test3() {
        List<String> list = new LinkedList<>();
        list.add("xx");
        list.add("11");
        list.add("33");
        list.add("bb");
        list.add("qq");
        list.add("zz");
        list.add("qq");
        list.add("yy");

        System.out.println(list);

        list.remove("bb");

        System.out.println(list);
    }

    //请从命令行参数获取 10个整数字符串,并将它们转为整数并保存到List中，并按倒序、从大到小的顺序显示出来
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
    public void test2() {
        //请把学生名与考试分数录入到Map中，并按分数显示前三名成绩学员的名字。
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("小明", 80);
        map.put("小刚", 90);
        map.put("小共", 100);
        map.put("小花", 92);
        map.put("小磊", 70);
        map.put("小丽", 20);
        map.put("小琳", 100);
        map.put("小芳", 99);
        map.put("小伟", 20);

        ArrayList<Map.Entry<String, Integer>> list = new ArrayList(map.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
                                    @Override
                                    public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                                        return -(o1.getValue() - o2.getValue());
                                    }
                                });
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
            if (i == 2) {
                break;
            }
        }

    }

    @Test
    public void test1() {
        //请把学生名与考试分数录入到Map中，并按分数显示前三名成绩学员的名字。
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("小明", 80);
        map.put("小刚", 90);
        map.put("小共", 100);
        map.put("小花", 92);
        map.put("小磊", 70);
        map.put("小丽", 20);
        map.put("小琳", 100);
        map.put("小芳", 99);
        map.put("小伟", 20);

        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int n = o1 - o2;
                if (n == 0) {
                    n = 1;
                }
                return -n;
            }
        };

        Map<Integer, String> map2 = new TreeMap<Integer, String>(comparator);
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> next = iterator.next();
            map2.put(next.getValue(), next.getKey());
        }

        Set<Map.Entry<Integer, String>> entries1 = map2.entrySet();
        int count = 0;
        for (Map.Entry<Integer, String> entry : entries1) {
            System.out.println(entry);
            if (++count == 3) {
                break;
            }
        }
    }
}
