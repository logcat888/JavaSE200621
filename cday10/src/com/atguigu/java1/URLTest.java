package com.atguigu.java1;

import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * URL网络编程
 * 1.URL：统一资源定位符，对应着互联网的某一资源地址
 * 2.格式：
 *    http://localhost:8080/examples/beauty.jpg?username=Tom
 *    协议       主机名  端口号      资源地址        参数列表
 *
 * 3.常用方法
 * 一个URL对象生成后，其属性是不能被改变的，但可以通过它给定的
 * 方法来获取这些属性：
 * public String getProtocol(  )     获取该URL的协议名
 * public String getHost(  )         获取该URL的主机名
 * public String getPort(  )         获取该URL的端口号
 * public String getPath(  )         获取该URL的文件路径
 * public String getFile(  )          获取该URL的文件名
 * public String getQuery(   )      获取该URL的查询名
 * @author chenhuiup
 * @create 2020-07-18 下午 11:28
 */
public class URLTest {

    public static void main(String[] args) {
        try {
            URL url = new URL("http://localhost:8080/examples/beauty.jpg?username=Tom");

//         public String getProtocol(  )     获取该URL的协议名
            System.out.println(url.getProtocol());
//         public String getHost(  )         获取该URL的主机名
            System.out.println(url.getHost());
//         public String getPort(  )         获取该URL的端口号
            System.out.println(url.getPort());
//         public String getPath(  )         获取该URL的文件路径
            System.out.println(url.getPath());
//         public String getFile(  )          获取该URL的文件名
            System.out.println(url.getFile());
//         public String getQuery(   )      获取该URL的查询名
            System.out.println(url.getQuery());


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } finally {
        }
    }
}
