package com.atguigu.myexer1;

import java.io.StringReader;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 *
 * // 练习 : 写一个注解HelloAnnotation, 包含属性int count, String value. count属性有缺省值
 * // 再写一个普通类, Person, 有属性id, name, age; 在Person类中的各个位置测试注解的使用.
 *
 * // 把刚才的注解处理一下, 让它只能修饰方法和构造器. 并且也可以反射处理.
 * @author chenhuiup
 * @create 2020-07-11 下午 2:35
 */
//@Target({ElementType.FIELD,ElementType.ANNOTATION_TYPE,})
@HelloAnnotation("您好")
public class Person {
  @HelloAnnotation(count = 7, value = "zhangsan") private int id;
   @Deprecated private String name;
   private int age;

    public Person() {
    }

    public Person(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

@interface HelloAnnotation{
    public abstract int count () default 5;
    String value();

    public static final int number = 5;
}