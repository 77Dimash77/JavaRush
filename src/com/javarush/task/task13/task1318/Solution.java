package com.javarush.task.task13.task1318;

import java.io.*;
import java.util.Scanner;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String fileName = reader.readLine();

            try (InputStreamReader fileReader = new InputStreamReader(new FileInputStream(fileName))) {
                BufferedReader fileBufferedReader = new BufferedReader(fileReader);

                while (fileBufferedReader.ready()) {
                    String line = fileBufferedReader.readLine();
                    System.out.println(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}