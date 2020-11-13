package com.atguigu.myexercise;

import java.util.Scanner;

public class Exer4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入杨辉三角的行数:");
        int number =scan.nextInt();
        int[][] arr = new int[number][];
        //杨辉三角赋值，并打印
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new int[i + 1];
            for (int j = 0; j < arr[i].length; j++) {
                if(j == 0 || j == i){
                    arr[i][j] = 1;
                }else {
                    arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
                }
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
