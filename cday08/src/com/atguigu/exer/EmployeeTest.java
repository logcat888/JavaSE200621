package com.atguigu.exer;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 *  * 创建该类的 5 个对象，并把这些对象放入 TreeSet 集合中（下一章：TreeSet 需使用泛型来定义）
 *  分别按以下两种方式对集合中的元素进行排序，并遍历输出：
 *
 *  1). 使Employee 实现 Comparable 接口，并按 name 排序
 *  2). 创建 TreeSet 时传入 Comparator对象，按生日日期的先后排序。
 * @author chenhuiup
 * @create 2020-07-14 下午 10:10
 */
public class EmployeeTest {

    //问题二：按照生日日期的先后排序
    @Test
    public void test3(){
        //使用泛型以后的写法
        TreeSet<Employee> set = new TreeSet(new Comparator<Employee>() {
            @Override
            public int compare(Employee b1, Employee b2) {
                    return b1.compareTo(b2);

            }
        });

        //未使用泛型
//        TreeSet set = new TreeSet(new Comparator() {
//            @Override
//            public int compare(Object o1, Object o2) {
//                if (o1 instanceof Employee && o2 instanceof Employee){
//                    Employee b1 = (Employee)o1;
//                    Employee b2 = (Employee)o2;
//                    //方式一：
////                    //比较年
////                    int minusYear = b1.getYear() - b2.getYear();
////                    if(minusYear != 0){
////                        return minusYear;
////                    }
////                    //比较月
////                    int minusMonth = b1.getMonth() - b2.getMonth();
////                    if(minusMonth != 0){
////                        return minusMonth;
////                    }
////                    //比较日
////                    return b1.getDay() - b2.getDay();
//
//                    //方式二：
//                    return b1.compareTo(b2);
//                }else {
////                    return 0;
//                    throw new RuntimeException("传入的数据不一致");
//                }
//            }
//        });
        Employee e1 = new Employee("liudehua", 55, new MyDate(1965, 5, 4));
        Employee e2 = new Employee("zhangxueyou", 43, new MyDate(1987, 5, 4));
        Employee e3 = new Employee("guofucheng", 44, new MyDate(1987, 5, 9));
        Employee e4 = new Employee("liming", 51, new MyDate(1954, 8, 12));
        Employee e5 = new Employee("liangzhaowei", 21, new MyDate(1978, 12, 4));

        set.add(e1);
        set.add(e2);
        set.add(e3);
        set.add(e4);
        set.add(e5);

        Iterator<Employee> iterator = set.iterator();
        while(iterator.hasNext()){
            Employee next = iterator.next();
            System.out.println(next);
        }
    }

    //问题一：使用自然排序
    @Test
    public void test1() {
        TreeSet<Employee> set = new TreeSet<>();
        Employee e1 = new Employee("liudehua", 55, new MyDate(1965, 5, 4));
        Employee e2 = new Employee("zhangxueyou", 43, new MyDate(1987, 5, 4));
        Employee e3 = new Employee("guofucheng", 44, new MyDate(1987, 5, 9));
        Employee e4 = new Employee("liming", 51, new MyDate(1954, 8, 12));
        Employee e5 = new Employee("liangzhaowei", 21, new MyDate(1978, 12, 4));

        set.add(e1);
        set.add(e2);
        set.add(e3);
        set.add(e4);
        set.add(e5);

        Iterator<Employee> iterator = set.iterator();
        while(iterator.hasNext()){
            Employee next = iterator.next();
            System.out.println(next);
        }
    }

}
