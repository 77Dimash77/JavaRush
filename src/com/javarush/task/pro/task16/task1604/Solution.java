package com.javarush.task.pro.task16.task1604;

import java.util.Calendar;
import java.util.GregorianCalendar;

/* 
День недели рождения твоего
*/

public class Solution {

    static Calendar birthDate = new GregorianCalendar(1992, 8,2);

    public static void main(String[] args) {
        System.out.println(getDayOfWeek(birthDate));
    }

    static String getDayOfWeek(Calendar calendar) {
        //напишите тут ваш код
        String b = null;
        int a = calendar.get(Calendar.DAY_OF_WEEK);
        switch (a) {
            case 1: b = "воскресенье";break;
            case 2: b = "понедельник";break;
            case 3: b = "вторник";break;
            case 4: b = "среда";break;
            case 5: b = "четверг";break;
            case 6: b = "пятница";break;
            case 7: b = "суббота";break;

        }
        return b;
    }
}
