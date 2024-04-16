package com.javarush.task.task31.task3110;

import java.io.IOException;
import java.util.Scanner;

public class ConsoleHelper {
    public static void writeMessage(String message){
        System.out.println(message);
    }

    public static  String readString(){
        return new Scanner(System.in).nextLine();
    }
    public static  int readInt() throws IOException {
        return new Scanner(System.in).nextInt();
    }
}
