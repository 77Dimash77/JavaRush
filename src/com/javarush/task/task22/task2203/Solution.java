package com.javarush.task.task22.task2203;

/* 
Между табуляциями
*/

public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        try {
            int one = string.indexOf("\t");
            int two = string.indexOf("\t", one + 1);
            String result = string.substring(one+1,two );
            return result;
        } catch (Exception e){
            throw new TooShortStringException();
        }



    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
    }
}
