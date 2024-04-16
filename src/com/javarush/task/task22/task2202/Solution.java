package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) {
        try {
            String[]a = string.split(" ");
            String b = "";
            for (int i = 1; i < 5 ; i++) {
                b = b + " " + a[i];
            }
            return  b.trim();
        } catch (Exception e){
            throw  new TooShortStringException();
        }
    }


    public static class TooShortStringException extends RuntimeException {
    }
}
