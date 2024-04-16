package com.javarush.task.task15.task1523;

/* 
Перегрузка конструкторов
*/

public class Solution {
    public static void main(String[] args) {

    }
   private Solution(int a){
       System.out.println(1);
   }
    protected Solution(String a){
        System.out.println(2);
    }
    public Solution(int a, int b){
        System.out.println(3);
    }
     Solution(String a, String b){
         System.out.println(4);
     }
}

