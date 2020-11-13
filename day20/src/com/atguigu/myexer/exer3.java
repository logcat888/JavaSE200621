package com.atguigu.myexer;

import com.sun.prism.shader.Texture_ImagePattern_AlphaTest_Loader;

import java.io.*;

/**
 * 从键盘获取几行字符串, 把它们写入文件keyboard_gbk.txt文件中. 直到输入"quit"命令.
 * @author chenhuiup
 * @create 2020-07-20 下午 2:47
 */
public class exer3 {

    public static void main(String[] args) {
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            br = new BufferedReader(isr);
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("keyboard_gbk.txt",true),"gbk"));

            String data;
            while ((data = br.readLine()) != null){
                if (data.equals("exit")){
                    System.out.println("打印完毕");
                    break;
                }
                bw.write(data.toUpperCase());
                bw.newLine();
                bw.flush();
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
