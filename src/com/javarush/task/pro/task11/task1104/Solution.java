package com.javarush.task.pro.task11.task1104;

/* 
Конвертер строки
*/

import com.javarush.task.pro.task10.task1014.Market;

public class Solution {
    public static void main(String[] args) {
        String string = "12.84";
        double a = Double.parseDouble(string);
        a = Math.round(a);
        System.out.println(a);
        //напишите тут ваш код
    }
}
