package com.atguigu.exer;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author chenhuiup
 * @create 2020-07-17 下午 8:28
 */
public class PicTest {

    //图片加密
    @Test
    public void test1() {

        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream("集合习题3.jpg");
            fos = new FileOutputStream("集合习题secret.jpg");

            byte[] buff = new byte[10];
            int len;
            while((len = fis.read(buff)) != -1){
                //字节数组进行修改
                //错误的
    //            for (byte b: buff) {
    //                b = (byte)(b ^ 5);
    //            }

                //正确的
                for (int i = 0; i < len; i++) {
                    buff[i] = (byte)(buff[i] ^ 5);
                }

                fos.write(buff,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
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
    //图片解密
    //@Test
    public void test2() {

        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream("集合习题secret.jpg");
            fos = new FileOutputStream("集合习题4.jpg");

            byte[] buff = new byte[10];
            int len;
            while((len = fis.read(buff)) != -1){
                //字节数组进行修改
                //错误的
                //            for (byte b: buff) {
                //                b = (byte)(b ^ 5);
                //            }

                //正确的
                for (int i = 0; i < len; i++) {
                    buff[i] = (byte)(buff[i] ^ 5);
                }

                fos.write(buff,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
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
}
