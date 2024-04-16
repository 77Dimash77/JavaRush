package com.javarush.task.task18.task1822;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/* 
Поиск данных внутри файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String file1 = scanner.nextLine();
        FileReader fileReader1 = new FileReader(file1);
        BufferedReader bufferedReader1 = new BufferedReader(fileReader1);
        ArrayList<String> arrayList = new ArrayList<>();
        while (bufferedReader1.ready()){
           String a = bufferedReader1.readLine();
           arrayList.add(a);

        }
        String finds = "";
        String ID = String.valueOf(args[0]);
        for(String a: arrayList){
            if(a.startsWith(ID)) {
                finds = a;

            }

        }
        System.out.println(finds);
        scanner.close();
        fileReader1.close();
        bufferedReader1.close();
    }
}
