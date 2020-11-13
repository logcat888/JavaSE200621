package com.atguigu.java3;

import com.atguigu.java2.Employee;
import com.atguigu.java2.EmployeeData;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 * 测试Stream的终止操作
 * @author chenhuiup
 * @create 2020-08-16 下午 4:16
 */
public class StreamAPITest2 {
    //1 - 匹配与查找
    @Test
    public void test1(){
        List<Employee> employees = EmployeeData.getEmployees();
//        allMatch(Predicate p)——检查是否匹配所有元素
//        练习：是否所有的员工的年龄都大于18
        boolean b = employees.stream().allMatch(e -> e.getAge() > 18);
        System.out.println(b);
//        anyMatch(Predicate p)——检查是否至少匹配一个元素
//        练习：是否存在员工的工资大于 10000
        boolean b1 = employees.stream().anyMatch(employee -> employee.getSalary() > 10000);
        System.out.println(b1);
//        noneMatch(Predicate p)——检查是否没有匹配所有元素
//        练习：是否存在员工姓“雷”
        boolean b2 = employees.stream().noneMatch(employee -> employee.getName().startsWith("雷"));
        System.out.println(b2);
//        findFirst()——返回第一个元素
        Optional<Employee> first = employees.stream().findFirst();
        System.out.println(first);
//        findAny()——返回当前流中的任意元素
//        Optional<Employee> any = employees.stream().findAny();//顺序流始终从第一个取
        Optional<Employee> any = employees.parallelStream().findAny();
        System.out.println(any);

    }

    @Test
    public void test2(){
        List<Employee> employees = EmployeeData.getEmployees();
//        count()——返回流中元素总数
//        练习：统计工资大于5000的员工个数
        long count = employees.stream().filter(e -> e.getSalary() >5000).count();
        System.out.println(count);

//        max(Comparator c)——返回流中最大值
//        练习：返回最高的工资
//        Optional<Employee> max = employees.stream().max((e1, e2) -> Double.compare(e1.getSalary(),e2.getSalary()));
//        System.out.println(max);
        Optional<Double> max = employees.stream().map(e -> e.getSalary()).max(Double::compareTo);
        System.out.println(max);

//        min(Comparator c)——返回流中最小值
//        练习：返回最低工资的员工
        Optional<Employee> min = employees.stream().min((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        System.out.println(min);
        System.out.println("***************************************");

//        forEach(Consumer c)——内部迭代(使用 Collection 接口需要用户去做迭代，称为外部迭代。相反，Stream API 使用内部迭代——它帮你把迭代做了)
        employees.stream().forEachOrdered(System.out::println);
        System.out.println("*********************");
        employees.stream().forEach(System.out::println);
        System.out.println("*********************");

        //使用集合的遍历操作
        employees.forEach(System.out::println);
    }

    //2-规约
    @Test
    public void test3(){
//        reduce(T iden, BinaryOperator b) 可以将流中元素反复结合起来，得到一个值。返回 T
//        练习1：计算1-10的自然数的和
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer reduce = list.stream().reduce(0, Integer::sum);
        System.out.println(reduce);

//        reduce(BinaryOperator b) 可以将流中元素反复结合起来，得到一个值。返回 Optional<T>
//        备注：map 和 reduce 的连接通常称为 map-reduce 模式，因 Google用它来进行网络搜索而出名。
//        练习2：计算公司所有员工工资的总和
        List<Employee> employees = EmployeeData.getEmployees();
//        Optional<Double> reduce1 = employees.stream().map(Employee::getSalary).reduce(Double::sum);
        Optional<Double> reduce1 = employees.stream().map(Employee::getSalary).reduce((d1,d2) -> d1 +d2);
        System.out.println(reduce1);
    }


    //3-收集
    @Test
    public void test4(){
//        collect(Collector c)——将流转换为其他形式。接收一个 Collector 接口的实现，用于给Stream中元素做汇总的方法
//        Collector 接口中方法的实现决定了如何对流执行收集的操作(如收集到 List、Set、Map)。另外， Collectors 实用类提供了很多静态方法，
//        可以方便地创建常见收集器实例
//        练习1：查找工资大于6000的员工，结果返回为一个List或Set
        List<Employee> employees = EmployeeData.getEmployees();
        List<Employee> collect = employees.stream().filter(e -> e.getSalary() > 6000).collect(Collectors.toList());
        collect.forEach(System.out::println);

        System.out.println("***********************************");
        Set<Employee> collect1 = employees.stream().filter(e -> e.getSalary() > 6000).collect(Collectors.toSet());
        collect1.forEach(System.out::println);
    }
}