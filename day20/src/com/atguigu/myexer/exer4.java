package com.atguigu.myexer;

import org.junit.Test;

import java.io.*;
import java.util.*;

/**
 * 给定一个字符串, 统计每个字符出现的次数

 * 写一个文件,写入随机个随机数, 再读取它.

 * //在当前目录下创建子目录(“aaa/bbb/ccc”)
 * //1)   在其中创建多个文件和目录
 * //2)   编写方法，实现删除子目录ccc中文件的操作
 * <p>
 * <p>
 * 编写程序, 删除目录d:/jdk1.8.0....
 *
 * @author chenhuiup
 * @create 2020-07-20 下午 3:11
 */
public class exer4 {
    @Test
    public void test() {
        FileReader fr = null;
        BufferedWriter bw = null;
        try {
            fr = new FileReader("字符串.txt");
            bw = new BufferedWriter(new FileWriter("字符串1.txt"));
            HashMap<Character, Integer> map = new HashMap<>();
            char[] buffer = new char[1];
            int len;
            while ((len = fr.read(buffer)) != -1) {
                Character char1 = buffer[0];
                if (map.containsKey(char1)) {
                    Integer integer = map.get(char1);
                    integer += 1;
                    map.put(char1, integer);
                }else{
                    map.put(char1, 1);
                }

            }
            Set<Map.Entry<Character, Integer>> entries = map.entrySet();
            Iterator<Map.Entry<Character, Integer>> iterator = entries.iterator();
            while (iterator.hasNext()) {
                Map.Entry<Character, Integer> next = iterator.next();
                bw.write(next.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
