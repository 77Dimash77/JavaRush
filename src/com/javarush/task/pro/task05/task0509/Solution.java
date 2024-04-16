package com.javarush.task.pro.task05.task0509;

/* 
Таблица умножения
*/

public class Solution {

    public static int[][] MULTIPLICATION_TABLE;

    public static void main(String[] args) {
        //напишите тут ваш код
        MULTIPLICATION_TABLE = new int[10][10];
        for (int w1 = 0; w1 < 10; w1++) {
            for (int h1 = 0; h1 < 10; h1++) {
                MULTIPLICATION_TABLE[w1][h1] = (w1 + 1) * (h1 + 1);
                System.out.print(MULTIPLICATION_TABLE[w1][h1] + "\t");
            }
            System.out.println();
        }

    }
}
