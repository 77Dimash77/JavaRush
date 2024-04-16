package com.javarush.task.task29.task2913;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/* 
Замена рекурсии
*/

public class Solution {
    private static int numberA;
    private static int numberB;

    public static String getAllNumbersBetween(int a, int b) {
        String result = "";
        List<Integer> list = new ArrayList<>();
        int start;
        int end;
        if (a > b) {
            start = b;
            end = a;
        } else {
            start = a;
            end = b;
        }
        for (int i = start; i <= end; i++) {
            list.add(i);
        }
        if (a > b) {
            Collections.reverse(list);
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                builder.append(list.get(i));
                builder.append(" ");
                result = builder.toString().trim();
            }
        } else {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                builder.append(list.get(i));
                builder.append(" ");
                result = builder.toString().trim();
            }
        }

        return  result;
    }

    public static void main(String[] args) {
        Random random = new Random();
        numberA = random.nextInt(1000);
        numberB = random.nextInt(1000);
        System.out.println(getAllNumbersBetween(numberA, numberB));
        System.out.println(getAllNumbersBetween(numberB, numberA));
    }
}