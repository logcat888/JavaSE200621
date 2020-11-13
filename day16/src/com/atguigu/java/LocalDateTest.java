package com.atguigu.java;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @author chenhuiup
 * @create 2020-07-14 下午 4:16
 */
public class LocalDateTest {
    @Test
    public void method(){
        LocalDate now = LocalDate.now();
        System.out.println(now);
        LocalDate birthday = now.withYear(1995).withMonth(1).withDayOfMonth(12);
        System.out.println(birthday);

        LocalTime now1 = LocalTime.now();

    }
}
