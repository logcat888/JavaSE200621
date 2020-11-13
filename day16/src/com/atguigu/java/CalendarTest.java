package com.atguigu.java;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

/**
 * @author chenhuiup
 * @create 2020-07-14 下午 3:31
 */
public class CalendarTest {
    @Test
    public void method(){
        Calendar instance = Calendar.getInstance();
        instance.set(Calendar.YEAR,1995);
        instance.set(Calendar.MONTH,0);
        instance.set(Calendar.DAY_OF_MONTH,12);

        Date time = instance.getTime();
        System.out.println(time);

        instance.add(Calendar.DAY_OF_YEAR,100);
        time = instance.getTime();
        System.out.println(time);
    }
}
