package com.atguigu.java1;

import org.junit.Test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * UDP协议的网络编程
 *
 * @author chenhuiup
 * @create 2020-07-18 下午 11:04
 */
public class UDPTest {
    //发送端
    @Test
    public void sender(){

        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket();


            String str = new String("我是UDP方式发送的导弹");
            byte[] bytes = str.getBytes();
            InetAddress inet = InetAddress.getLocalHost();
            DatagramPacket packet = new DatagramPacket(bytes, 0, bytes.length, inet, 8899);

            socket.send(packet);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(socket != null){

                socket.close();
            }
        }



    }

    //接收端
    @Test
    public void receiver(){

        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket(8899);


            byte[] buffer = new byte[200];
            DatagramPacket packet = new DatagramPacket(buffer,0,buffer.length);

            socket.receive(packet);

            System.out.println(new String(packet.getData(),0,packet.getLength()));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null){
                socket.close();

            }
        }

    }
}
