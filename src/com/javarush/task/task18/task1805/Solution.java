package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        FileInputStream fileInputStream = new FileInputStream(new Scanner(System.in).nextLine());
        Set<Integer> hashset = new TreeSet<>();
        while (fileInputStream.available()>0){
           int a = fileInputStream.read();
           hashset.add(a);
        }
        fileInputStream.close();
        for (int a: hashset){
            System.out.print(" " + a);
        }
    }
}
