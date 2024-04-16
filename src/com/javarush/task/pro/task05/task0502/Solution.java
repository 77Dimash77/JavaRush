package com.javarush.task.pro.task05.task0502;

/* 
Четные и нечетные ячейки массива
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static final String ODD = "Нечётный";
    public static final String EVEN = "Чётный";
    public static String[] strings = new String[5];

    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        FileOutputStream fileOutputStream1 = new FileOutputStream(new Scanner(System.in).nextLine());
        FileInputStream fileInputStream2 = new FileInputStream(new Scanner(System.in).nextLine());
        FileInputStream fileInputStream3 = new FileInputStream(new Scanner(System.in).nextLine());
        {
            while (fileInputStream2.available()>0){
                int a = fileInputStream2.read();
                fileOutputStream1.write(a);
            }
            while (fileInputStream3.available()>0){
                int a = fileInputStream3.read();
                fileOutputStream1.write(a);
            }




        for (int i = 0; i < strings.length; i++) {
            if(i%2 == 0){
                strings[i] = EVEN;
            } else {
                strings[i] = ODD;
            }
        }


        System.out.print("index = 0");
        System.out.println(" value = " + strings[0]);
        System.out.print("index = 1");
        System.out.println(" value = " + strings[1]);
        System.out.print("index = 2");
        System.out.println(" value = " + strings[2]);
        System.out.print("index = 3");
        System.out.println(" value = " + strings[3]);
        System.out.print("index = 4");
        System.out.println(" value = " + strings[4]);
    }
}
    }
