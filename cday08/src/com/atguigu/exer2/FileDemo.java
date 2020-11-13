package com.atguigu.exer2;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author chenhuiup
 * @create 2020-07-16 下午 7:14
 */
public class FileDemo {

    @Test
    public void test() throws IOException {
        File file = new File("d:\\io\\io1\\hello.txt");
        //创建一个与file同目录下的另外一个文件，文件名为：haha.txt
        File file1 = new File(file.getParent(),"haha.txt");
        boolean newFile = file1.createNewFile();
        if (newFile){
            System.out.println("创建文件成功！");
        }
        File file2 = new File("d:\\io\\io1\\io3");
        boolean mkdir = file2.mkdir();
        if (mkdir){
            System.out.println("文件目录创建成功！");
        }
        boolean delete = file2.delete();
        if (delete){
            System.out.println("删除成功");
        }
    }

    @Test
    public void test3(){
        //判断指定目录下是否有后缀名为.jpg的文件，如果有，就输出该文件名称。
        File file = new File("d:\\io\\io1");
        File[] files = file.listFiles();
        int count = 0;
        for (File f : files) {
            boolean jpg = f.getName().contains("jpg");
            if (jpg){
                f.delete();
                count++;
                System.out.println("删除成功" + count);
            }
        }
        if (count == 0){
            System.out.println("当前目录下没有后缀名为.jpg的文件");
        }
    }
}
