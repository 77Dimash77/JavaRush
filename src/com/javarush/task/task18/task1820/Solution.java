package com.javarush.task.task18.task1820;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/* 
Округление чисел
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();

        try (BufferedReader fileReader1 = new BufferedReader(new FileReader(file1));
             BufferedWriter fileWriter2 = new BufferedWriter(new FileWriter(file2))) {

            String line;
            while ((line = fileReader1.readLine()) != null) {
                String[] numbers = line.split(" ");
                for (String number : numbers) {
                    double doubleValue = Double.parseDouble(number);
                    int roundedValue = (int) Math.round(doubleValue);
                    fileWriter2.write(roundedValue + " ");
                }
            }
        }
    }
}