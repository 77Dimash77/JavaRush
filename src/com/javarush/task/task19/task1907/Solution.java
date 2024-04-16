package com.javarush.task.task19.task1907;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Считаем слово
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String file = bufferedReader.readLine();
        String a = "";
        FileReader fileReader = new FileReader(file);
        while (fileReader.ready()){
            int c = fileReader.read();
            a = a + (char)c;

        }
        fileReader.close();
        bufferedReader.close();
        int count = 0;
        String[]text = a.split("\\p{P}|\\s");
 for (String str: text){
     if(str.trim().equalsIgnoreCase("world")){
         count++;
     }
 }
        System.out.println(count);
    }
}
