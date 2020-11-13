package com.atguigu.java2;

import org.junit.Test;

import java.io.*;

/**
 *              字节          字符
 *  输入        InputStream   Reader
 *  输出 :      OutputStream  Writer
 *
 *  FileInputStream : 二进制文件输入流
 *  FileOutputStream : 二进制文件输出流
 *  FileReader : 文本文件输入流
 *  FileWriter : 文本文件输出流
 *
 *  BufferedReader
 *  BufferedWriter
 *  BufferedInputStream
 *  BufferedOutputStream
 *
 *
 */
public class IOTest {

    @Test
    public void testObjectOutputStream() {
        FileOutputStream fos = null;
        //BufferedOutputStream
    }

    @Test
    public void testBufferedWriter() {
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter("使用缓冲流写文件");
            bufferedWriter = new BufferedWriter(fileWriter);
            String[] content = {"alfjalkdsjflkasdjflkajsdflkjasdf",
                                "我是字符串, 我要写入文件了1",
                                "我是字符串, 我要写入文件了2",
                                "我是字符串, 我要写入文件了3",
                                "我是字符串, 我要写入文件了4",
                                "我是字符串, 我要写入文件了5",
                                "我是字符串, 我要写入文件了6",
                                "我是字符串, 我要写入文件了7",
                                "我是字符串, 我要写入文件了8",
                                "23498234982749827498274982374982374982374982374"};
            for (int i = 0; i < content.length; i++) {
                bufferedWriter.write(content[i]); // 直接写字符串
                bufferedWriter.newLine(); // 是好方法
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void testBufferedReader() {
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader("一个文件");
            // 所谓包装一定是对象关联, 如何关联: 通过构造器
            bufferedReader = new BufferedReader(fileReader);
            String line;
            // readLine是好方法
            while ((line = bufferedReader.readLine()) != null) { // 读取一行字符串.
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test5() {
        // 用数组的方式写文件
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("用数组写的文件");
            String[] content = {"alfjalkdsjflkasdjflkajsdflkjasdf",
                                "我是字符串, 我要写入文件了1",
                                "我是字符串, 我要写入文件了2",
                                "我是字符串, 我要写入文件了3",
                                "我是字符串, 我要写入文件了4",
                                "我是字符串, 我要写入文件了5",
                                "我是字符串, 我要写入文件了6",
                                "我是字符串, 我要写入文件了7",
                                "我是字符串, 我要写入文件了8",
                                "23498234982749827498274982374982374982374982374"};

            for (int i = 0; i < content.length; i++) {
                String string = content[i];
                char[] array = string.toCharArray();

                //fileWriter.write(array); // 批量的把数组中的所有字符写入输出流.
                fileWriter.write(array, 7, array.length - 7); // 第2个参数是数组的开始索引, 第3个参数是从数组中写几个字符

                fileWriter.write('\r');
                fileWriter.write(10);
            }
            // 创建一个字符串数组, 内容是一些同学的姓名, 写入一个文本文件name.txt, 把每位同学的名写入文件
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // 使用缓冲区读文件, 打印文件内容时加上行号
    @Test
    public void test4() {
        int line = 1;
        System.out.print(line++ + " ");
        FileReader fileReader = null;
        try {
            fileReader = new FileReader("一个文件");
            char[] buf = new char[1000];
            int count;
            while ((count = fileReader.read(buf)) != -1) { // 读多个字符到buf数组中, 实际读的个数取决于返回值.
                // 处理已经读的数据, 处理的个数不是数组长度, 而是实际的个数
                for (int i = 0; i < count; i++) {
                    System.out.print(buf[i]);
                    if (buf[i] == 10) {
                        System.out.print(line++ + " ");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
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
    public void test3() {
        FileReader fileReader = null;
        try {
            fileReader = new FileReader("一个文件");
            char[] buf = new char[1000];
            int count;
            while ((count = fileReader.read(buf)) != -1) { // 读多个字符到buf数组中, 实际读的个数取决于返回值.
                // 处理已经读的数据, 处理的个数不是数组长度, 而是实际的个数
                for (int i = 0; i < count; i++) {
                    System.out.print(buf[i]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
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
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("写文本文件");
            fileWriter.write('a');
            fileWriter.write('b');
            fileWriter.write('q');
            fileWriter.write(13);
            fileWriter.write(10);
            fileWriter.write('1');
            fileWriter.write('2');
            fileWriter.write('3');
            fileWriter.write(13);
            fileWriter.write(10);
            fileWriter.write('我');
            fileWriter.write('和');
            fileWriter.write('你');
            fileWriter.write(13);
            fileWriter.write(10);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test1() {
        // 读文本文件

        // 1) 声明引用, 赋值为null;
        FileReader fileReader = null;
        // 2) try catch finally
        try { // ctrl + alt + t
            // 5) 在try中创建对象
            fileReader = new FileReader("一个文件");
            // 6) 在try中处理数据
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

}
