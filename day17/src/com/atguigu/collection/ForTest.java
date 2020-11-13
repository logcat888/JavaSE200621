package com.atguigu.collection;

public class ForTest {

    public static void main(String[] args) {
        int[] arr = new int[8];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * 20);
        }
        // 遍历
        for (int i = 0; i < arr.length; i++) {
            int tmp = arr[i];
            //tmp *= 10;
            System.out.print(tmp + " ");
        }
        System.out.println();

        for (int i = 0; i < arr.length; i++) {
            int tmp = arr[i];
            System.out.print(tmp + " ");
        }
        System.out.println();

        /////////////////////////////////////////////////////
        // 遍历, 增强for, 为了遍历数组更安全, 更简单.
        /*
        for (元素数据类型 临时变量 : 数组名) {
            访问临时变量;
        }*/
        for (int tmp : arr) {
            //tmp *= 10;
            System.out.print(tmp + " ");
        }
        System.out.println();

        char[] arr2 = {'a', '2', '5'};
        for (char ch : arr2) {
            System.out.println(ch);
        }
    }
}
