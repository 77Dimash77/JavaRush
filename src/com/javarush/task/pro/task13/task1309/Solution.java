package com.javarush.task.pro.task13.task1309;

import java.util.HashMap;

/* 
Успеваемость студентов
*/

public class Solution {
    public static HashMap<String, Double> grades = new HashMap<>();

    public static void main(String[] args) {
        addStudents();
        System.out.println(grades);
    }

    public static void addStudents() {
        grades.put("LOL1",2.1);
        grades.put("LOL2",2.1);
        grades.put("LOL3",2.1);
        grades.put("LOL4",2.1);
        grades.put("LOL5",2.1);
        //напишите тут ваш код
    }
}
