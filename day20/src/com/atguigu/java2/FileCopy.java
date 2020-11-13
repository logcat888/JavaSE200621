package com.atguigu.java2;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCopy {

    //编写程序FileCopy.java，在测试方法中，将FileCopy.java复制为FileCopy.java.bak文件；
    //查看FileCopy.java.bak文件的内容，验证复制是否正确。
    public static void main(String[] args) {
        FileReader fileReader = null;
        FileWriter fileWriter = null;
        try {
            //fileReader = new FileReader("./src/com/atguigu/javase/io/FileCopy.java");
            //fileReader = new FileReader("D:\\MyWork\\JavaSE\\day19\\src\\com\\atguigu\\javase\\io\\FileCopy.java");
            fileReader = new FileReader("落花流水.mp3");
            fileWriter = new FileWriter("流水落花.mp3");
            char[] arr = new char[2000];
            int count;
            while ((count = fileReader.read(arr)) != -1) { // 以读为主导, 读到什么就写什么.
                // 把读到的内容通过输出流写文件
                fileWriter.write(arr, 0, count);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 多个流的关闭要独立.
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
