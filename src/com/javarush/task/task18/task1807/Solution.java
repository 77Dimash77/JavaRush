package com.javarush.task.task18.task1807;

import java.io.*;
import java.util.Scanner;

/* 
Подсчет запятых
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        FileInputStream fileInputStream = new FileInputStream(new Scanner(System.in).nextLine());
        int count = 0;
        while (fileInputStream.available()>0){
            int a = fileInputStream.read();
            if(a == 44){
                count++;
            }
        }
        System.out.println(count);
        fileInputStream.close();
    }
}
