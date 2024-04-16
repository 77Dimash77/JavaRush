package com.javarush.task.task19.task1925;

import java.io.*;
import java.util.ArrayList;

/* 
Длинные слова
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(args[0]));
        BufferedWriter out = new BufferedWriter(new FileWriter(args[1]));
        StringBuilder sb = new StringBuilder();
        while (in.ready()) {
            String line = in.readLine();
            String[] words = line.split(" ");
            for (String word : words) {
                if (word.length() > 6)
                    sb.append(word + ",");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        out.write(sb.toString());
        in.close();
        out.close();
    }
}

