package com.javarush.task.pro.task15.task1506;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

/* 
Фейсконтроль
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
            Path pathinp = Paths.get(input);
            try {
                List<String> list =  Files.readAllLines(pathinp);
                StringBuilder a = new StringBuilder();
                for (String s: list){
                    a.append(s);
                }
                String string = a.toString();
                char[] chars = string.toCharArray();

                for (int i = 0; i < chars.length; i++) {

                        if(chars[i] == ' '){
                            continue;
                        } else if (chars[i] == '.') {
                            continue;
                        } else if (chars[i] == ',') {
                            continue;
                        } else {
                            System.out.print(chars[i]);
                        }
                    }








            } catch (Exception e){
                e.printStackTrace();
            }





    }
}

