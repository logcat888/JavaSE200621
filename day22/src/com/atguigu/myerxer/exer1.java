package com.atguigu.myerxer;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author chenhuiup
 * @create 2020-07-22 上午 9:59
 */
/*
1 复制目录 c:/program files 到 d:/program files
    列出源目录中的所有内容, 遍历之, 如果是文件, 直接复制文件, 如果是目录, 递归调用.
 */
public class exer1 {

    @Test
    public void test1(){
        File srcFile = new File("G:\\美农工作-陈辉\\77777");
        File destFile = new File("H:\\8888");
        copyDir(srcFile,destFile);
    }

    public void copyDir(File srcFile,File destFile){
        if (!destFile.exists()) {
            destFile.mkdirs();
        }

        if (!srcFile.canRead()){
            System.out.println("源目录[" + srcFile.getAbsolutePath() + "] 不允许复制");
            return;
        }
        if (srcFile.isDirectory()){
            File[] files = srcFile.listFiles();
            for (int i = 0; i < files.length; i++) {
                File child = files[i];
                File destchild = new File(destFile.getAbsolutePath() + "/" + child.getName());
                if (child.isDirectory()){
                    copyDir(child,destchild);
                }else {
                    copyFile(child,destchild);
                }
            }
        }else {
            copyFile(srcFile,destFile);
        }
    }

    private void copyFile(File srcFile, File destFile) {
        System.out.println("复制文件 : " + srcFile.getAbsolutePath() + " 到 " + destFile.getAbsolutePath());
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);

            byte[] buffer = new byte[8192];
            int len;
            while((len = fis.read(buffer)) != -1){
                fos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
