package com.javarush.task.pro.task13.task1316;

import java.util.Arrays;
import java.util.Iterator;

public class Solution {

    public static void main(String[] args) {
        //напишите тут ваш код
        JavarushQuest[] a = JavarushQuest.values();
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i].ordinal());
        }
    }
}