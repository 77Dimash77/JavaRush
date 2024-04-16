package com.javarush.task.task14.task1419;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.MalformedURLException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //the first exception


        exceptions.add(new InterruptedException());
        exceptions.add(new MalformedURLException());
        exceptions.add(new NumberFormatException());
        exceptions.add(new RemoteException());
        exceptions.add(new RuntimeException());
        exceptions.add(new SQLException());
        exceptions.add(new SocketException());
        exceptions.add(new UnknownHostException());
        exceptions.add(new IOException());
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }


        //напишите тут ваш код

    }
}
