package com.javarush.task.task17.task1721;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws CorruptedDataException {
        Scanner scanner = new Scanner(System.in);
        File file1 = new File(scanner.nextLine());
        File file2 = new File(scanner.nextLine());
        try {
            FileReader fileReader = new FileReader(file1);
            BufferedReader bufferedReader1 = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader1.readLine())!= null){
                allLines.add(line);
            }

        } catch (Exception e){

        }
        try {
            FileReader fileReader = new FileReader(file2);
            BufferedReader bufferedReader2 = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader2.readLine())!= null){
                forRemoveLines.add(line);
            }

        } catch (Exception e){

        }
Solution solution = new Solution();
        solution.joinData();


    }

    public void joinData() throws CorruptedDataException {
       if(allLines.containsAll(forRemoveLines)){
           allLines.removeAll(forRemoveLines);
       } else {
           allLines.clear();
           throw new CorruptedDataException();
       }

       }

    }
