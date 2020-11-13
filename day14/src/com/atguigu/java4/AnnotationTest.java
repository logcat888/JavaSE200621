package com.atguigu.java4;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 注解 : 是一种特殊的注释, 特殊在于可以被编译器, VM识别. 本质上是一个修饰符, 注解都不能修饰语句.
 * @Override 作用是提醒编译器, 它修饰的方法是一个覆盖方法, 请帮助我们作检查 , 方法覆盖条件的检查.
 *           只可以修饰方法.
 *
 * @Deprecated 作用是提醒编译器,提醒使用者 它修饰的目标不推荐使用
 *             它可以
 *             修饰类(TYPE), 属性(FIELD), 构造器(CONSTRUCTOR), 方法(METHOD),
 *             局部变量(LOCAL_VARIABLE), 参数(PARAMETER)
 *
 * @SuppressWarnings 抑制编译器警告, 在使用时必须传参, 说明它内部有属性.
 *
 * 元注解 : 注解的注解, 约束注解的使用的注解.
 * @Target 作用是约束注解可以修饰的目标.可以用在什么位置, 默认情况是它可以修饰任意目标
 *          ElementType.TYPE 类型(类类型,接口类型)
 *          ElementType.FIELD 属性
 *          ElementType.METHOD 方法
 *          ElementType.CONSTRUCTOR 构造器
 *          ElementType.PARAMETER 参数
 *
 * @Retention 作用是约束注解可以停留在什么时期, 是只在源文件中呢, 还是在类文件中, 还是都在且运行时能获取.
 */

// 自定义注解, 可以修饰任意目标. 这是一个标记型注解
//@interface MyAnnotation {}

// 自定义注解, 可以修饰任意目标. 这是一个有参数的注解, 默认可以修饰任意目标
/*
@interface MyAnnotation {
    int id() default 200; // 属性可以有缺省值.
    String name() default "缺省值";
}*/

/*
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.PARAMETER}) // 自定义注解只可以修饰类和属性. 其他都不行了.默认情况下此注解停留在类文件中
@interface MyAnnotation {
    int id() default 200;
    String name() default "缺省值";
}
*/



@Target({ElementType.TYPE, ElementType.FIELD, ElementType.PARAMETER}) // 自定义注解只可以修饰类和属性. 其他都不行了.
@Retention(RetentionPolicy.RUNTIME) // MyAnnotation注解就可以在运行时通过反射获取并处理了..
@interface MyAnnotation {
    int id() default 200;
    String name() default "缺省值";
}

//@Override
@Deprecated
@MyAnnotation(id = 1, name="abc")
class Person {

    //@Override
    private String name;
    @Deprecated
    @MyAnnotation(name="yyy", id = 2) private int age;
    private String gender;

    @Deprecated
    /*@MyAnnotation(name="zzz")*/ public Person() {
    }

    //@Override
    // <init>()
    public Person(@Deprecated String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    @Deprecated
    @SuppressWarnings({"unused", "null"})
    /*@MyAnnotation(name="zzz")*/ public String getName() {
        @Deprecated int n;
        double d;
        //System.out.println(n);
        /*@MyAnnotation*/ int[] arr = null;
        System.out.println(arr.length);
        return name;
    }

    /*@MyAnnotation*/ public void setName(@MyAnnotation String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }


    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override /*@MyAnnotation*/ public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}

public class AnnotationTest {

    public static void main(String[] args) {
        new Person("张三", 30, "男");
    }

}
