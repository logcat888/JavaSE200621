package com.atguigu.java2;

import com.atguigu.java1.Person;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author chenhuiup
 * @create 2020-07-22 下午 11:10
 *
 * 调用运行时类中指定的结构：属性、方法、构造器
 */
public class ReflectionTest {

    /*
    不需要掌握，对属性的要求过高
     */
    @Test
    public void testField() {
        Class clazz = Person.class;

        try {
            //创建运行时类的对象
            Person person = (Person) clazz.newInstance();
            //获取指定的属性：要求运行时类中属性声明为public
            //通常不采用此方法
            Field id = clazz.getField("id");

            /*
            设置当前属性的值
            set():参数1：指明设置哪个对象的属性  参数2：将此属性值设置为多少
             */
            id.set(person, 10001);

            /*
            获取当前属性的值
            get():参数1：获取哪个对象的当前属性值
             */
            Object object = id.get(person);

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

    }

    /*
    如何操作运行时类中的指定的属性---需要掌握
     */
    @Test
    public void testField1() {
        Class clazz = Person.class;

        try {
            //创建运行时类的对象
            Person person = (Person) clazz.newInstance();

            //1.getDeclaredField(String fileName):获取运行时类中指定变量名的属性
            Field name = clazz.getDeclaredField("name");

            //2.保证当前属性是可访问的
            name.setAccessible(true);
            //3.获取、设置指定对象的此属性值
            name.set(person, "Tom");

            System.out.println(name.get(person));

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

    }

    /*
    如何操作运行时类中的指定的方法----需要掌握
     */
    @Test
    public void testMethod() {
        Class clazz = Person.class;

        try {
            //创建运行时类的对象
            Person person = (Person) clazz.newInstance();

            /*
            1.获取指定的某个方法
            getDeclaredMethod()：参数1：指明获取的方法的名称  参数2：指明获取的方法的形参列表
             */
            Method show = clazz.getDeclaredMethod("show", String.class);
            //2.保证当前方法是可访问的
            show.setAccessible(true);
            /*
            3.invoke():参数1：方法的调用者  参数2：给方法形参赋值的实参
            invoke()的返回值即为对应类中调用的方法的返回值。
             */
            Object chn = show.invoke(person, "CHN");//String nation = person.show()
            System.out.println(chn);

            System.out.println("***************调用静态方法*****************");

            //private static void showDesc()

            Method showDesc = clazz.getDeclaredMethod("showDesc");
            showDesc.setAccessible(true);
            //如果调用的运行时类中的方法没有返回值，则此invoke()返回null.
            Object invoke = showDesc.invoke(null);//null
            System.out.println(invoke);//null

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
    /*
    如何操作运行时类中的指定的构造器
     */
    @Test
    public void testConstructor(){
        Class clazz = Person.class;

        //private Person(String name)
        /*
        1.获取指定的构造器
        getDeclaredConstructor():参数：指明构造器的参数列表
         */

        try {
            Constructor declaredConstructor = clazz.getDeclaredConstructor(String.class);

            //2.保证此构造器是可访问的
            declaredConstructor.setAccessible(true);

            //3.调用此构造器创建运行时类的对象
            Object object = declaredConstructor.newInstance("Tom");
            System.out.println(object);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}