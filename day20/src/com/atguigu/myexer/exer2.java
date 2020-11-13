package com.atguigu.myexer;

import org.junit.Test;

import java.io.*;

/**
 * @author chenhuiup
 * @create 2020-07-20 下午 2:17
 */
public class exer2 {

    @Test
    public void test(){

        BufferedReader br = null;
        try {
            FileInputStream fis = new FileInputStream("HashMap2.java");
            InputStreamReader isr = new InputStreamReader(fis, "gbk");
            br = new BufferedReader(isr);
            String data;
            while ((data = br.readLine()) != null){
                System.out.println(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null){

                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
