package com.javarush.task.pro.task04.task0402;

import java.util.Scanner;

/* 
Все любят Мамбу
*/

public class Solution {
    public static void main(String[] args) {
        String text = " любит меня.";
        //напишите тут ваш код
        Scanner a = new Scanner(System.in);
        String name = a.nextLine();
        int result = 0;
        while (result<10){
            System.out.println(name + text);
            result++;
        }
    }
}
