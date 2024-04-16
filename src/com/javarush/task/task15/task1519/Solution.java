package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напиште тут ваш код
        Scanner scanner = new Scanner(System.in);
        boolean isExit = false;
        while (!isExit){
            String word = scanner.nextLine();
            if(word.equals("exit")){
                isExit = true;
            } else {
                boolean Doublee = isDouble(word);
                boolean Shortt = isShort(word);
                boolean Int = isInt(word);
                if(Doublee){
                    print(Double.parseDouble(word));
                } else if (Shortt) {
                    print(Short.parseShort(word));
                } else if (Int) {
                    print(Integer.parseInt(word));
                } else {
                    print(word);
                }

            }
        }
    }
  static   boolean isDouble(String str) {
        if(str.contains(".")){
            try {
                Double.parseDouble(str);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        }else {
            return false;
        }

    }
    static boolean isShort(String str){
        if(!str.contains(".")){
            try {
              int a =  Integer.parseInt(str);
                if(a > 0 && a< 128){
                    return true;
                } else return false;
            } catch (Exception e){
                return false;
            }

        } else return false;

    }
    static boolean isInt(String str){
        if(!str.contains(".")){
            try {
                int a =  Integer.parseInt(str);
                if(a<= 0 || a>= 128){
                    return true;
                } else return false;
            }catch (Exception e){
                return false;
            }
        } else return false;
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
