package com.atguigu.myexer;

import java.util.Arrays;

/*
1. 复制如下数组
 int[] arr = new int[]{34,5,22,-98,6,-76,0,-3};
 */
public class Exer4 {
    public static void main(String[] args) {
        int[] arr = new int[]{34,5,22,-98,6,-76,0,-3};
        int[] arr1 = new int[arr.length];
        for(int i = 0;i < arr.length;i++){
            arr1[i] = arr[i];
        }
        System.out.println(Arrays.toString(arr1));
    }
}
