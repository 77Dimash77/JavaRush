package com.javarush.task.pro.task16.task1601;

import java.util.Calendar;
import java.util.Date;

/* 
Лишь бы не в понедельник :)
*/

public class Solution {

    static Date birthDate = new Date(105, 02, 02);

    public static void main(String[] args) {
        System.out.println(getDayOfWeek(birthDate));
    }

    static String getDayOfWeek(Date date) {
        //напишите тут ваш код
        int a = date.getDay();
        String b = null;
        switch (a) {
            case 0: b = "воскресенье";break;
            case 1: b = "понедельник";break;
            case 2: b = "вторник";break;
            case 3: b = "среда";break;
            case 4: b = "четверг";break;
            case 5: b = "пятница";break;
            case 6: b = "суббота";break;

        }
        return b;
    }
}
