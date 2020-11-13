package com.atguigu.java1;

import java.io.Serializable;

/**
 * @author chenhuiup
 * @create 2020-07-21 下午 10:34
 */
public class Creature<T> implements Serializable {
    private char gender;
    public double weight;

    private void breath(){
        System.out.println("生物呼吸");
    }

    public void eat(){
        System.out.println("生物吃东西");
    }
}
