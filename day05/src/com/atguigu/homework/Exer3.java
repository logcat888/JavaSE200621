package com.atguigu.homework;

public class Exer3 {
    public static void main(String[] args) {
        for(int i= 2;i <= 1000;i++){
            int sum = 1;
            for(int j = 2;j <= Math.sqrt(i);j++){
                if(i % j == 0){
                    sum += (j + i / j);
                }
            }
            if(sum == i){
                System.out.println(i);
            }
        }
    }
}
