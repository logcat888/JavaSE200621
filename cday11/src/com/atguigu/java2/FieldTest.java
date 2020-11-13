package com.atguigu.java2;

import com.atguigu.java1.Person;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * 获取当前运行时类的属性结构
 *
 * @author chenhuiup
 * @create 2020-07-21 下午 10:51
 */
public class FieldTest {

    @Test
    public void test1() {

        Class<Person> clazz = Person.class;

        //获取属性结构
        //getFields():获取当前运行时类及其父类中声明为public访问权限的属性
        Field[] fields = clazz.getFields();
        for (Field f : fields) {
            System.out.println(f);
        }
        System.out.println();

        //getDeclaredFields():获取当前运行是类中声明的所有属性。（不包含父类中声明的属性）
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field f : declaredFields) {
            System.out.println(f);
        }

    }

    //权限修饰符，数据类型，变量名 = 。。。
    @Test
    public void test2() {
        Class clazz = Person.class;
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field f : declaredFields) {
            //1.权限修饰符
            int modifiers = f.getModifiers();
            System.out.println(modifiers);//2 0 1
            System.out.println(Modifier.toString(modifiers));//private(2)    (0)  public(1)

            //2.数据类型
            Class type = f.getType();
            System.out.println(type.getName() + "\t");

            //3.变量名
            String fName = f.getName();
            System.out.println(fName);

            System.out.println();

        }
    }
}
