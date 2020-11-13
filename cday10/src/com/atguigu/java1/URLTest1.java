package com.atguigu.java1;

import javax.net.ssl.HttpsURLConnection;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author chenhuiup
 * @create 2020-07-18 下午 11:40
 */
public class URLTest1 {

    public static void main(String[] args) {
        URLConnection urlConnection = null;
        InputStream is = null;
        FileOutputStream fos = null;
        try {
            URL url = new URL("https://image.baidu.com/search/detail?ct=503316480&z=0&ipn=d&word=%E9%99%88%E9%92%B0%E7%90%AA%20%E8%B5%B5%E6%95%8F&step_word=&hs=0&pn=0&spn=0&di=10560&pi=0&rn=1&tn=baiduimagedetail&is=0%2C0&istype=2&ie=utf-8&oe=utf-8&in=&cl=2&lm=-1&st=-1&cs=1380390490%2C1188616975&os=1138092859%2C751462957&simid=3186338812%2C3924694222&adpicid=0&lpn=0&ln=239&fr=&fmq=1595087034864_R&fm=result&ic=&s=undefined&hd=&latest=&copyright=&se=&sme=&tab=0&width=&height=&face=undefined&ist=&jit=&cg=&bdtype=0&oriquery=&objurl=http%3A%2F%2Fimg1.doubanio.com%2Fview%2Fgroup_topic%2Fl%2Fpublic%2Fp165693658.jpg&fromurl=ippr_z2C%24qAzdH3FAzdH3Fooo_z%26e3B157kwg_z%26e3Bv54AzdH3F2657rAzdH3Fp5rtvAzdH3F8ncbdcm0bAzdH3F%3Fvt1%3D8bncm0d90l&gsm=1&rpstart=0&rpnum=0&islist=&querylist=&force=undefined");

            //获取连接
            urlConnection = (HttpsURLConnection)url.openConnection();
            //建立连接
            urlConnection.connect();
            //获取流
            is = urlConnection.getInputStream();
            fos = new FileOutputStream("陈钰琪.jpg");
            byte[] buffer = new byte[1024];
            int len;
            while((len = is.read(buffer)) != -1){
                fos.write(buffer,0,len);
            }

            System.out.println("下载完成");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            if (is != null){

                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null){

                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
//            urlConnection.disconnect();
        }


    }
}
