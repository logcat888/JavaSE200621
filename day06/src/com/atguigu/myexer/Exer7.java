package com.atguigu.myexer;

import java.util.Arrays;

public class Exer7 {
    public static void main(String[] args) {
        int a = 5;
        int[] arr = {1,2,3};
        Exer7 exer = new Exer7();
        exer.change(a);
        System.out.println(a);//5
        exer.change(arr);
        System.out.println(Arrays.toString(arr));//[8, 2, 3]
    }

    public void change(int c){
        c = 4;
    }

    public void change(int[] a){
        a[0] = 8;
    }
}
