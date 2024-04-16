package com.javarush.task.pro.task05.task0505;

import java.util.Scanner;

/* 
Reverse
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Scanner a = new Scanner(System.in);
        int a1 = a.nextInt();
        int[]a3;
        if(a1>0){
            a3 = new int[a1];
            for (int i = 0; i < a1; i++) {
                int a2 = a.nextInt();
                a3[i] = a2;
            }
            if((a1 %2) ==0){
                for (int i = a3.length - 1; i>= 0; i--) {
                    System.out.println(a3[i]);
                }
            } else {
                for (int i = 0; i < a3.length; i++) {
                    System.out.println(a3[i]);
                }
            }


        }
    }
}
