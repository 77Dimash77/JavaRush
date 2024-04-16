package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.*;

/*
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        List<String> fileNames = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter file names (type 'end' to finish):");
        String fileName = scanner.nextLine();

        while (!fileName.equals("end")) {
            fileNames.add(fileName);
            fileName = scanner.nextLine();
        }

        if (fileNames.size() < 1) {
            System.out.println("Please provide at least one file name.");
            return;
        }

        // Сортировка имен файлов
        Collections.sort(fileNames);

        // Создание выходного файла
        String outputFileName = fileNames.get(0).replaceFirst("\\.part\\d+$", "");
        try (FileOutputStream outputStream = new FileOutputStream(outputFileName)) {
            // Запись содержимого каждого файла-части в выходной файл
            for (String partFileName : fileNames) {
                try (FileInputStream inputStream = new FileInputStream(partFileName)) {
                    byte[] buffer = new byte[1024];
                    int bytesRead;

                    while ((bytesRead = inputStream.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, bytesRead);
                    }
                }
            }

            System.out.println("Files merged successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}