package com.javarush.task.task31.task3105;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Добавление файла в архив
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Path filePath = Paths.get(args[0]);
        Path zipFilePath = Paths.get(args[1]);
        Path fileToAddPath = Paths.get("new").resolve(filePath.getFileName());

        Path temp = Files.createTempFile(null, ".zip");

        try (ZipOutputStream outputStream = new ZipOutputStream(Files.newOutputStream(temp));
             ZipInputStream inputStream = new ZipInputStream(Files.newInputStream(zipFilePath))) {

            ZipEntry entry;
            while ((entry = inputStream.getNextEntry()) != null) {
                if (!entry.getName().equals(fileToAddPath.toString())) {
                    outputStream.putNextEntry(new ZipEntry(entry.getName()));

                    byte[] buff = new byte[8 * 1024];
                    int len;

                    while ((len = inputStream.read(buff)) > 0) {
                        outputStream.write(buff, 0, len);
                    }

                    outputStream.closeEntry();
                }
            }

            // Добавляем новый файл в архив
            ZipEntry newEntry = new ZipEntry(fileToAddPath.toString());
            outputStream.putNextEntry(newEntry);
            Files.copy(filePath, outputStream);

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Удаление временного файла
        temp.toFile().deleteOnExit();

        // Замена исходного архива новым файлом
        Files.move(temp, zipFilePath, StandardCopyOption.REPLACE_EXISTING);
    }
}