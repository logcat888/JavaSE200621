package com.atguigi.myexer;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author chenhuiup
 * @create 2020-07-21 下午 4:41
 */
public class exer7 {

    @Test
    public void Client() {
        Socket socket = null;
        BufferedReader br = null;
        try {
            InetAddress inet = InetAddress.getByName("127.0.0.1");
            socket = new Socket(inet, 11111);
            InputStream is = socket.getInputStream();
            br = new BufferedReader(new InputStreamReader(is));

            System.out.println(br.readLine());
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
            if (socket != null) {

                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @Test
    public void Server() {
        ServerSocket server = null;
//        Socket socket = null;
        try {
            server = new ServerSocket(11111);
            while (true) {
//                socket = server.accept();
                Socket socket = server.accept();

//                OutputStream os = socket.getOutputStream();
//                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
//
//                bw.write("我是服务器,你好客户端" + LocalDateTime.now());
//                bw.newLine();
//                bw.flush();
//                socket.close();
                Runnable runnable = new Runnable() {

                    @Override
                    public void run() {
                        try {
                            OutputStream os = socket.getOutputStream();
                            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));

                            bw.write("我是服务器,你好客户端" + LocalDateTime.now());
                            bw.newLine();
                            bw.flush();
                            socket.close();
                            Thread.sleep(10*1000);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                };
                new Thread(runnable).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
//            if (bw != null) {
//
//                try {
//                    bw.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//            if (socket != null) {
//                try {
//                    socket.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }

            }
            if (server != null) {
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }


    }

