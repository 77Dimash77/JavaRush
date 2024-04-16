package com.javarush.task.task14.task1420;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
НОД
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        long a = scanner.nextLong();
        long b = scanner.nextLong();

        long x = gcd(a,b);
        System.out.println(x);

    }
  public  static long gcd(long a,long b){
        return b == 0 ? a : gcd(b,a % b);
    }
}
