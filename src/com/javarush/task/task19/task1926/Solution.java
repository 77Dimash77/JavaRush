package com.javarush.task.task19.task1926;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Перевертыши
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileReader = new FileReader(bufferedReader.readLine());
        BufferedReader bufferedReader1 = new BufferedReader(fileReader);
        StringBuilder stringBuilder = new StringBuilder();
        while (bufferedReader1.ready()){
            String a = bufferedReader1.readLine();
            stringBuilder.append(a);
            stringBuilder.reverse();
            System.out.println(stringBuilder.toString());
            stringBuilder.delete(0,stringBuilder.length());
        }
        bufferedReader.close();
        bufferedReader1.close();
        fileReader.close();
    }
}
