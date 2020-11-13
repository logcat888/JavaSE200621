package com.atguigu.java;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * RandomAccessFile的使用
 * 1.RandomAccessFile直接继承于java.lang.Object类，实现了DataInput和DataOutput接口
 * 2.RandomAccessFile既可以作为一个输入流，又可以作为一个输出流。
 *
 * 3.如果RandomAccessFile作为输出流时，写出到的文件如果不存在，则再执行过程中自动创建文件。
 *      如果写出到的文件存在，则会对原有文件内容进行覆盖操作。（默认情况下，从头覆盖）
 *
 * 4.可以通过相关的操作，实现RandomAccessFile“插入”数据的效果。
 *
 * 补充点：
 * RandomAccessFile 对象包含一个记录指针，用以标示当前读写处的位置。
 * RandomAccessFile 类对象可以自由移动记录指针：
 * long getFilePointer()：获取文件记录指针的当前位置
 * void seek(long pos)：将文件记录指针定位到 pos 位置
 *
 * 构造器
 * public RandomAccessFile(File file, String mode)
 * public RandomAccessFile(String name, String mode)
 * 创建 RandomAccessFile 类实例需要指定一个 mode 参数，该参数指
 * 定 RandomAccessFile 的访问模式：
 * r:  以只读方式打开
 * rw ：打开以便读取和写入
 * rwd: 打开以便读取和 写入；同步文件内容的更新
 * rws: 打开以便读取和 写入； 同步文件内容和元数据 的 更新
 *  如果模式为只读r。则不会创建文件，而是会去读取一个已经存在的文件，
 * 如果读取的文件不存在则会出现异常。 如果模式为rw读写。如果文件不
 * 存在则会去创建文件，如果存在则不会创建。
 *
 * @author chenhuiup
 * @create 2020-07-18 下午 5:38
 */
public class RandomAccessFileTest {

    @Test
    public void test1(){
        RandomAccessFile raf1 = null;
        RandomAccessFile raf2 = null;
        try {
            //1.
            raf1 = new RandomAccessFile(new File("赵丽颖.jpg"),"r");
            raf2 = new RandomAccessFile(new File("赵丽颖1.jpg"),"rw");
            //2.
            byte[] cbuf = new byte[1024];
            int len;
            while((len = raf1.read(cbuf)) != -1){
                raf2.write(cbuf,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (raf1 != null){
                //3.
                try {
                    raf1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (raf2 != null){
                try {
                    raf2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }


        }

    }

    @Test
    public void test2(){
        RandomAccessFile raf = null;
        try {
            File file = new File("hello.txt");
            raf = new RandomAccessFile(file,"rw");
//            raf.seek(3);//将指针调到角标为3的位置。

            raf.seek(file.length());//获取文件的长度，并将指针调到文件末尾的位置，实现追加操作。
            raf.write("xyz".getBytes());//覆盖数据效果
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (raf != null){

                try {
                    raf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    /*
    使用RandomAccessFile实现数据的插入效果
     */
    @Test
    public void test3(){
        RandomAccessFile raf = null;
        try {
            File file = new File("hello.txt");
            raf = new RandomAccessFile(file,"rw");
            raf.seek(3);//将指针调到角标为3的位置。
            StringBuilder builder = new StringBuilder((int)file.length());
            //保存指针3后面的所有数据到Stringbuilder中
            byte[] buff = new byte[20];
            int len;
            while ((len = raf.read(buff)) != -1){
                builder.append(new String(buff,0,len));
            }
            //调回指针，写入“xyz”
            raf.seek(3);
            raf.write("xyz".getBytes());//覆盖数据效果

            //将StringBuilder中的数据写入到文件中
            raf.write(builder.toString().getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (raf != null){

                try {
                    raf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
//思考：将Stringbuilder替换为ByteArrayOutputStream
    }
}
