package com.atguigu.myexer;

import org.junit.Test;

import java.io.*;

/**
 * @author chenhuiup
 * @create 2020-07-18 下午 2:33
 * <p>
 * //编写程序FileCopy.java，在测试方法中，将FileCopy.java复制为FileCopy.java.bak文件；
 * //查看FileCopy.java.bak文件的内容，验证复制是否正确。
 */
public class exer3 {


    @Test
    public void test(){
        //
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new FileReader("我是一个文件"));
            bw = new BufferedWriter(new FileWriter("FileCopy.java.bak"));

            //
            String data;
            int count = 1;
            while ((data = br.readLine()) != null) {
                bw.write(count++ + " ");
                bw.write(data);
                bw.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //
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
