package com.javarush.task.pro.task16.task1607;

import java.time.LocalDate;

/* 
Освоение нового API
*/

public class Solution {

    public static void main(String[] args) {
        System.out.println(nowExample());
        System.out.println(ofExample());
        System.out.println(ofYearDayExample());
        System.out.println(ofEpochDayExample());
    }

    static LocalDate nowExample() {
        //напишите тут ваш код
        LocalDate localDate = LocalDate.now();

        return localDate;
    }

    static LocalDate ofExample() {
        //напишите тут ваш код
        LocalDate localDate = LocalDate.of(2020,9,12);

        return localDate;
    }

    static LocalDate ofYearDayExample() {
        //напишите тут ваш код
        LocalDate localDate = LocalDate.ofYearDay(2020,282-8-18);

        return localDate;
    }

    static LocalDate ofEpochDayExample() {
        //напишите тут ваш код
        LocalDate localDate = LocalDate.ofEpochDay(12000+7000-700+210+7);
        return localDate;
    }
}
