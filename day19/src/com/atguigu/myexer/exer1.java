package com.atguigu.myexer;

import org.junit.Test;

import java.io.*;

/**
 * @author chenhuiup
 * @create 2020-07-18 上午 11:54
 */
public class exer1 {

    @Test
    public void test() {

        FileInputStream fis = null;
        try {
            fis = new FileInputStream("我是一个文件");

            byte[] cbuf = new byte[10];
            int len;
            int count = 1;
            System.out.println(count);
            while ((len = fis.read(cbuf)) != -1){
                for (int i = 0; i < len; i++) {
                    System.out.print((char) cbuf[i]);
                    if (cbuf[i] == '\n'){
                        System.out.print(count++ + " ");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    @Test
    public void test1(){
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("我是一个文件"));

            String data;
            int count = 1;
            while ((data = br.readLine()) != null) {
                System.out.println(count++ + " " + data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {

                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
