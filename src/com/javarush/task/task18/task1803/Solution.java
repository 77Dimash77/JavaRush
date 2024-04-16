package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* 
Самые частые байты
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        FileInputStream fileInputStream = new FileInputStream(new Scanner(System.in).nextLine());
        HashMap<Byte,Integer> map = new HashMap<>();
        while (fileInputStream.available() > 0) {
            byte b = (byte) fileInputStream.read();

            // Проверяем, есть ли байт в HashMap
            if (!map.containsKey(b)) {
                // Если байт не найден, добавляем его в HashMap с начальным значением 1
                map.put(b, 1);
            } else {
                // Если байт найден, увеличиваем количество повторений
                map.put(b, map.get(b) + 1);
            }
        }

        fileInputStream.close();

        // Находим байты с максимальным количеством повторений
        int maxCount = 0;
        for (int count : map.values()) {
            if (count > maxCount) {
                maxCount = count;
            }
        }

        // Выводим байты с максимальным количеством повторений
        for (Map.Entry<Byte, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxCount) {
                System.out.print(entry.getKey() + " ");
            }
        }
    }
}