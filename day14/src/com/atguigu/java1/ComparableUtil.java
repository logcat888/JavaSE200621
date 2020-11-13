package com.atguigu.java1;

public class ComparableUtil {

    public static void sort(Comparable[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    Comparable tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }

    public static void select(Comparable[] arr) {

    }

    public static Comparable max(Comparable[] arr) {
        return null;
    }

    public static Comparable min(Comparable[] arr) {
        return null;
    }

}
