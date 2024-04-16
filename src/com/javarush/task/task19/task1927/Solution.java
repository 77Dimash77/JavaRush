package com.javarush.task.task19.task1927;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/* 
Контекстная реклама
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream console = System.out;
        ByteArrayOutputStream newout = new ByteArrayOutputStream();
        PrintStream mystream = new PrintStream(newout);
        System.setOut(mystream);
        testString.printSomething();
        System.setOut(console);
        String str = newout.toString();
        String[] res = str.split("\n");
        System.out.println(res[0]);
        for (int i = 1; i < res.length; i++)
        {
            if (i%2==0) System.out.println("JavaRush - курсы Java онлайн");
            System.out.println(res[i]);
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
