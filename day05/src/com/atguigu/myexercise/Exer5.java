package com.atguigu.myexercise;

public class Exer5 {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,2,3},{4,5},{6,7}};
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.println(arr[i][j]);
            }
        }
    }
}
