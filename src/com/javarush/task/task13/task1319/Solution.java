package com.javarush.task.task13.task1319;

import java.io.*;
import java.util.Scanner;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            String input;
            do {
                input = scanner.nextLine();
                writer.write(input);
                writer.newLine();
            } while (!input.equals("exit"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}





