package com.javarush.task.task39.task3903;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Неравноценный обмен
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Please enter a number: ");

        long number = Long.parseLong(reader.readLine());
        System.out.println("Please enter the first index: ");
        int i = Integer.parseInt(reader.readLine());
        System.out.println("Please enter the second index: ");
        int j = Integer.parseInt(reader.readLine());

        System.out.println("The result of swapping bits is " + swapBits(number, i, j));
    }

    public static long swapBits(long number, int i, int j) {
        // Проверяем, что i и j находятся в пределах длины числа
        if (i < 0 || i >= 64 || j < 0 || j >= 64) {
            throw new IllegalArgumentException("Invalid bit index");
        }

        // Получаем значения битов с индексами i и j
        long bitI = (number >> i) & 1;
        long bitJ = (number >> j) & 1;

        // Если значения битов различны, меняем их местами
        if (bitI != bitJ) {
            long maskI = 1L << i; // Создаем маску для бита с индексом i
            long maskJ = 1L << j; // Создаем маску для бита с индексом j
            // Меняем местами биты с помощью операции XOR
            number ^= (maskI | maskJ);
        }

        // Возвращаем измененное число
        return number;
    }
}