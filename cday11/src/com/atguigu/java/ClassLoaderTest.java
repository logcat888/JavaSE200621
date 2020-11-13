package com.atguigu.java;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 了解类的加载器
 *
 * @author chenhuiup
 * @create 2020-07-21 下午 9:08
 */
public class ClassLoaderTest {

    @Test
    public void test1() {
        //对于自定义类，使用系统类加载器进行加载
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader);//sun.misc.Launcher$AppClassLoader@18b4aac2

        //调用协同类加载器的getParent():获取扩展类加载器
        ClassLoader classLoader1 = classLoader.getParent();
        System.out.println(classLoader1);//sun.misc.Launcher$ExtClassLoader@452b3a41
        //调用扩展类加载器的getParent()：无法获取引导类加载器
        //引导类加载器主要负责加载java的核心类库，无法加载自定义类的。
        ClassLoader classLoader2 = classLoader1.getParent();
        System.out.println(classLoader2);//null

        ClassLoader classLoader3 = String.class.getClassLoader();
        System.out.println(classLoader3);//null

    }

    /*
     Properties:用来读取配置文件。
     */
    @Test
    public void test2() throws Exception {

        Properties pros = new Properties();
        //此时的文件默认在当前的module下。
        //读取配置文件的方式一：
        FileInputStream fis = new FileInputStream("jdbc.properties");
        pros.load(fis);

        //读取配置文件的方式二：使用ClassLoader
        //配置文件默认识别为：当前module的src下
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("jdbc1.properties");
        pros.load(is);

        String user = pros.getProperty("User");
        String password = pros.getProperty("Password");
        System.out.println("User = " + user + ", Password = " + password);
    }
}
