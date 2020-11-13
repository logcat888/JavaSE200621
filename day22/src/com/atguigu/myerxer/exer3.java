package com.atguigu.myerxer;

/**
 * @author chenhuiup
 * @create 2020-07-23 上午 8:56
 */
//给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。

public class exer3 {

    public static int missingPositiveNumber(int[] num){

        return 0;
    }

    public static void main(String[] args){
        int[] num = new int[args.length];
        for (int i = 0; i < args.length; i++) {
            num[i] = Integer.parseInt(args[i]);
        }
        int i = missingPositiveNumber(num);
        System.out.println(i);
    }
}
