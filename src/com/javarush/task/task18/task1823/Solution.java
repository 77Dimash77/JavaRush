package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.*;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();



    public static class ReadThread extends Thread {

       public String filename = null;
        public ReadThread(String fileName) throws FileNotFoundException {
            //implement constructor body

            this.filename = fileName;

        }

        @Override
        public void run() {
            FileInputStream fileInputStream = null;
            try {
                fileInputStream = new FileInputStream(filename);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }

            Map<Integer,Integer> bytes = new HashMap<>();

         try {
             while (fileInputStream.available()>0){
                 int a = fileInputStream.read();
                 if (bytes.containsKey(a)){
                     bytes.put(a,bytes.get(a) + 1);
                 } else {
                     bytes.put(a,1);
                 }
                 int max = Collections.max(bytes.values());
                 int win = bytes.entrySet().stream().filter(entry -> entry.getValue() == max)
                         .map(Map.Entry:: getKey)
                         . findFirst().orElse(0);
                 resultMap.put(filename, win);
             }
             fileInputStream.close();

         } catch (Exception e){

         }
        }
        // implement file reading here - реализуйте чтение из файла тут

    }
    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        while (!a.equals("exit")){
            ReadThread readThread = new ReadThread(a);
            readThread.start();
            a = scanner.nextLine();

        }
        scanner.close();
    }
}
