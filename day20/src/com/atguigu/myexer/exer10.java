package com.atguigu.myexer;

import org.junit.Test;

import java.io.*;

/**
 * @author chenhuiup
 * @create 2020-07-20 下午 7:24
 */

public class exer10{
    @Test
    public void test2(){
        FileInputStream fis = null; //节点流
        BufferedInputStream bis = null;//缓冲流
        ObjectInputStream ois = null;//对象流

        try {
            fis = new FileInputStream("二进制文件");
            bis = new BufferedInputStream(fis);
            ois = new ObjectInputStream(bis);

            System.out.println(ois.readInt());
            System.out.println(ois.readBoolean());
            System.out.println(ois.readDouble());
            System.out.println(ois.readUTF());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(ois != null){
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    @Test
    public void test1(){
        FileOutputStream fos = null;//写文件。节点流。对于二进制文件，应使用字节输出流FileOutputStream流
        BufferedOutputStream bos = null;//缓冲流，写文件，体现效率。
        ObjectOutputStream oos = null;//对象流。存储对象的对象流。

        try {
            fos = new FileOutputStream("二进制文件");
            bos = new BufferedOutputStream(fos);//缓冲流把节点流包起来。对象关联。
            oos = new ObjectOutputStream(bos);//对象流，处理缓冲流

            oos.writeInt(20);
            oos.writeBoolean(true);
            oos.writeDouble(3.14);

            oos.writeUTF("abc我和你zzz");


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(oos !=null){
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


