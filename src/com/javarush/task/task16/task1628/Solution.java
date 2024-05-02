package com.javarush.task.task16.task1628;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* 
Кто первый встал - того и тапки
*/

public class Solution {
    public static volatile AtomicInteger readStringCount = new AtomicInteger(0);
    public static volatile BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        //read count of strings
        int count = Integer.parseInt(reader.readLine());

        //init threads
        ReaderThread consoleReader1 = new ReaderThread();
        ReaderThread consoleReader2 = new ReaderThread();
        ReaderThread consoleReader3 = new ReaderThread();

        consoleReader1.start();
        consoleReader2.start();
        consoleReader3.start();

        while (count > readStringCount.get()) {
        }

        consoleReader1.interrupt();
        consoleReader2.interrupt();
        consoleReader3.interrupt();
        System.out.println("#1:" + consoleReader1);
        System.out.println("#2:" + consoleReader2);
        System.out.println("#3:" + consoleReader3);

        reader.close();
    }

    public static class ReaderThread extends Thread {
        private List<String> result = new ArrayList<String>();
        public void run() {
            try {
                while (!isInterrupted()) {
                    if (reader.ready()) { // Проверяем, готов ли BufferedReader к чтению
                        String line = reader.readLine(); // Чтение строки с консоли
                        result.add(line); // Добавление строки в список
                        readStringCount.incrementAndGet(); // Увеличение счетчика прочитанных строк
                        System.out.println(line); // Вывод считанной строки
                    }
                }
            } catch (IOException e) {
                // Обработка исключения в случае ошибки чтения с консоли
                System.out.println("An error occurred while reading from console: " + e.getMessage());
            }
        }

        @Override
        public String toString() {
            return result.toString();
        }
    }
}
