package com.atguigu.java;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * @author chenhuiup
 * @create 2020-07-15 下午 7:17
 */
public class PropertiesTest {

    //Properties:常用来处理配置文件。key和value都是String类型
    public static void main(String[] args) throws IOException {
        FileInputStream fis = null;
        try {
            Properties properties = new Properties();
            fis = new FileInputStream("jdbc.properties");
            properties.load(fis);//加载流对应的文件

            String name = properties.getProperty("name");
            String password = properties.getProperty("password");

            System.out.println("name = " + name + ",password = " + password);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null){
                try{
                    fis.close();
                }catch (IOException e){
                    e.printStackTrace();

                }
            }
        }

    }
}
