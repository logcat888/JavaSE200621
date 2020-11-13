package com.atguigu.java1;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{3,1,4,5,2,6,8,7,9};
        System.out.println(Arrays.toString(arr));

        quickSortVersion2(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSortVersion2(int[] array){
        subSort(array, 0, array.length - 1);
    }

    public static void subSort(int[] array, int low, int high){
        if(low < high){
            int pivot =array[low];
            int i = low + 1;
            int j = low + 1;

            while (j <= high){
                if(array[j] < pivot){
                    swap(array, i, j);
                    i++;
                }
                j++;
            }
            swap(array, low, i -1);
            subSort(array,low, i -2);
            subSort(array, i, high);

        }
    }
    public static void swap(int[] array, int left, int right){
        int temp = array[left];
        array[left ] = array[right];
        array[right]= temp;
    }
}
