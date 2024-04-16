package com.javarush.task.task19.task1914;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/* 
Решаем пример
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        PrintStream printStream = new PrintStream(outputStream);

        System.setOut(printStream);
        testString.printSomething();
        System.setOut(consoleStream);

        String result = outputStream.toString();
        String str = result.replaceAll("(\\d)|(\\s)|([=])","");

        //str=str.replaceAll("[=]","");


        String tmp[] = result.split("\\s(\\D)\\s");


        int answer=0;
        if(str.equals("+"))
            answer=Integer.parseInt(tmp[0])+Integer.parseInt(tmp[1]);
        else if(str.equals("-"))
            answer=Integer.parseInt(tmp[0])-Integer.parseInt(tmp[1]);
        else if(str.equals("*"))
            answer=Integer.parseInt(tmp[0])*Integer.parseInt(tmp[1]);


        System.out.print(result+""+answer);


    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

