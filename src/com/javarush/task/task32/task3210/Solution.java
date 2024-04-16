package com.javarush.task.task32.task3210;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) throws IOException {
        String fileName = args[0];
        int number = Integer.parseInt(args[1]);
        String text = args[2];


        RandomAccessFile raf = new RandomAccessFile(fileName, "rw");
        int lengthOfTextIn3rdParameter = text.length();
        byte[] fileContent = new byte[lengthOfTextIn3rdParameter];

        // устанавливаем курсор в нужное место в файле
        raf.seek(number);
        // читаем нужное нам количество байт
        raf.read(fileContent, 0, lengthOfTextIn3rdParameter);
        String textFromByteArray = convertByteToString(fileContent);
        if (textFromByteArray.equals(text)) {
            raf.seek(raf.length());
            raf.write("true".getBytes()); // пишем байты а не string
        } else {
            raf.seek(raf.length());
            raf.write("false".getBytes()); // // пишем байты а не string
        }
    }

    public static String convertByteToString (byte readBytes[]) {
        return new String(readBytes);
    }

    
}
