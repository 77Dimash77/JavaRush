package com.javarush.task.task19.task1910;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Pattern;

/* 
Пунктуация
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader = new BufferedReader(new FileReader(bufferedReader.readLine()));
        BufferedWriter writer = new BufferedWriter(new FileWriter(bufferedReader.readLine()));

        while (reader.ready()){
            int a = reader.read();
            if(!String.valueOf((char)a ).matches("\\p{Punct}")){
                writer.write(a);
            }
        }
    bufferedReader.close();
        reader.close();
        writer.close();
    }
}
