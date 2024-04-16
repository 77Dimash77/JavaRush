package com.javarush.task.pro.task12.task1210;

import java.util.ArrayList;

/* 
Переворачивание данных
*/

public class Solution {
    public static ArrayList<Integer> numbers = new ArrayList<Integer>();

    public static void main(String[] args) {
        init();
        print();

        reverse();
        print();
    }

    public static void init() {
        for (int i = 0; i < 10; i++) {
           numbers.add(i);
        }
    }

    public static void reverse() {

        for (int i = 0; i < numbers.size() / 2; i++) {
            int temp = numbers.get(i);
            numbers.remove(numbers.indexOf(i));
            numbers.add(i, numbers.get(numbers.size() - i - 1 ));
            numbers.add(numbers.size() - i, temp);
            numbers.remove(numbers.size() - i - 1);


        }
    }

    private static void print() {
        for (int number : numbers) {
            System.out.println(number);
        }
    }
}
