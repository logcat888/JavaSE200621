package com.atguigi.homework;

import org.junit.Test;

import java.io.File;

/**
 * @author chenhuiup
 * @create 2020-07-23 下午 1:58
 */
//删除目录
public class exer1 {

    @Test
    public void deletFile(File file){
        if (file.isDirectory()){
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                if (files[i].isFile()){
                    deletFile(files[i]);
                }else {
                    deletFile(files[i]);
                }
            }
        }else {
            file.delete();
        }
    }
}
