package com.atguigu.myexer;

import org.junit.Test;

import java.io.*;

import static java.lang.Thread.sleep;

/**
 * @author chenhuiup
 * @create 2020-07-20 下午 6:47
 *
 * * 写一个文件,写入随机个随机数, 再读取它.
 */
public class exer9 {
    @Test
    public void test(){
        FileWriter fw = null;
        BufferedReader bw = null;
        try {
            fw = new FileWriter("随机数文件.txt");


            int num = 22;
            while(num < 70 && num >20 ){
                num = (int)(Math.random()*65 +20);
                fw.write("" + num);
                fw.write("\n");
                fw.flush();
            }
            try {
                sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            bw = new BufferedReader(new FileReader("随机数文件.txt"));
            String data;
            while((data = bw.readLine()) != null){
                System.out.println(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fw != null){

                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bw != null){

                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
