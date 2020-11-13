package com.atguigu.java1;

/**
 * 工具类 : 所有方法都是工具方法, 工具方法就是静态方法.
 */
public class ComparableUtil {

    public static void sort(Comparable... arr) {
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

    public static void select(Comparable... arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            // 以i位置为基准位置, 目标是继续找出包括基准位置在内到后面所有数据中的最小值的下标.
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            // 交换基准位置和minIndex位置
            Comparable tmp = arr[i];
            arr[i] = arr[minIndex]; // 最重要的语句, 作用是让最小值归位
            arr[minIndex] = tmp;
        }
    }

    public static Comparable max(Comparable... arr) {
        Comparable max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i].compareTo(max) > 0) {
                max = arr[i];
            }
        }
        return max;
    }

    public static Comparable min(Comparable... arr) {
        Comparable min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i].compareTo(min) < 0) {
                min = arr[i];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        System.out.println(max(3, 5, 2, 1, 9, 8)); //
        System.out.println(min(9, 2 , 10)); // min(new Comparable[]{9, 2, 10});
        Integer[] arr = {3, 5, 2, 1, 9, 8};
        select(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        System.out.println(min(arr));
    }

}
