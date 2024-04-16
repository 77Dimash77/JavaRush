package com.javarush.task.pro.task05.task0507;

import java.util.Scanner;

/* 
Максимальное из N чисел
*/

public class Solution {
    public static int[] array;

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner a = new Scanner(System.in);
        int N = a.nextInt();
        array = new int[N];
        int max;
        for (int i = 0; i <array.length; i++) {
            int a1 = a.nextInt();
            array[i] = a1;
        }
        max = array[0];
        for (int i = 0; i < array.length; i++) {
            if(max < array[i]){
                max = array[i];
            }
        }
        System.out.println(max);
    }
}
