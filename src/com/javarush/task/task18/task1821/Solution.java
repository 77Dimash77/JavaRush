package com.javarush.task.task18.task1821;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

/* 
Встречаемость символов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            System.out.println("Usage: java Solution <filename>");
            return;
        }

        FileInputStream fileInputStream = new FileInputStream(args[0]);
        byte[] buffer = new byte[fileInputStream.available()];
        fileInputStream.read(buffer);
        fileInputStream.close();

        TreeMap<Byte, Integer> frequencyMap = new TreeMap<>();

        for (byte b : buffer) {
            frequencyMap.put(b, frequencyMap.getOrDefault(b, 0) + 1);
        }

        // Выводим результат отсортированным по ASCII
        for (Map.Entry<Byte, Integer> entry : frequencyMap.entrySet()) {
            byte symbol = entry.getKey();
            int frequency = entry.getValue();
            System.out.println((char) symbol + " " + frequency);
        }
    }
}