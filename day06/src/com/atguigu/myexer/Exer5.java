package com.atguigu.myexer;
/*
使用线性查找，从上述数组中查找22是否存在。存在，返回所在位置的索引。不存在，输出提示信息。
 int[] arr = new int[]{34,5,22,-98,6,-76,0,-3};
 */
public class Exer5 {
    public static void main(String[] args) {
        int[] arr = new int[]{34,5,22,-98,6,-76,0,-3,22};
        int count = 0;//记录待查元素出现的次数
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 22){
                count++;
                System.out.println("第" + count + "次出现待查元素的索引为" + i);
            }
        }
        if(count == 0)
            System.out.println("未找到待查元素");

    }
}
