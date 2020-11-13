package com.atguigu.homework;

import java.util.Scanner;

public class Exer4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("请输入年：");
        int year = scan.nextInt();
        System.out.print("请输入月：");
        int month = scan.nextInt();
        System.out.print("请输入日：");
        int day = scan.nextInt();
        int sumdays = day;
        for(int k = 0; k <=year - 2000; k++){
            if(k == (year - 2000)){//计算year年的天数
                for(int i = 1; i < month;i++){
                    if(i == 1 | i == 3 | i == 5 | i == 7| i == 8| i == 10){
                        sumdays += 31;
                    }else if(i == 4 | i == 6 | i == 9 | i == 11){
                        sumdays += 30;
                    }else{
                        if( (year % 4 == 0 && year % 100 != 0) || (year % 400 ==0)){
                            sumdays += 29;
                        }else{
                            sumdays += 28;
                        }
                    }
                }
            }else{//计算[2000，year-1]的天数
                if( (year % 4 == 0 && year % 100 != 0) || (year % 400 ==0) ){
                    sumdays += 366;
                }else{
                    sumdays += 365;
                }
            }
        }
        switch (sumdays % 5){
            case 1:
            case 2:
            case 3:
                System.out.println("今天打鱼");
                break;
            case 4:
            case 0:
                System.out.println("今天晒网");
                break;
        }
    }

}
