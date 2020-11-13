package com.atguigu.myexercise;
import java.util.Arrays;
public class Exer6 {
    public static void main(String[] args) {
        int[] array = new int[10];
        //获取10个随机数
        for (int i = 0; i < array.length; i++) {
            array[i] = (int)(Math.random()*90+10);
        }
        System.out.println(Arrays.toString(array));
        System.out.println("最大值为：" + new Array().maxNumber(array));
        System.out.println("最小值为：" + new Array().minNumber(array));
        System.out.println("和值为：" + new Array().sum(array));
        System.out.println("平均值为：" + new Array().avg(array));
    }
}

class Array{
   private int[] array;

   //获取int型数组的最大值
    public int maxNumber(int[] array){
        this.array = array;
        int maxNumber = this.array[0];
        for (int i = 1; i < this.array.length; i++) {
            maxNumber = (maxNumber > this.array[i])? maxNumber : this.array[i];
        }
        return maxNumber;
    }

    //获取int型数组的最小值
    public int minNumber(int[] array){
        this.array = array;
        int minNumber = this.array[0];
        for (int i = 1; i < this.array.length; i++) {
            minNumber = (minNumber < this.array[i])? minNumber : this.array[i];
        }
        return minNumber;
    }

    //获取int型数组的和值
    public int sum(int[] array){
        this.array = array;
        int sum = this.array[0];
        for (int i = 1; i < this.array.length; i++) {
            sum += this.array[i];
        }
        return sum;
    }

    //获取int型数组的平均值
    public int avg(int[] array){
        this.array = array;
        return sum(this.array)/this.array.length;
    }
}
