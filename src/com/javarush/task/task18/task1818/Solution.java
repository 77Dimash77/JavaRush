package com.javarush.task.task18.task1818;

import java.io.*;
import java.util.Scanner;

/* 
Два в одном
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        FileOutputStream fileOutputStream1 = new FileOutputStream(new Scanner(System.in).nextLine());
        FileInputStream fileInputStream2 = new FileInputStream(new Scanner(System.in).nextLine());
        FileInputStream fileInputStream3 = new FileInputStream(new Scanner(System.in).nextLine());

            while (fileInputStream2.available() > 0) {
                int a = fileInputStream2.read();
                fileOutputStream1.write(a);
            }
            while (fileInputStream3.available() > 0) {
                int a = fileInputStream3.read();
                fileOutputStream1.write(a);
            }
            fileInputStream2.close();
            fileInputStream3.close();
            fileOutputStream1.close();


    }
}
