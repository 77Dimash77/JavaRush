package com.javarush.task.task15.task1531;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

/* 
Факториал
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(reader.readLine());
        reader.close();

        System.out.println(factorial(input));
    }

    public static String factorial(int n) {
        //add your code here
        BigDecimal result = BigDecimal.valueOf(1);
        for (int iterator = 2; iterator <= n; iterator++)
            result = result.multiply(BigDecimal.valueOf((iterator)));
        return String.valueOf(n < 0 ? 0 : result);
    }
}
