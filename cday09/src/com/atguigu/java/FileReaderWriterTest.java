package com.atguigu.java;

import org.junit.Test;

import java.io.*;

/**
 * 一、流的分类
 * 1.操作数据单位：字节流、字符流
 * 2.数据的流向：输入流、输出流
 * 3.流的角色：节点流、处理流
 * <p>
 * 二、流的体系结构
 * 抽象基类                 节点流（或文件流）                                   缓冲流（处理流的一种）
 * InputStream              FileInputStream(read(byte[] cbuf))                 BufferedInputStream(read(byte[] cbuf))
 * OutputStream             FileOutputStream (write(byte[] cbuf,0,len))        BufferedOutputStream(write(byte[] cbuf,0,len))  /flush()
 * Reader                   FileReader(read(char[] cbuf))                      BufferedReader(read(char[] cbuf)/readLine())
 * Writer                   FileWriter(write(char[] cbuf,0,len))               BufferedWriter(write(char[] cbuf,0,len)) /flush() /newLine()
 *
 * @author chenhuiup
 * @create 2020-07-16 下午 9:36
 */
public class FileReaderWriterTest {

    public static void main(String[] args) {
        File file = new File("hello.txt");//相较于当前project
        System.out.println(file.getAbsoluteFile());//D:\workspace_idea\JavaSE200621\hello.txt

        File file1 = new File("cday09\\hello.txt");
        System.out.println(file1.getAbsoluteFile());//D:\workspace_idea\JavaSE200621\cday09\hello.txt
    }

    /*
    将cday09下的hello.txt文件内容读入程序中，并输出到控制台

    说明点：
    1. read()的理解：返回读入的一个字符。如果达到文件末尾，返回-1.
    2. 异常的处理：为了保证流资源一定可以执行关闭操作，需要使用try-catch-finally处理
    3. 读入的文件一定要存在，否则就会报FileNotFoundException.

     */
    @Test
    public void testFileReader() {
        FileReader fr = null;
        try {
            //1.实例化File类的对象，指明要操作的文件
            File file = new File("hello.txt");//相较于当前module
            System.out.println(file.getAbsoluteFile());//D:\workspace_idea\JavaSE200621\cday09\hello.txt
            //2.提供具体的流
            fr = new FileReader(file);//字符输入流（字节）可能出现文件找不到异常（FileNotFoundException），导致fr为null

            //3.数据的读入
            //read():返回读入的一个字符，如果达到文件末尾，返回-1
            //方式一：
//        int data = fr.read();
//        while (data != -1){
//            System.out.print((char) data);
//            data = fr.read();
//        }

            //方式二：语法上针对于方式一的修改
            int data;
            while ((data = fr.read()) != -1) {
                System.out.println((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
//            try {
//                //4.流的关闭操作
//                if (fr != null)//避免出现空指针异常
//                    fr.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }

            //或
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }

    }

    //对read()操作升级，使用read的重载方法
    @Test
    public void testFileReader1() {
        FileReader fr = null;
        try {
            //1.File类的实例化
            File file = new File("hello.txt");
            //2.FileReader流的实例化
            fr = new FileReader(file);

            //3.读入的操作
            //read(char[] cbuf):返回每次读入cbuf数组中的字符的个数。如果达到文件末尾，返回-1.
            char[] cbuf = new char[5];
            int len;
            while ((len = fr.read(cbuf)) != -1) {
                //方式一：
                //错误的写法
//                for (int i = 0; i < cbuf.length; i++) {
//                    System.out.println(cbuf[i]);
//                }
                //正确的写法
                for (int i = 0; i < len; i++) {
                    System.out.println(cbuf[i]);
                }

                //方式二：
                //错误的写法，对应着方式一的错误的写法
//                String str = new String(cbuf);
//                System.out.println(str);
                //正确的写法
                String str = new String(cbuf, 0, len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fr != null) {
                try {
                    //4.资源的关闭
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /*
    从内存中写出数据到硬盘的文件里

    说明：
    1.输出操作，对应的File可以不存在，并不会报异常
    2.File对应的硬盘中的文件如果不存在，在输出的过程中，会自动创建此文件。
        File对应的硬盘中的文件如果存在：
            如果流使用的构造器是：FileWriter(file,false) / FileWriter(file):对原有文件进行覆盖操作
            如果流使用的构造器是：FileWriter(file,true):不会对原有文件覆盖，而是在原有文件上追加内容
     */
    @Test
    public void testFileWrite() {
        FileWriter fw = null;
        try {
            //1.提供File类的对象，指明写出到的文件
            File file = new File("hello1.txt");
            //2.提供FileWriter的对象，用于数据的写出
            fw = new FileWriter(file, true);
            //3.写出的操作
            fw.write("I have a dream\n");
            fw.write("you need to hava a dream\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fw != null)

                try {
                    //资源关闭
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                }
        }

    }

    @Test
    public void testFileReaderFileWriter() {
        FileReader fileReader = null;
        FileWriter fileWriter = null;
        try {
            //1.创建File类的对象，指明读入和写出的文件
            File srcFile = new File("hello.txt");
            File destFile = new File("hello2.txt");

            //不能使用字符流来处理图片等字节数据
//            File srcFile = new File("集合习题.jpg");
//            File destFile = new File("集合习题1.jpg");

            //2.创建输入流和输出流的对象
            fileReader = new FileReader(srcFile);
            fileWriter = new FileWriter(destFile);

            //3.数据的读入和写出操作
            char[] cbuf = new char[5];
            int len;//记录每次读入到cbuf数组中的字符个数
            while ((len = fileReader.read(cbuf)) != -1) {
                //每次写出len个字符
                fileWriter.write(cbuf, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.关闭流资源
            //方式一
//            try {
//                if (fileReader != null)
//                    fileReader.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            } finally {
//                try {
//                    if (fileWriter != null)
//                        fileWriter.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }

            //方式二

            try {
                if (fileReader != null)
                    fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fileWriter != null)
                    fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }


//            if (fileReader != null)
//                try {
//                    fileReader.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//
//            if (fileWriter != null)
//                try {
//                    fileWriter.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
        }
    }


    @Test
    public void testFileInputStreamFileOutputStream() {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            //1.创建File类的对象，指明读入和写出的文件
            File srcFile = new File("集合习题.jpg");
            File destFile = new File("集合习题1.jpg");

            //2.创建输入流和输出流的对象
            fileInputStream = new FileInputStream(srcFile);
            fileOutputStream = new FileOutputStream(destFile);

            //3.数据的读入和写出操作
            byte[] cbuf = new byte[5];
            int len;//记录每次读入到cbuf数组中的字符个数
            while ((len = fileInputStream.read(cbuf)) != -1) {
                //每次写出len个字符
                fileOutputStream.write(cbuf, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.关闭流资源

            try {
                if (fileInputStream != null)
                    fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fileOutputStream != null)
                    fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
