package com.javarush.task.task15.task1522;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Закрепляем паттерн Singleton
*/

public class Solution {
    public static void main(String[] args) {

    }

    public static Planet thePlanet;

    //add static block here - добавьте статический блок тут
static {
    readKeyFromConsoleAndInitPlanet();
    }
    public static void readKeyFromConsoleAndInitPlanet() {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();
        if(word.equals("earth")){
            thePlanet = Earth.getInstance();
        } else if (word.equals("sun")) {
            thePlanet = Sun.getInstance();
        } else if (word.equals("moon")) {
            thePlanet = Moon.getInstance();
        } else {
            thePlanet  = null;
        }
        // implement step #5 here - реализуйте задание №5 тут
    }
}
