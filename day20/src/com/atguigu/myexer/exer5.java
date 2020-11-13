package com.atguigu.myexer;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * 在当前目录下创建子目录（“aaa/bbb/ccc”）
 *
 *  * 编写程序, 删除目录d:/jdk1.8.0....
 * @author chenhuiup
 * @create 2020-07-20 下午 3:40
 */
public class exer5 {

    @Test
    public void test(){
        File file = new File("H:\\888");
        deleteFile(file);

//        file.mkdirs();
//        try {
//            new File("H:\\888\\aaa\\bbb\\ccc\\hi.txt").createNewFile();
//            new File("H:\\888\\aaa\\bbb\\ccc\\hi.doc").createNewFile();
//            new File("H:\\888\\aaa\\bbb\\ccc\\hi.jpg").createNewFile();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


    }

//    public void deleteFile(File file){
//        if (file.isFile()){
//            file.delete();
//        }else {
//            if(!file.delete()){
//                File[] files = file.listFiles();
//                for (int i = 0; i < files.length; i++) {
//                    deleteFile(files[i]);
//                }
//            }
//
//        }
//    }

    public void deleteFile(File file){
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File f:files) {
                deleteFile(f);
            }
        }
        file.delete();
    }
}
