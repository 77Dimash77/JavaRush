package com.javarush.task.task18.task1816;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* 
Английские буквы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        int counter = 0;
        BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));
        while (bufferedReader.ready()){
            int letter = bufferedReader.read();
            if (letter>64 && letter<=90 || letter>96 && letter<=122) counter++;
        }
        System.out.println(counter);
        bufferedReader.close();
    }
}
