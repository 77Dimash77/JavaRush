package com.javarush.task.task22.task2207;

import java.io.*;
import java.util.*;

/* 
Обращенные слова
*/

public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new FileReader(scanner.nextLine()));
        StringBuilder stringBuilder = new StringBuilder();

        // Считываем все строки из файла в StringBuilder
        String line;
        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line).append(" ");
        }

        // Закрываем ридер
        reader.close();

        // Обрабатываем все строки
        String[] strings = stringBuilder.toString().trim().split(" ");
        for (int i = 0; i < strings.length; i++) {
            if (strings[i] == null) {
                continue;
            }
            StringBuilder firstStr = new StringBuilder(strings[i]);
            for (int j = 0; j < strings.length; j++) {
                if (strings[j] == null) {
                    continue;
                }
                StringBuilder secondStr = new StringBuilder(strings[j]);
                if (i != j && firstStr.toString().equals(secondStr.reverse().toString())) {
                    Pair pair = new Pair();
                    pair.first = firstStr.toString();
                    pair.second = secondStr.reverse().toString();
                    result.add(pair);
                    strings[i] = null;
                    strings[j] = null;
                    break;
                }
            }
        }

        // Вывод результата
        for (Pair pair : result) {
            System.out.println(pair);
        }
    }
    public static class Pair {
        String first;
        String second;

        public Pair() {
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return first == null && second == null ? "" :
                    first == null ? second :
                            second == null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
