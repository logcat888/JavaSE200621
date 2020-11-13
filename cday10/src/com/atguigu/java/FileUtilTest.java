package com.atguigu.java;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * @author chenhuiup
 * @create 2020-07-18 下午 6:55
 */
public class FileUtilTest {

    public static void main(String[] args) {

        try {
            File srcFile = new File("cday10\\赵丽颖.jpg");
            File destFile = new File("cday10\\赵丽颖2.jpg");

            FileUtils.copyFile(srcFile,destFile);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }
    }
}
