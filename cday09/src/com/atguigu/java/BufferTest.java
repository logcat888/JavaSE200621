package com.atguigu.java;

import org.junit.Test;

import java.io.*;

/**
 * 处理流之一：缓冲流的使用
 *
 * 1.缓冲流：
 * BufferedInputStream
 * BufferedOutputStream
 * BufferedReader
 * BufferedWriter
 *
 * 2.作用：提升流的读取、写入的速度
 *      提高读写速度的原因：内部提供了一个缓冲区：8kb(1024 << 3)
 *
 * 3.处理流，就是“套接”在已有的流的基础上。
 *
 * @author chenhuiup
 * @create 2020-07-17 下午 7:30
 */
public class BufferTest {
    /*
    实现非文本文件的复制
     */
    @Test
    public void BufferedStream() {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            //1.造文件
            File srcfile = new File("集合习题2.jpg");
            File destfile = new File("集合习题3.jpg");
            //2.造流
            //2.1造节点流
            fis = new FileInputStream(srcfile);
            fos = new FileOutputStream(destfile);
            //2.2造处理流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);
            //3.复制的细节：读取、写入
            byte[] buff = new byte[10];
            int len;
            while ((len = bis.read(buff)) != -1) {
                bos.write(buff, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.关闭资源
            //要求：先关闭外层的流，再关闭内层的流
            if (bos != null) {

                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bis != bis) {

                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            //说明：关闭外层流的同时，内层流也会自动的进行关闭，关于内层流的关闭，我们可以省略。
//            fis.close();
//            fos.close();

        }

    }

    //实现文件复制的方法

    public void copyFileWithBuffer(String srcPath, String destPath) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            //1.造文件
            File srcfile = new File(srcPath);
            File destfile = new File(destPath);
            //2.造流
            //2.1造节点流
            fis = new FileInputStream(srcfile);
            fos = new FileOutputStream(destfile);
            //2.2造处理流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);
            //3.复制的细节：读取、写入
            byte[] buff = new byte[1024];
            int len;
            while ((len = bis.read(buff)) != -1) {
                bos.write(buff, 0, len);

//                bos.flush();//刷新缓冲区
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.关闭资源
            //要求：先关闭外层的流，再关闭内层的流
            if (bos != null) {

                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bis != bis) {

                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            //说明：关闭外层流的同时，内层流也会自动的进行关闭，关于内层流的关闭，我们可以省略。
//            fis.close();
//            fos.close();
        }
    }

    @Test
    public void testCopyFile(){
        long start = System.currentTimeMillis();

        String srcFile = "C:\\Users\\Administrator\\Desktop\\二叉树.mp4";
        String destFile = "C:\\Users\\Administrator\\Desktop\\二叉树1.mp4";
        copyFileWithBuffer(srcFile, destFile);

        long end = System.currentTimeMillis();
        System.out.println(end - start);//958 -- 295
    }

    /*
    使用BufferedReader和BufferedWriter实现文本文件的复制
     */
    @Test
    public void testBufferedReaderBufferedWriter()  {
        //创建文件和相应的流
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new FileReader(new File("dbcp.txt")));
            bw = new BufferedWriter(new FileWriter(new File("dbcp1.txt")));

            //读写操作
            //方式一：使用char[]数组
//            char[] cbuf = new char[1024];
//            int len;
//            while((len = br.read(cbuf)) != -1){
//                bw.write(cbuf,0,len);
//                bw.flush();
//        }

        //方式二：使用String
        String data;
        while((data = br.readLine()) != null){
            //方法一：
//            bw.write(data + "\n");//data中不包含换行符

            //方法二：
            bw.write(data);//data中不包含换行符
            bw.newLine();//提供换行的操作
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            if (br != null){

                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bw != null){

                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
