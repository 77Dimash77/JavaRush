package com.javarush.task.pro.task04.task0403;

import java.util.Scanner;

/* 
Суммирование
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
    Scanner a = new Scanner(System.in);
    String d = "ENTER";
    int result = 0;
    while(a.hasNextInt()){
       int a1 = a.nextInt();
        result = result + a1;
    }
    while(a.hasNextLine()){
       String a2 = a.nextLine();
        if(a2.equals(d)){
            System.out.println(result);
        }
    }
    
    }
}