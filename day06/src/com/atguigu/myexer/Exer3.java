package com.atguigu.myexer;

import java.util.Arrays;

/*
1. 反转如下数组
 int[] arr = new int[]{34,5,22,-98,6,-76,0,-3};
 */
public class Exer3 {
    public static void main(String[] args) {
        int[] arr = new int[]{34,5,22,-98,6,-76,0,-3};
        System.out.println(Arrays.toString(arr));
/*        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 -i];
            arr[arr.length - 1 -i] = temp;
        }*/

        for (int x = 0,y = arr.length - 1; x < y; x++,y--) {
            int temp = arr[x];
            arr[x] = arr[y];
            arr[y] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }
}
