package com.javarush.task.task30.task3012;

/* 
Получи заданное число
*/

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.createExpression(74);
    }

    public void createExpression(int number) {
        StringBuilder expression = new StringBuilder(number + " = ");
        int powerOf3 = 0;
        do {
            int remainder = number % 3;
            number /= 3;
            if (remainder == 1) {
                expression.append("+ ").append((int) Math.pow(3, powerOf3)).append(" ");
            } else if (remainder == 2) {
                expression.append("- ").append((int) Math.pow(3, powerOf3)).append(" ");
                number++;
            }
            powerOf3++;
        } while (number > 0);
        System.out.println(expression);
    }
}