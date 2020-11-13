package com.atguigu.java;

import org.junit.Test;

import java.io.FileReader;
import java.io.IOException;

/**
 * IO : 数据从一个节点流向另一个节点.
 *
 *              字节          字符
 * 输入       InputStream     Reader
 * 输出       OutputStream    Writer
 *
 * 读写文件步骤 :
 * 1) 创建流对象, 建立通道
 * 2) 通过使用流对象的方法完成数据的处理
 * 3) 关闭流对象.
 *
 */
public class IOTest {

    @Test
    public void test3() {
        // 1) 声明引用, 并赋值为null;
        FileReader fileReader = null;
        // 2) try catch finally
        try {
            // 5) 创建 流对象
            fileReader = new FileReader("一个文件");
            // 6) 使用流对象处理数据
            int ch;
            while ((ch = fileReader.read()) != -1) {
                System.out.print((char)ch);
            }
        } catch (Exception e) {
            // 4) 在catch中处理异常
            e.printStackTrace();
        } finally {
            // 3) 在finally中关闭流
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @Test
    public void test2() {
        FileReader fileReader = null;
        try {
            // 1) 创建流对象, 建立通道
            fileReader = new FileReader("一个文件"); // 在当前目录下找这个文件
            // 2) 通过使用流对象的方法完成数据的处理
            int ch;
            while ((ch = fileReader.read()) != -1) {
                System.out.print((char) ch);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 3) 关闭流对象.
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test1() throws IOException {
        // 读文本文件

        // 1) 创建流对象, 建立通道
        FileReader fileReader = new FileReader("一个文件"); // 在当前目录下找这个文件
        // 2) 通过使用流对象的方法完成数据的处理
        int ch;
        while ((ch = fileReader.read()) != -1) {
            System.out.print((char) ch);
        }
        // 3) 关闭流对象.
        fileReader.close();

    }
}
