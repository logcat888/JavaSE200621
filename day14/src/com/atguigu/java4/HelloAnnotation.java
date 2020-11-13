package com.atguigu.java4;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 练习 : 写一个注解HelloAnnotation, 包含属性int count, String value. count属性有缺省值
// 把刚才的注解处理一下, 让它只能修饰方法和构造器. 并且也可以反射处理.
@Target({ElementType.METHOD, ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.RUNTIME)
public @interface HelloAnnotation {

    int count() default 10;
    String value() default "aaa";

}
