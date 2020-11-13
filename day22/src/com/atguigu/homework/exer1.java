package com.atguigu.homework;

import org.junit.Test;

import java.io.*;

/**
 * @author chenhuiup
 * @create 2020-07-22 下午 1:07
 * <p>
 * 1 复制目录 c:/program files 到 d:/program files
 * 列出源目录中的所有内容, 遍历之, 如果是文件, 直接复制文件, 如果是目录, 递归调用.
 */
public class exer1 {

    public void copyFile(File srcFile, File destFile) {
        System.out.println("复制文件" + srcFile.getAbsolutePath() + " 到 " + destFile.getAbsolutePath());
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);

            byte[] buffer = new byte[8192];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                fos.write(buffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void copyDir(File srcFile, File destFile) {
        if (!destFile.exists()) {
            destFile.mkdirs();
        }
        File[] children = srcFile.listFiles();
        if (!srcFile.canRead() || children == null) {
            System.out.println("源目录[" + srcFile.getAbsoluteFile() + "]不允许复制");
            return;
        }
        for (int i = 0; i < children.length - 1; i++) {
            File child = children[i];
            File target = new File(destFile.getAbsolutePath() + "/" + child.getName());
            if (child.isFile()) {
                //复制文件
                copyFile(child, target);
            } else {
                //递归，以child为源，destFile/child.getName
                copyDir(child, target);
            }
        }
    }

    @Test
    public void test1() throws FileNotFoundException {
        File srcFile = new File("xxx");
        File destFile = new File("AAA");
        copyDir(srcFile, destFile);
    }
}
