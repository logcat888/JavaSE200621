package com.atguigu.java1;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * 实现TCP的网络编程
 * 例题2：客户端发送文件给服务端，服务端将文件保存在本地。
 *
 * @author chenhuiup
 * @create 2020-07-18 下午 9:22
 */
public class TCPTest2 {

    @Test
    public void client() {

        Socket socket = null;
        OutputStream os = null;
        BufferedInputStream bis = null;
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
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //5.资源关闭
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
        }

    }

    @Test
    public void server() {
        ServerSocket ss = null;
        Socket socket = null;
        InputStream is = null;
        BufferedOutputStream bos = null;
        try {
            //1.创建服务器端的ServerSocket，指明自己的端口号
            ss = new ServerSocket(8899);
            //2.调用accept()表示接收来自于客户端的socket
            socket = ss.accept();
            //3.获取输入流
            is = socket.getInputStream();
            //4.保存到本地的输出流
            bos = new BufferedOutputStream(new FileOutputStream("赵丽颖3.jpg"));

            //5.读写操作
            byte[] buffer = new byte[10];

            int len;

            while((len = is.read(buffer)) != -1){
                bos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //6.关闭资源
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
        }
    }
}
