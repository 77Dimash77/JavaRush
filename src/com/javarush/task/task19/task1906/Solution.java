package com.javarush.task.task19.task1906;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/* 
Четные символы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileReader = new FileReader(bufferedReader.readLine());
        FileWriter fileWriter = new FileWriter(new Scanner(System.in).nextLine());
       ArrayList<Integer> characters = new ArrayList<>();
        int counter = 0;
        while (fileReader.ready()) {
            int symbol = fileReader.read();
            counter++;
            if (counter % 2 == 0) {
                fileWriter.write(symbol);
            }
        }



        fileReader.close();
        bufferedReader.close();
        fileWriter.close();



    }
}
