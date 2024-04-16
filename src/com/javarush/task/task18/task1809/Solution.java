package com.javarush.task.task18.task1809;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/* 
Реверс файла
*/

public class Solution {
    public static void main(String[] args) throws Exception {
    FileInputStream fileInputStream = new FileInputStream(new Scanner(System.in).nextLine());
    FileOutputStream fileOutputStream = new FileOutputStream(new Scanner(System.in).nextLine());
    List<Integer> arrayList = new ArrayList<>();
    while (fileInputStream.available()>0){
        int a = fileInputStream.read();
        arrayList.add(a);
    }
    Collections.reverse(arrayList);
        for (int i = 0; i < arrayList.size(); i++) {
            fileOutputStream.write(arrayList.get(i));
        }
        fileInputStream.close();
        fileOutputStream.close();
    }
}
