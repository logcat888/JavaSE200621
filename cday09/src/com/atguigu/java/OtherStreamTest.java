package com.atguigu.java;

import org.junit.Test;

import javax.xml.crypto.Data;
import java.io.*;

/**
 * 其他流的使用
 * 1.标准的输入流、输出流
 * 2.打印流
 * 3.数据流
 *
 * @author chenhuiup
 * @create 2020-07-17 下午 10:10
 */
public class OtherStreamTest {

    /*
    1.标准的输入、输出流
    1.1
    System.in：标准的输入流(InputStream)，默认从键盘输入,字节流，需要使用转换流转换一下
    System.out：标准的输出流,默认从控制台输出(类型是PrintStream，其是OutputStream的子类FilterOutputStream 的子类)
    1.2
    System类的SetIn(InputStream is) / SetOut(PrintStream ps)方式重新指定输入和输出的流。

    1.3练习：
    从键盘输入字符串，要求将读取到的整行字符串转成大写输出。然后继续进行输入操作，
    直至当输入“e”或者“exit”时，退出程序。

    方法一：使用Scanner实现，调用next()返回一个字符串
    方法二：使用System.in实现。 System.in  ---> 转换流 ---> BufferedReader的readLine()
     */


    public static void main(String[] args){//IDEA中不支持单元测试中标准的输入流(System.in)，无法输入，必须在main()中使用
        BufferedReader br = null;
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            br = new BufferedReader(isr);

            while(true){
                System.out.println("请输入字符串：");
                String data = br.readLine();
                if ("e".equalsIgnoreCase(data) || "exit".equalsIgnoreCase(data)){
                    System.out.println("程序结束");
                    break;
                }
                String toUpperCase = data.toUpperCase();
                System.out.println(toUpperCase);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
    /*
    2.打印流：PrintStream 和 PrintWriter

    2.1 提供了一系列重载的print()和println()
    2.2 练习：
     */
    @Test
    public void test2() {
        PrintStream ps = null;
        try {
            FileOutputStream fos = new FileOutputStream(new File("D:\\IO\\text.txt"));
            // 创建打印输出流,设置为自动刷新模式(写入换行符或字节 '\n' 时都会刷新输出缓冲区)
            ps = new PrintStream(fos, true);
            if (ps != null) {// 把标准输出流(控制台输出)改成文件
                System.setOut(ps);
            }


            for (int i = 0; i <= 255; i++) { // 输出ASCII字符
                System.out.print((char) i);
                if (i % 50 == 0) { // 每50个数据一行
                    System.out.println(); // 换行
                }
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                ps.close();
            }
        }

    }
    /*
    3. 数据流
    3.1 DataInputStream 和 DataOutputStream
    3.2 作用：用于读取或写出基本数据类型的变量或字符串

    练习：将内存中的字符串，基本数据类型的变量写出到文件中。

    注意：处理异常的话，仍然应该使用try-catch-finally。
     */
    @Test
    public void test3() throws IOException {
        //1.
        DataOutputStream dos = new DataOutputStream(new FileOutputStream("data.txt"));
        //2.
        dos.writeUTF("张三");
        dos.flush();//刷新操作，将内存中的数据写入到文件中
        dos.writeInt(555);
        dos.flush();
        dos.writeBoolean(true);
        dos.flush();
        //3.
        dos.close();
    }
    /*
    将文件中存储的基本数据类型变量和字符串读取到内存中，保存在变量中。

    注意点：读取不同类型的数据的顺序要与当初写入文件时保存的数据的顺序一致，否则会报EOFException异常。
     */
    @Test
    public void test4(){
        //1.
        DataInputStream dis = null;
        try {
            dis = new DataInputStream(new FileInputStream("data.txt"));

            //2.
            int i = dis.readInt();
            String string = dis.readUTF();
            boolean b = dis.readBoolean();

            System.out.println("name = " + string);
            System.out.println("age = " + i);
            System.out.println("isMale = " + b);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //3.
            if (dis != null) {
                try {
                    dis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
