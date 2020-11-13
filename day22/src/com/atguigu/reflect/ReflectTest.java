package com.atguigu.reflect;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.lang.annotation.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

/**
 * @author chenhuiup
 * @create 2020-07-22 下午 2:04
 */
/*
反射：通过另一种动态手段做之前做的事情，比如创建对象，访问属性，调用方法
 */
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.LOCAL_VARIABLE})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation {
    int id() default 100;

    String value() default "abc";
}

@MyAnnotation(id = 200, value = "一个字符串")
class Teacher extends HashMap implements Serializable, Comparable, Runnable {

    public static String school = "Atguigu";

    public static void test() {
        System.out.println("static test()...");
    }

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

    @MyAnnotation(id = 300)
    private int lesson(String content, int room) {
        System.out.println("老师在[" + room + "]教室上[" + content + "]课");
        //throw new RuntimeException("无端端的异常");
        return 100;
    }

    // Student添加一个私有方法, private void study(String some, double score);
}

public class ReflectTest {
    @Test
    public void test12() throws ClassNotFoundException, NoSuchMethodException {
        Class clazz = Class.forName("com.atguigu.reflect.Teacher");
        Annotation annotation = clazz.getAnnotation(MyAnnotation.class);
        System.out.println(annotation);

        Method lesson = clazz.getDeclaredMethod("lesson", String.class, int.class);
        MyAnnotation annotation1 = lesson.getAnnotation(MyAnnotation.class);
        System.out.println(annotation1);
    }

    @Test
    public void test11(){
        try {
            Class clazz = Class.forName("com.atguigu.reflect.Teacher");
            Field school = clazz.getField("school");
            Object object = school.get(null);
            System.out.println(object);

            //静态方法
            Method test = clazz.getMethod("test");
            test.invoke(null); // 参数中的对象是什么都无所谓, 因为会在执行时忽略它

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test10() {
        try {
            Class clazz = Class.forName("com.atguigu.reflect.Teacher");
            Object object = clazz.newInstance();
            //((Teacher)object).lesson("JavaSE", 202);
            Method size = clazz.getMethod("size");
            Object invoke = size.invoke(object);
            System.out.println("size : " + invoke);

            //Method lessonMethod = clazz.getMethod("lesson", String.class, int.class);// 第1个参数是方法名, 后面是方法需要的参数类型列表
            Method lessonMethod = clazz.getDeclaredMethod("lesson", String.class, int.class);// 第1个参数是方法名, 后面是方法需要的参数类型列表
            lessonMethod.setAccessible(true);
            // 2) 方法再和this对象配合
            Object retValue = lessonMethod.invoke(object, "JavaSE", 202);
            System.out.println("返回值:" + retValue);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {// 还没有访问权限时, 访问成员
            e.printStackTrace();
        } catch (NoSuchMethodException e) {// 未找到方法异常, 方法名错误, 或 参数类型错误
            e.printStackTrace();
        } catch (InvocationTargetException e) {// 调用的目标方法真的出现异常时, 捕获这个异常.
            e.printStackTrace();
        }
    }

    @Test
    public void test9() {
        try {
            Class clazz = Class.forName("com.atguigu.reflect.Teacher");
            //Object obj = clazz.newInstance();
            //public Teacher(String name, int age, String gender) {
            // 1) 获取到构造器对象
            // 构造方法的形参的类型(每个类型都用相应的Class对象来描述)列表
            Constructor constructor = clazz.getConstructor(String.class, int.class, String.class);
            // 2) 通过构造器对象的方法来创建实例, 实参列表必须要和方法的形参列表完全一致
            // 实际调用构造方法时的实参列表, new Teacher("芳芳", 20, "女");
            Object object = constructor.newInstance("芳芳", 20, "女");
            System.out.println(object);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {// 调用的目标方法真的出现异常时, 捕获这个异常.
            e.printStackTrace();
        }
    }

    @Test
    public void test8() {

        //最普通的就是系统类加载器, 也称为应用程序类加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);//sun.misc.Launcher$AppClassLoader@18b4aac2

        // 扩展类加载器, 它不是核心, 它负责加载的类是 jdk/jre/lib/ext目录下的所有.jar文件
        ClassLoader extentionClassLoader = systemClassLoader.getParent();
        System.out.println(extentionClassLoader);//sun.misc.Launcher$ExtClassLoader@452b3a41

        // 类加载器3个层次, 最底层的是BootstrapClassLoader 引导类加载器, 是最核心的.
        // 因为它负责加载的类是 jdk/jre/lib下的所有.jar文件.
        ClassLoader bootstrapClassLoader = extentionClassLoader.getParent();
        System.out.println(bootstrapClassLoader);//null

        // 双亲委派机制.
        /*
        当加载类时, 首先会让系统类加载器尝试加载, 它不敢, 把任务委派给扩展类加载器, 扩展类加载器仍然要继续委派给引导类加载器
        如果要加载类不是核心类, 请求被驳回, 驳回给扩展类加载器, 扩展类加载器检查, 如果不归它加载, 继续驳回给系统类加载器
        系统类加载器再加载类. 但是如果加载的类是核心类, 委派后引导类加载器会当仁不让.
        这样的结果就是不同层次的类,由不同层次的类加载器来加载*/

        //只要是项目能使用的类或文件，都可以通过系统类加载器的getResourceAsStream()来获取输入流，用途更宽！
        //1.通过系统类加载器ClassLoader的getResourceAsStream()来获取输入流InputStream()
//        InputStream is = systemClassLoader.getResourceAsStream("com/sun/corba/se/impl/logging/LogStrings.properties");
        InputStream is = this.getClass().getClassLoader().getResourceAsStream("com/sun/corba/se/impl/logging/LogStrings.properties");
        //2.通过Hashtable下的子类的load方法读入文件
        Properties properties = new Properties();
        try {
            properties.load(is);

            Iterator<Map.Entry<Object, Object>> iterator = properties.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<Object, Object> next = iterator.next();
                System.out.println(next);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void test7() {
//        try {
        Class<Integer> clazz1 = Integer.class;//clazz1代表Integer类型.
        Class<Integer> clazz2 = int.class;//// 基本数据类型的 类模板 只能通过基本类型.class获取
        // 基本数据类型的类型模板, 只能做一个事情 , 就是标识一下此类型.
        System.out.println(clazz1 == clazz2);//false

        boolean primitive = clazz2.isPrimitive(); // 判断clazz2代表的类型是否是基本类型.
        System.out.println(primitive);//true
//            Integer integer = clazz2.newInstance();
        System.out.println(boolean.class);//boolean
//        } catch (InstantiationException e) {
//            System.out.println("我是基本数据类型，不能创建实例");
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }
    }

    @Test
    public void test6() throws ClassNotFoundException {

        // 获取类模板对象的方法
        // 1) 已知类, 并且类已经提供好的情况下, 通过类的静态属性class直接获取, 效率最好, 最简单.
        Class<Teacher> clazz1 = Teacher.class;

        //// 2) 根据对象进一步获取对象所属的类模板
        Teacher teacher = new Teacher();
        Class<? extends Teacher> clazz2 = teacher.getClass();
        //// 3) 根据类的全限定名称, 动态手工加载类
        Class<?> clazz3 = Class.forName("com.atguigu.reflect.Teacher");
        // 4) 通过类加载器对象来手工加载类
        Class<?> clazz4 = this.getClass().getClassLoader().loadClass("com.atguigu.reflect.Teacher");
        System.out.println(clazz1 == clazz2 && clazz3 == clazz4);//true
    }

    @Test
    public void test5() {

        try {
            Class clazz = Class.forName("com.atguigu.reflect.Teacher");
            String name = clazz.getName();
            System.out.println(name);

            Class superclass = clazz.getSuperclass();//获取父类的类模板
            System.out.println(superclass);

            Class[] interfaces = clazz.getInterfaces();//获取本类实现的接口列表
            for (Class i : interfaces) {
                System.out.println(i);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }


    @Test
    public void test4() {
        try {
            Class clazz = Class.forName("com.atguigu.reflect.Teacher");
            Object object = clazz.newInstance();
            // getField只能获取本类或父类继承的公共属性.
            //Field nameField = clazz.getField("name");
            // getDeclaredField可以获取本类中所有声明的属性, 包括私有的.
            Field nameField = clazz.getDeclaredField("name");
            nameField.setAccessible(true);//突破封装，暴力反射
            System.out.println(nameField);
            nameField.set(object, "华为");
            System.out.println(nameField.get(object));

            Field age = clazz.getDeclaredField("age");
            age.setAccessible(true);
            age.set(object, 30);

            Field genderField = clazz.getDeclaredField("gender");
            genderField.setAccessible(true);
            genderField.set(object, "男");

            System.out.println(object);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {// 非法访问.
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3() {
        try {
            //手工加载类模板, 类的全限定名称必须是 所有包名.类名
            Class clazz = Class.forName("com.atguigu.reflect.Teacher");
            Object object = clazz.newInstance();////直接由类模板创建对象，需要无参构造器
            System.out.println(object);

            //先找到name属性定义, 再配合object对象
            Field name = clazz.getField("name");
            //给属性赋值，使用set方法
            name.set(object, "张三");
            //获取属性值, 使用get方法
            System.out.println(name.get(object));//System.out.println(object.name);
            Field age2 = clazz.getField("age2");
            age2.set(object, 30); // object.age = 30
            System.out.println(age2.get(object));

            Field genderField = clazz.getField("gender");
            genderField.set(object, "男");

            System.out.println(object);

        } catch (ClassNotFoundException e) {// 提供的类名错误, 或 类不存在.
            e.printStackTrace();
        } catch (InstantiationException e) {// 没有对访问的成员有访问权限.
            e.printStackTrace();
        } catch (IllegalAccessException e) { // 实例化失败, 可能由于构造器没有提供.
            e.printStackTrace();
        } catch (NoSuchFieldException e) {// 属性名错误 或 属性不存在.
            e.printStackTrace();
        }
    }

    @Test
    public void test2() {
        try {
            // 手工加载类模板, 类的全限定名称必须是 所有包名.类名
            Class clazz = Class.forName("com.atguigu.reflect.Teacher");
            Object object = clazz.newInstance();//直接由类模板创建对象，需要无参构造器
            System.out.println(object);
        } catch (ClassNotFoundException e) {//提供的类名错误，或类不存在
            e.printStackTrace();
        } catch (IllegalAccessException e) {//没有对访问的成员有访问权限,构造器可以私有化，或者其他低权限
            e.printStackTrace();
        } catch (InstantiationException e) {//实例化失败，可能由于构造器没有提供
            e.printStackTrace();
        }

    }

}
