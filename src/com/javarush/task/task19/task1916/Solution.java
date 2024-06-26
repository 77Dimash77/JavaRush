package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        String file1 = buff.readLine();
        String file2 = buff.readLine();
        buff.close();
        BufferedReader inputFile1 = new BufferedReader(new FileReader(file1));
        BufferedReader inputFile2 = new BufferedReader(new FileReader(file2));

        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        while (inputFile1.ready()) {
            list1.add(inputFile1.readLine());
        }

        while (inputFile2.ready()) {
            list2.add(inputFile2.readLine());
        }

        inputFile1.close();
        inputFile2.close();

        while (list1.size() > 0 | list2.size() > 0) {
            if (list1.size() > 0 && list2.size() > 0) {

                if (list1.get(0).equals(list2.get(0))) {
                    lines.add(new LineItem(Type.SAME, list1.get(0)));
                    list1.remove(0);
                    list2.remove(0);
                } else if (!list1.get(0).equals(list2.get(0)) && !list1.get(0).equals(list2.get(1))) {
                    lines.add(new LineItem(Type.REMOVED, list1.get(0)));
                    list1.remove(0);
                } else if (!list1.get(0).equals(list2.get(0)) && list1.get(0).equals(list2.get(1))) {
                    lines.add(new LineItem(Type.ADDED, list2.get(0)));
                    list2.remove(0);
                }
            } else if (list1.size() > 0 && list2.isEmpty()) {
                for (int i = 0; i < list1.size(); i++) {
                    lines.add(new LineItem(Type.REMOVED, list1.get(i)));
                    list1.remove(0);
                }
            } else if (list1.isEmpty() && list2.size() > 0) {
                for (int i = 0; i < list2.size(); i++) {
                    lines.add(new LineItem(Type.ADDED, list2.get(i)));
                    list2.remove(0);
                }
            }
        }

        for (int i = 0; i < lines.size(); i++) {
            System.out.println(lines.get(i));
        }
    }





    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}