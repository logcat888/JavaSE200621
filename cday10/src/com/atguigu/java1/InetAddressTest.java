package com.atguigu.java1;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 一、网络编程中有两个主要的问题：
 *  1.如何准确地定位忘了上一台或多台主机：定位主机上的特定的应用
 *  2.找到主机后如何可靠高效地进行数据传输
 *
 * 二、网络编程中的两个要素
 *  1.对于问题一：IP和端口号
 *  2.对应问题二：提供网络通信协议：TCP/IP参考模型（应用层、传输层、网络层、物理+数据链路层）
 *
 * 三、通信要素一：IP和端口号
 *
 * 1. IP：唯一的标识 Internet 上的计算机（通信实体）
 * 2. 在Java中使用InetAddress类代表IP，InetAddress类主要表示IP地址，两个子类：Inet4Address、Inet6Address。
 * 3. IP分类：IPV4 和 IPV6;万维网 和 局域网
 *      补充：
 *      P地址分类方式1：IPV4 和 IPV6
 *          IPV4：4个字节组成，4个0-255。大概42亿，30亿都在北美，亚洲4亿。2011年初已经用尽。以点分十进制表示，如192.168.0.1
 *          IPV6：128位（16个字节），写成8个无符号整数，每个整数用四个十六进制位表示，数之间用冒号（：）分开，如：3ffe:3201:1401:1280:c8ff:fe4d:db39:1984
 *      IP地址分类方式2： 公网地址( 万维网使用)和 私有地址( 局域网使用)。
 *              192.168.开头的就是私有址址，范围即为192.168.0.0--192.168.255.255，专门为组织机构内部使用
 *
 * 4. 域名： www.baidu.com www.mi.com www.jd.com //由于IP地址难记，可以通过域名的方式，经过DNS(域名解析服务器)获取域名对于的IP，从而进行访问。
 *      补充：Internet上的主机有两种方式表示地址：域名(hostName)：www.atguigu.com // IP 地址(hostAddress)：202.108.35.210
 *
 * 5. 本地回路地址： 127.0.0.1 对应着： Localhost
 *
 * 6.如何实例化InetAddress：两个方法：getByName(String host) --->可以填域名也可填IP地址 \ getLocalHost()--->获取本机IP地址
 *          两个常用方法：getHostName() ---> 获取域名 / getHostAddress() --> 获取IP地址
 *
 * 7.端口号：正在计算机上运行的进程
 *      要求：不同的进程有不同的端口号
 *      范围：被规定为一个16位的整数 0- 65535
 *
 *      端口分类：
 *            公认端口：0~1023。被预先定义的服务通信占用（如：HTTP占用端口80，FTP占用端口21，Telnet占用端口23）
 *            注册端口：1024~49151。分配给用户进程或应用程序。（如：Tomcat占用端口8080，MySQL占用端口3306，Oracle占用端口1521等）。
 *            动态/ 私有端口：49152~65535。
 *
 *  8. 端口号与IP地址的组合得出一个网络套接字：Socket
 *
 *  9. TCP/IP 协议簇：
 *         传输层协议中有两个非常重要的协议：
 *               传输控制协议TCP(Transmission Control Protocol)
 *               用户数据报协议UDP(User Datagram Protocol)。
 * TCP/IP以其两个主要协议：传输控制协议(TCP) 和网络互联协议(IP)而得名，实际上是一组协议，包括多个具有不同功能且互为关联的协议。
 * IP(Internet Protocol)协议是网络层的主要协议，支持网间互连的数据通信。
 * TCP/IP协议模型从更实用的角度出发，形成了高效的四层体系结构，即物理链路层、IP 层、传输层和应用层。
 *
 * 10.TCP  和 UDP
 *      TCP 协议：
         *  使用TCP协议前，须先建立TCP连接，形成传输数据通道
         *  传输前，采用“ 三次握手”方式，点对点通信，是可靠的
         *  TCP协议进行通信的两个应用进程：客户端、服务端。
         *  在连接中可进行大数据量的传输
         *  传输完毕，需释放已建立的连接，效率低
 *       UDP 协议：
         *  将数据、源、目的封装成数据包，不需要建立连接
         *  每个数据报的大小限制在64K内
         *  发送不管对方是否准备好，接收方收到也不确认，故是不可靠的
         *  可以广播发送
         *  发送数据结束时无需释放资源，开销小，速度快
 *
 *
 * @author chenhuiup
 * @create 2020-07-18 下午 7:13
 */
public class InetAddressTest {

    public static void main(String[] args) {


        try {
            InetAddress inet1 = InetAddress.getByName("192.168.10.14");

            System.out.println(inet1);

            InetAddress inet2 = InetAddress.getByName("www.baidu.com");

            System.out.println(inet2);

            InetAddress inet3 = InetAddress.getByName("127.0.0.1");
            System.out.println(inet3);

            //  获取本机IP
            InetAddress inet4 =InetAddress.getLocalHost();
            System.out.println(inet4);

            //getHostName()获取域名
            System.out.println(inet2.getHostName());
            //getHostAddress()获取端口
            System.out.println(inet2.getHostAddress());

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }


    }

}
