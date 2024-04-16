package com.javarush.task.task14.task1411;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
User, Loser, Coder and Proger
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Person person = null;
        String key = null;
        Scanner scanner = new Scanner(System.in);
        boolean isLegal = true;
        while (isLegal) {
            key = reader.readLine();
            switch (key) {
                case "user" : person = new Person.User(); break;
                case "loser" : person = new Person.Loser(); break;
                case "coder" : person = new Person.Coder(); break;
                case "proger" : person = new Person.Proger(); break;
                default: isLegal = false; continue;
            }
            doWork(person); //вызываем doWork
        }

    }

    public static void doWork(Person person) {
        // пункт 3

            if (person instanceof Person.User) {
                ((Person.User) person).live();
            }
            if (person instanceof Person.Loser) {
                ((Person.Loser) person).doNothing();
            }
            if (person instanceof Person.Coder) {
                ((Person.Coder) person).writeCode();
            }
        if (person instanceof Person.Proger) {
            ((Person.Proger) person).enjoy();
        }
        }
    }