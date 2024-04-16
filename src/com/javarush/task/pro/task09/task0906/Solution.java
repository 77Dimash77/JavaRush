package com.javarush.task.pro.task09.task0906;

import java.util.regex.Pattern;

/* 
Двоичный конвертер
*/

public class Solution {
    public static void main(String[] args) {
        int decimalNumber = Integer.MAX_VALUE;
        System.out.println("Десятичное число " + decimalNumber + " равно двоичному числу " + toBinary(decimalNumber));
        String binaryNumber = "1111111111111111111111111111111";
        System.out.println("Двоичное число " + binaryNumber + " равно десятичному числу " + toDecimal(binaryNumber));
    }

    public static String toBinary(int decimalNumber) {
        if (decimalNumber <= 0) {
            return "";
        }

        StringBuilder binaryStringBuilder = new StringBuilder();

        while (decimalNumber > 0) {
            int remainder = decimalNumber % 2;
            binaryStringBuilder.insert(0, remainder);
            decimalNumber /= 2;
        }

        return binaryStringBuilder.toString();
    }

    public static int toDecimal(String binaryNumber) {
        if (binaryNumber == null || binaryNumber.isEmpty()) {
            return 0;
        }

        int decimal = 0;
        int power = 0;

        for (int i = binaryNumber.length() - 1; i >= 0; i--) {
            char digitChar = binaryNumber.charAt(i);

            if (digitChar == '1') {
                decimal += Math.pow(2, power);
            } else if (digitChar != '0') {
                // Некорректный символ в строке, возвращаем 0
                return 0;
            }

            power++;
        }

        return decimal;
    }
}