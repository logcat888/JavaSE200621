package com.atguigu.java2;

import org.junit.Test;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 一、构造器引用
 *      和方法引用类似，函数式接口的抽象方法的形参列表和构造器的形参列表一致。
 *      抽象方法的返回值类型即为构造器所属的类的类型
 *
 * 二、数组引用
 *      大家可以把数组看做是一个特殊的类，则写法与构造器引用一致
 *
 * Created by shkstart
 */
public class ConstructorRefTest {
    //构造器引用
    //Supplier中的T get()
    // Employee 的空参构造器：Employee()
    @Test
    public void test1() {
        Supplier<Employee> sup = new Supplier<Employee>() {
            @Override
            public Employee get() {
                return new Employee();
            }
        };
        System.out.println(sup.get());
        System.out.println("*************************");

        Supplier<Employee> sup1 = () -> new Employee();
        System.out.println(sup1.get());
        System.out.println("*************************");

        Supplier<Employee> sup2 = Employee::new;
        System.out.println(sup2.get());
    }

    //Function中的R apply(T t)
    @Test
    public void test2() {
    Function<Integer,Employee> fun1 = id -> new Employee(id);
        Employee employee = fun1.apply(222);
        System.out.println(employee);
        System.out.println("**************");

        Function<Integer,Employee> fun2 = Employee::new;
        Employee employee1 = fun2.apply(235);
        System.out.println(employee1);
    }

    //BiFunction中的R apply(T t,U u)
    @Test
    public void test3() {
        BiFunction<Integer,String,Employee> biFunction = (id,name) -> new Employee(id,name);
        Employee 赵丽颖 = biFunction.apply(25, "赵丽颖");
        System.out.println(赵丽颖);

        System.out.println("****************");
        BiFunction<Integer,String,Employee> biFunction2 = Employee::new;
        Employee 陈钰琪 = biFunction2.apply(21, "陈钰琪");
        System.out.println(陈钰琪);

    }

    //数组引用
    //Function中的R apply(T t)
    @Test
    public void test4() {
    Function<Integer,String[]> function = length -> new String[length];
        String[] apply = function.apply(5);
        System.out.println(apply.length);

        Function<Integer,String[]> function2 = String[]::new;
        String[] apply1 = function2.apply(25);
        System.out.println(apply1.length);
    }
}
