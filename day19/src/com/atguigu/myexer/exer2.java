package com.atguigu.myexer;

import org.junit.Test;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author chenhuiup
 * @create 2020-07-18 下午 2:18
 */
public class exer2 {


    @Test
    public void test(){
        String[] string = new String[]{"张三","李四","王五","六西格玛","七上八下","九月一号"};
        FileWriter fr = null;
        try {
            fr = new FileWriter("姓名表");

            for (int i = 0; i < string.length; i++) {
//                char[] chars = string[i].toCharArray();
//                fr.write(chars,1,chars.length - 1);
//                fr.write("\n");
                fr.write(string[i].substring(1,string[i].length()) + "\n");

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @Test
    public void test3(){

    }
}
