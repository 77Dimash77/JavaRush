package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 
Генератор паролей
*/

public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        StringBuilder sb = new StringBuilder();
        List<String> arrayList = new ArrayList<>();

        arrayList.add(getRandomLetter(true, false, false));
        arrayList.add(getRandomLetter(false, true, false));
        arrayList.add(getRandomLetter(false, false, true));
        for (int i = 0; i < 5; i++) {
            arrayList.add(getRandomLetter(false, false, false));
        }
        Collections.shuffle(arrayList);
        for (String letter : arrayList) {
            sb.append(letter);
        }

        try {
            outputStream.write(sb.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }


        return outputStream;
    }

    public static String getRandomLetter(boolean isLowerCase, boolean isCapital, boolean isNumber) {

        if (isNumber) {
            return String.valueOf((int) (Math.random() * 10));
        }
        char[] letterArray = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        int charNumber = (int) (Math.random() * letterArray.length);

        if (isCapital) {
            return String.valueOf(letterArray[charNumber]).toUpperCase();
        }

        if (isLowerCase) {
            return String.valueOf(letterArray[charNumber]);
        }

        double random = Math.random();
        if (random > 0.7) {
            return String.valueOf(letterArray[charNumber]).toUpperCase();
        }
        if (Math.random() > 0.5) {
            return String.valueOf((int) (Math.random() * 10));
        }
        return String.valueOf(letterArray[charNumber]);

    }
}