package com.javarush.task.task18.task1819;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/* 
Объединение файлов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        reader.close();

        FileInputStream fileInputStream1 = new FileInputStream(fileName1);
        FileInputStream fileInputStream2 = new FileInputStream(fileName2);

        ArrayList<Integer> list = new ArrayList<>();

        while (fileInputStream2.available()>0){
            list.add(fileInputStream2.read());
        }
        while (fileInputStream1.available()>0){
            list.add(fileInputStream1.read());
        }
        FileOutputStream fileOutputStream1 = new FileOutputStream(fileName1);
for (int x: list){
    fileOutputStream1.write(x);
}
fileInputStream1.close();
fileInputStream2.close();
fileOutputStream1.close();


    }
}
