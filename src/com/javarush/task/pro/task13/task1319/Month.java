package com.javarush.task.pro.task13.task1319;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;/*
Месяцы в сезоне
*/





public enum Month {
    JANUARY,
    FEBRUARY,
    MARCH,
    APRIL,
    MAY,
    JUNE,
    JULY,
    AUGUST,
    SEPTEMBER,
    OCTOBER,
    NOVEMBER,
    DECEMBER;

    //напишите тут ваш код
   public List<Month> asList(){
        ArrayList<Month> list = new ArrayList<Month>();
        Collections.addAll(list,Month.values());
        return list;
}
    public static Month[] getWinterMonths(){
        Month[] array = {Month.values()[0],Month.values()[1],Month.values()[11]};
        return array;
    }
    public static Month[]  getSpringMonths(){
        Month[] array = {Month.values()[2],Month.values()[3],Month.values()[4]};
        return array;
    }
    public static Month[] getSummerMonths(){
        Month[] array = {Month.values()[5],Month.values()[6],Month.values()[7]};
        return array;
    }
    public static Month[]  getAutumnMonths(){
        Month[] array = {Month.values()[8],Month.values()[9],Month.values()[10]};
        return array;
    }
}
