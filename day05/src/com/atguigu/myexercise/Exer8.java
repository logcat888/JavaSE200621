package com.atguigu.myexercise;

public class Exer8 {
    public static void main(String[] args) {
        int[] number = new int[]{95,92,75,56,98,71,80,58,91,91};

        System.out.println("高于平均数： " + new Exer8().arrayAvg(number) + " 的 个数有" + new Exer8().highAvg(number) + "个");
    }

    public int arrayAvg(int[] array){
        int sum = array[0];
        for (int i = 1; i < array.length; i++) {
            sum += array[i];
        }
        return sum/array.length;
    }

    public int highAvg(int[] array){
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > arrayAvg(array)){
                count++;
            }
        }
        return count;
    }
}
