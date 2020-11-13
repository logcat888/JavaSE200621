package com.atguigu.java;

import org.junit.Test;

import java.io.*;

/**
 * 测试FileInputStream 和 FileOutputStream的使用
 *
 * 结论：
 * 1. 对于文本文件(.txt,.java,.c,.cpp)，使用字符流处理
 * 2. 对于非文本文件(.jpg,.map3,.map.avi,.ppt,.doc)，使用字节流处理
 *
 *
 *
 * @author chenhuiup
 * @create 2020-07-17 下午 6:36
 */
public class FileInputOutputStreamTest {


    //使用字节流FileInputStream处理文本文件，可能出现乱码。对于ASC||仍然使用byte（一个字节）存储，而中文字符在UTF-8中使用三个字节保存
    @Test
    public void testFileInputStream(){
        FileInputStream fis = null;
        try {
            //1.造文件
            File file = new File("hello1.txt");
            //2.造流
            fis = new FileInputStream(file);
            //3.读数据
            byte[] buff = new byte[5];
            int len;//记录每次读取的字节的个数
            while((len = fis.read(buff)) != -1){
                String string = new String(buff,0,len);
                System.out.println(string);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.关闭流
            if (fis != null){
                try{
                    fis.close();
                }catch (IOException e){
                    e.printStackTrace();
                }

            }
        }

    }
    /*
    实现对图片的复制操作
     */

    @Test
    public void testInputOutoutStream()  {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            //
            File srcFile = new File("集合习题.jpg");
            File destFile = new File("集合习题2.jpg");

            //
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);

            //复制操作
            byte[] buff = new byte[5];
            int len;
            while((len = fis.read(buff)) != -1){
                fos.write(buff,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //
            if (fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if (fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    //指定路径下文件的复制
    public void copyFile(String srcpath,String destpath){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            //
            File srcFile = new File(srcpath);
            File destFile = new File(destpath);

            //
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);

            //复制操作
            byte[] buff = new byte[1024];
            int len;
            while((len = fis.read(buff)) != -1){
                fos.write(buff,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //
            if (fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if (fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    @Test
    public void testCopyFile(){
        long start = System.currentTimeMillis();

        String srcFile = "C:\\Users\\Administrator\\Desktop\\二叉树.mp4";
        String destFile = "C:\\Users\\Administrator\\Desktop\\二叉树1.mp4";
//        String srcFile = "hello2.txt";
//        String destFile = "hello3.txt";
        copyFile(srcFile, destFile);

        long end = System.currentTimeMillis();
        System.out.println(end - start);//958
    }
}
