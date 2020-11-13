package com.atguigu.java1;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author chenhuiup
 * @create 2020-07-18 下午 10:26
 * 实现TCP的网络编程
 *例题3：从客户端发送文件给服务端，服务端保存到本地。并返回“发送成功”给客户端。
 *  * 并关闭相应的连接。
 *
 */
public class TCPTest3 {

    @Test
    public void client() {

        Socket socket = null;
        OutputStream os = null;
        BufferedInputStream bis = null;
        ByteArrayOutputStream baos = null;
        try {
            //1.创建客户端的Scoket对象，指明服务器端的ip和端口号
            socket = new Socket(InetAddress.getByName("127.0.0.1"),8899);
            //2.获取一个输出流，用于输出数据
            os = socket.getOutputStream();
            //3.获取输入流，读取本地文件
            bis = new BufferedInputStream(new FileInputStream("赵丽颖2.jpg"));
            //4.读写操作
            byte[] buffer = new byte[10];
            int len;
            while((len = bis.read(buffer)) != -1){
                os.write(buffer,0,len);
            }
            //关闭数据的输出
            socket.shutdownOutput();

            //5.接收来自于服务器端的数据，并显示到控制台上
            InputStream is = socket.getInputStream();

            baos = new ByteArrayOutputStream();
            byte[] buff = new byte[20];
            len = 0;
            while ((len = is.read(buff)) != -1){
                baos.write(buff,0,len);
            }
            System.out.println(baos.toString());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //6.资源关闭
            if(os != null){

                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(bis != null){

                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if(baos != null){
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @Test
    public void server() {
        ServerSocket ss = null;
        Socket socket = null;
        InputStream is = null;
        BufferedOutputStream bos = null;
        OutputStream os = null;
        try {
            //1.创建服务器端的ServerSocket，指明自己的端口号
            ss = new ServerSocket(8899);
            //2.调用accept()表示接收来自于客户端的socket
            socket = ss.accept();
            //3.获取输入流
            is = socket.getInputStream();
            //4.保存到本地的输出流
            bos = new BufferedOutputStream(new FileOutputStream("赵丽颖4.jpg"));

            //5.读写操作
            byte[] buffer = new byte[10];

            int len;

            while((len = is.read(buffer)) != -1){
                bos.write(buffer,0,len);
            }
            System.out.println("图片传输完成");

            //6.服务器端给予客户端反馈
            os = socket.getOutputStream();
            os.write("你好，美女，照片我已收到，非常漂亮！".getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //7.关闭资源
            if(bos != null){
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(ss != null){
                try {
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if(os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
