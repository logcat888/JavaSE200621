package com.atguigu.java2;

import com.atguigu.java1.Person;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author chenhuiup
 * @create 2020-07-22 上午 7:35
 */
public class OtherTest {

    /*
    获取构造器结构
     */

    @Test
    public void test1() {
        Class clazz = Person.class;
        //getConstructors():获取当前运行时类中声明为public的构造器
        Constructor[] constructors = clazz.getConstructors();
        for (Constructor c : constructors) {
            System.out.println(c);
        }
        System.out.println();

        //getDeclaredConstructors():获取当前运行类中声明的所有的构造器
        Constructor[] declaredConstructors = clazz.getDeclaredConstructors();
        for (Constructor c : declaredConstructors) {
            System.out.println(c);
        }
    }

    /*
    获取运行时类的父类
     */
    @Test
    public void test2() {
        Class clazz = Person.class;
        Class superClass = clazz.getClass();

        System.out.println(superClass);

    }

    /*
    获取运行时类的带泛型的父类
     */
    @Test
    public void test3() {
        Class clazz = Person.class;
        Type genericSuperclass = clazz.getGenericSuperclass();
        System.out.println(genericSuperclass);

    }

    /*
    获取运行时类的带泛型的父类的泛型

    代码: 逻辑性代码 vs 功能性代码
    */
    @Test
    public void test4() {
        Class clazz = Person.class;
        Type genericSuperclass = clazz.getGenericSuperclass();
        ParameterizedType paraTyper = (ParameterizedType) genericSuperclass;
        //获取泛型类型
        Type[] actualTypeArguments = paraTyper.getActualTypeArguments();
        System.out.println(actualTypeArguments[0]);//class java.lang.String
        System.out.println(actualTypeArguments[0].getTypeName());//java.lang.String
        //将泛型参数强转为类
        System.out.println(((Class)actualTypeArguments[0]).getName());//java.lang.String
    }

    /*
    获取运行时类实现的接口
     */
    @Test
    public void test5() {
        Class clazz = Person.class;
        Class[] interfaces = clazz.getInterfaces();
        for (Class c : interfaces) {
            System.out.println(c);
        }

        System.out.println();

        //获取运行时类的父类实现的接口
        Class[] interfaces1 = clazz.getClass().getInterfaces();
        for (Class c : interfaces) {
            System.out.println(c);
        }
    }

    /*
    获取运行时类所在的包
     */
    @Test
    public void test6() {
        Class clazz = Person.class;
        Package pack = clazz.getPackage();
        System.out.println(pack);//package com.atguigu.java1
    }

    /*
    获取运行时类声明的注解
     */
    @Test
    public void test7() {
        Class clazz = Person.class;
        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation a : annotations) {
            System.out.println(a);
        }
        System.out.println(annotations);//@com.atguigu.java1.MyAnnotation(value=hi)
    }
}