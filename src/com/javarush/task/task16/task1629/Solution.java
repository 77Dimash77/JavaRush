//package com.javarush.task.task16.task1629;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
///*
//Только по-очереди!
//*/
//
//public class Solution {
//    public static volatile BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//
//    public static void main(String[] args) throws InterruptedException {
//        Read3Strings t1 = new Read3Strings();
//        Read3Strings t2 = new Read3Strings();
//
//        //add your code here - добавьте код тут
//
//        t1.printResult();
//        t2.printResult();
//    }
//public static class Read3Strings extends Thread{
//
//        void printResult(){
//            result = String.join(" ", reader.readLine(), reader.readLine(), reader.readLine());
//        }
//       public void run(){
//
//        }
//}
//    //add your code here - добавьте код тут
//}
