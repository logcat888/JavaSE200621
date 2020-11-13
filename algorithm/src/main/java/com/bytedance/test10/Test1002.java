package com.bytedance.test10;

import java.util.ArrayList;

/**
 * @author chenhuiup
 * @create 2020-10-14 13:43
 */
public class Test1002 {
    public static void main(String[] args) {
        String[] str = {"hello","hcall","hel"};
        System.out.println(show(str));
    }

    public static ArrayList<String> show(String[] arr){
        int[][] chars = new int[arr.length][26];
        for (int i = 0; i < arr.length; i++) {
            char[] charArray = arr[i].toCharArray();
            for (char c : charArray) {
                chars[i][c-97]++;
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            boolean flag = true;
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < chars.length; j++) {
                if (chars[j][i] == 0){
                    flag=false;
                    break;
                }
                if (chars[j][i] < min){
                    min = chars[j][i];
                }
            }
            if (flag){
                for (int j = 0; j < min; j++) {
                    builder.append((char)(i+97));
                }
            }
        }
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < builder.length(); i++) {
            list.add(builder.charAt(i) + "");
        }
        return list;
    }
}
