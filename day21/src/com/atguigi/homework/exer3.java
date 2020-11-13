package com.atguigi.homework;

import org.junit.Test;

import java.io.*;

/**
 * @author chenhuiup
 * @create 2020-07-23 下午 2:40
 */
//写一个文件,写入随机个随机数, 再读取它.
public class exer3 {

    @Test
    public void test1(){
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("随机个文件")));
            int i = (int) (Math.random() * 100);
            oos.writeInt(i);
            for (int j = 0; j < i; j++) {
                oos.writeInt((int) (Math.random() * 100));
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
    public void test2(){
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream("随机个文件")));
            int i = ois.readInt();
            for (int j = 0; j < i; j++) {
                System.out.println(ois.readInt());
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
