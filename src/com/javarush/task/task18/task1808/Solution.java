package com.javarush.task.task18.task1808;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/* 
Разделение файла
*/

public class Solution {
    public static void main(String[] args) throws Exception{
        FileInputStream fileInputStream1 = new FileInputStream(new Scanner(System.in).nextLine());
        FileOutputStream fileOutputStream2 = new FileOutputStream(new Scanner(System.in).nextLine());
        FileOutputStream fileOutputStream3 = new FileOutputStream(new Scanner(System.in).nextLine());
        int fileSize = fileInputStream1.available();
        int halfSize = (fileSize + 1) / 2; // Если размер нечетный, то большую часть отдаем в первый файл

        for (int i = 0; i < fileSize; i++) {
            int b = fileInputStream1.read();
            if (i < halfSize) {
                fileOutputStream2.write(b);
            } else {
                fileOutputStream3.write(b);
            }
        }
        fileOutputStream2.close();
        fileInputStream1.close();
        fileOutputStream3.close();
    }

}
