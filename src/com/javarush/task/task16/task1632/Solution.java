package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Клубок
*/

public class Solution {



    public static List<Thread> threads = new ArrayList<>(5);
    static {
        threads.add(new Besk());
        threads.add(new VivEx());
        threads.add(new Ura());
        threads.add(new Sinter());
        threads.add(new Kons());

    }

    public static void main(String[] args) {


    }
    public static class Besk extends Thread {
        public void run(){
            while (true){

            }
        }
    }
    public static class VivEx extends Thread {
        public void run(){
     try {
         Thread.sleep(3000);
         Thread.currentThread().interrupt();
     }catch (InterruptedException e){
         System.out.println("InterruptedException");
     }
        }
    }
    public static class Ura extends Thread {
        public void run(){
            while (true){
                try {
                    System.out.println("Ура");
                    Thread.sleep(500);

                } catch (Exception e){

                }

            }
            }

    }
    public static class  Sinter extends Thread implements Message {
        boolean stop = false;
        @Override
        public void showWarning() {
            stop = true;
        }
        public void run(){
            while (stop == false){

            }
        }
    }
    public static class Kons extends Thread {
        Scanner scanner = new Scanner(System.in);
        String a = "N";
        boolean N = false;
        int result = 0;
        public void run(){
            while (N == false){
                String word = scanner.nextLine();
                if(word.equals("N")){
                    System.out.println(result);
                    return;
                } else {
                    int b = Integer.parseInt(word);
                    result = result + b;
                }
            }
        }
    }


}