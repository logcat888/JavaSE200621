package com.atguigu.java;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *  枚举 : 对象可数的类型
 */
enum MyEnum {
    ONE, TWO, THREE
}

/**
 * 注解 : 特殊的注释, 不参与程序的执行.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnn {
    int id() default 2;
}

@MyAnn(id = 1)
public class EnumTest {

    int n;

    public static void main(String[] args) {
        MyEnum e = MyEnum.ONE;
        MyEnum three = MyEnum.valueOf("THREE");
        MyEnum value = MyEnum.values()[1];
        System.out.println(value);
    }
}
