package com.atguigu.java;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author chenhuiup
 * @create 2020-07-14 下午 2:52
 */
public class ClockTest {
    public static void main(String[] args) throws InterruptedException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        while(true){
//            Date date = new Date();
            String format = simpleDateFormat.format(System.currentTimeMillis());
//            System.out.print("\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b" + format);
            System.out.print("\n" + format);
            Thread.sleep(1000);
        }

    }
}
