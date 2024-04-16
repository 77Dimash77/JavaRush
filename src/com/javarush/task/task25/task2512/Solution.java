package com.javarush.task.task25.task2512;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/* 
Живем своим умом
*/

public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        try {
            t.interrupt();
            ArrayList<Throwable> list = new ArrayList<>();
            while (e!=null) {
                list.add(e);
                e = e.getCause();
            }
            Collections.reverse(list);
            for (Throwable element: list
            ) {
                System.out.println(element);
            }


        }catch (Exception ex){

        }
    }

    public static void main(String[] args) {
    }
}
