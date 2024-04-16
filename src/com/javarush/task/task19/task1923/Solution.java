package com.javarush.task.task19.task1923;

import java.io.*;

/* 
Слова с цифрами
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        FileReader fileReader1 = new FileReader(args[0]);
        FileWriter fileWriter1 = new FileWriter(args[1]);
        BufferedReader bufferedReader = new BufferedReader(fileReader1);
        while (bufferedReader.ready()){
            String a = bufferedReader.readLine();
            String[]string = a.split(" ");
            for (int i = 0; i < string.length; i++) {
                if (string[i].matches(".*\\d.*")){
                    fileWriter1.write(string[i] + " ");
                }
            }
        }
        fileWriter1.close();
        fileReader1.close();

    }
}
