package com.atguigu.myexer;

import org.junit.Test;

import java.io.*;

/**
 * @author chenhuiup
 * @create 2020-07-20 上午 10:49
 */
public class exer1 {

    @Test
    public void test(){
        ObjectOutputStream oos = null;
        try {
            FileOutputStream fos = new FileOutputStream("二进制文件.txt");
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            oos = new ObjectOutputStream(bos);

            for (int i = 0; i < 50; i++) {
                oos.writeInt((int)(Math.random()*100));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null){

                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @Test
    public void test1(){

        ObjectInputStream ois = null;
        try {
            FileInputStream fis = new FileInputStream("二进制文件.txt");
            BufferedInputStream bis = new BufferedInputStream(fis);
            ois = new ObjectInputStream(bis);

            for (int i = 0; i < 50; i++) {
               Integer integer = ois.readInt();
                System.out.println(integer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ois != null){

                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
