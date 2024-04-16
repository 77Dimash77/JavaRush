package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        FileInputStream fileInputStream = new FileInputStream(new Scanner(System.in).nextLine());
        int a = Integer.MAX_VALUE;
        while (fileInputStream.available()>0){
            int b = fileInputStream.read();
            if(b<a){
                a = b;
            }

        }
        System.out.println(a);
        fileInputStream.close();
    }
}
