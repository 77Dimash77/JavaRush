package com.javarush.task.task38.task3803;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* 
Runtime исключения (unchecked exception)
*/

public class VeryComplexClass {
    public void methodThrowsClassCastException() throws ClassCastException {
        Object ch = new Character('*');
        System.out.println((Byte) ch);
    }

    public void methodThrowsNullPointerException() {
        int[] array = null;
        System.out.println(array.length);
    }

    public static void main(String[] args) {
        VeryComplexClass o = new VeryComplexClass();
        o.methodThrowsNullPointerException ();
    }
}
