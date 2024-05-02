package com.javarush.task.task16.task1629;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Только по-очереди!
*/

public class Solution {
    public static volatile BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws InterruptedException {
        Read3Strings t1 = new Read3Strings();
        Read3Strings t2 = new Read3Strings();

        // Стартуем первую нить
        t1.start();
        // Ожидаем завершения первой нити
        t1.join();
        // Выводим результат первой нити
        t1.printResult();

        // Стартуем вторую нить
        t2.start();
        // Ожидаем завершения второй нити
        t2.join();
        // Выводим результат второй нити
        t2.printResult();
    }

    // Создаем класс нити Read3Strings
    public static class Read3Strings extends Thread {
        // Объявляем переменную для хранения результата
        private String result = "";

        // Переопределяем метод run()
        public void run() {
            try {
                // Читаем три строки с консоли и объединяем их через пробел
                for (int i = 0; i < 3; i++) {
                    result += reader.readLine() + " ";
                }
            } catch (IOException e) {
                // Обрабатываем возможное исключение ввода/вывода
                System.out.println("An error occurred while reading input: " + e.getMessage());
            }
        }

        // Метод для вывода результата
        public void printResult() {
            System.out.println(result.trim()); // Убираем лишний пробел в конце строки
        }
    }
}


