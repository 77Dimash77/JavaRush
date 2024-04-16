package com.javarush.task.task18.task1817;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

/* 
Пробелы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        int count = 0;
        int prob = 0;
        BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));
        while (bufferedReader.ready()){
            int letter = bufferedReader.read();
            count++;
            if(letter == 32){
                prob++;
            }

        }
        bufferedReader.close();
        double res = (double) prob /(double) count * 100;
        BigDecimal roundedNumber = new BigDecimal(res).setScale(2, RoundingMode.HALF_UP);
        System.out.println(roundedNumber.doubleValue());

    }
}
