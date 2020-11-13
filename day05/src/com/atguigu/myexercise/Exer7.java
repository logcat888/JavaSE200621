package com.atguigu.myexercise;


import java.util.Arrays;

public class Exer7 {
    public static void main(String[] args) {
        int[] arr2,arr1 = {2,3,5,7,11,13,17,19};
        arr2 = new int[8];
        for(int i = 0; i < arr1.length;i++){
            System.out.print(arr1[i] + " ");
            arr2[i] = arr1[i];
        }
        System.out.println();

        for (int i = 0; i < arr2.length; i++) {
            if(i % 2 == 0){
                arr2[i] = i;
            }
        }
        System.out.println("arr1为：" + Arrays.toString(arr1));
        System.out.println("arr2为：" + Arrays.toString(arr2));

    }
}
