package com.javarush.task.task19.task1922;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        String file1 = buff.readLine();
        buff.close();
        FileReader fileReader = new FileReader(file1);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        while (bufferedReader.ready()){
          String string =  bufferedReader.readLine();
          String[]masstr = string.split(" ");
          int count = 0;
          for (String w: words){
              for (String s: masstr){
                  if(w.equals(s)){
                      count++;
                  }
              }
          }
          if (count == 2){
              System.out.println(string);
          }
        }



        fileReader.close();
    }
}
