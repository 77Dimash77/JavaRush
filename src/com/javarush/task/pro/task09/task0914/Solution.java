package com.javarush.task.pro.task09.task0914;

/* 
Обновление пути
*/

public class Solution {
    public static void main(String[] args) {
        String path = "/usr/java/jdk1.8/bin/";

        String jdk13 = "jdk-13";
        System.out.println(changePath(path, jdk13));
    }

    public static String changePath(String path, String jdk) {
        //напишите тут ваш код
        int startIndex = path.indexOf("jdk");
        if (startIndex == -1) {
            return path; // Если версия jdk не найдена, возвращаем исходный путь
        }

        // Находим конец версии jdk
        int endIndex = path.indexOf("/", startIndex);
        if (endIndex == -1) {
            endIndex = path.length(); // Если конец версии jdk не найден, берем конец строки
        }

        // Формируем новый путь, заменяя версию jdk на новую
        String prefix = path.substring(0, startIndex); // Часть пути до версии jdk
        String suffix = path.substring(endIndex); // Часть пути после версии jdk
        return prefix + jdk + suffix;
}}
