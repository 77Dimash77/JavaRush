package com.javarush.task.task34.task3403;

/* 
Разложение на множители с помощью рекурсии
*/

public class Solution {
    public void recurse(int n) {
        for (int i = 2; i <= n; i++) {
            if (n % i == 0) {
                // Нашли простой множитель
                System.out.print(i + " ");
                // Рекурсивно вызываем метод для оставшейся части числа n
                recurse(n / i);
                return;

            }}}}