package com.atguigu.myerxer1;

import org.junit.Test;
import org.junit.runners.Parameterized;

import java.io.Serializable;
import java.lang.reflect.*;
import java.util.HashMap;

/**
 * @author chenhuiup
 * @create 2020-07-22 上午 10:12
 */
public class exer1 {
    @Test
    public void test2() {
        try {
            Class clazz = Class.forName("com.atguigu.myerxer1.Teacher");
            Constructor constructor = clazz.getConstructor(String.class, int.class, String.class);
            Object object = constructor.newInstance("张三", 26, "男");
            System.out.println(object);

            //通过反射获取方法
            Method lesson = clazz.getDeclaredMethod("lesson", String.class, int.class);
            lesson.setAccessible(true);
            lesson.invoke(object,"JavaSE",202);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {//实例化异常，创建对象失败，可能没有相应的构造器
            e.printStackTrace();
        } catch (InvocationTargetException e) {//调用方法时，方法内抛出的异常
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {//非法访问权限，可能是权限不够
            e.printStackTrace();
        }

    }

    @Test
    public void test1() {
        try {
            Class clazz = Class.forName("com.atguigu.myerxer1.Student");
            Object object = clazz.newInstance();
            System.out.println(object);
            Constructor cons = clazz.getDeclaredConstructor(String.class);
            cons.setAccessible(true);
            Object object1 = cons.newInstance("张三");
            System.out.println(object1.toString());
            Field weight = clazz.getField("weight");
            weight.set(object1, 110);
            System.out.println(weight.get(object1));
            System.out.println(object1);
            Field age = clazz.getDeclaredField("age");
            age.setAccessible(true);
            age.set(object1, 20);
            System.out.println(age.get(object1));
            System.out.println("***********************");

            //getDeclaredMethods():获取本类中声明的所有方法
            Method[] declaredMethods = clazz.getDeclaredMethods();
            for (Method m : declaredMethods) {
                //获取权限修饰符
                int modifiers = m.getModifiers();
                String string = Modifier.toString(modifiers);
                System.out.print(string + "\t");

                //获取返回值类型
                Class returnType = m.getReturnType();
//                System.out.print(returnType);//class java.lang.String
                if (returnType.getName() == "java.lang.String") {
                    System.out.print("String" + "\t");
                } else {
                    System.out.print(returnType.getName() + "\t");

                }


                System.out.println();

            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {//属性名错误 或 属性不存在
            e.printStackTrace();
        }
    }

}

class Student {
    private String name;
    public double weight;
    int age;

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", age=" + age +
                '}';
    }

    public Student(String name, double weight, int age) {
        this.name = name;
        this.weight = weight;
        this.age = age;
    }

    private Student(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
class Teacher extends HashMap implements Serializable, Comparable, Runnable {

    private String name;
    private int age;
    private String gender;

    public Teacher() {

    }

    public Teacher(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    @Override
    public void run() {

    }

    private void lesson(String content,int room){
        System.out.println("我在" + room + "教室较" + content);
        throw new RuntimeException("我是一个小异常");
    }
}