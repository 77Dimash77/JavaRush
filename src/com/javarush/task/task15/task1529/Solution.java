package com.javarush.task.task15.task1529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Осваивание статического блока
*/

public class Solution {
    public static void main(String[] args) {

    }

    static {
   reset();
        //add your code here - добавьте код тут
    }

    public static CanFly result;

    public static void reset() {
        //add your code here - добавьте код тут
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        if(a.equals("helicopter")){
            result = new Helicopter();
        } else if (a.equals("plane")) {
            int b = scanner.nextInt();
            result = new Plane(b);
        }
        scanner.close();
    }
}
