package com.javarush.task.pro.task10.task1012;

import java.util.Arrays;
import java.util.Objects;

/* 
Дефрагментация памяти
*/

public class Memory {

    public static void main(String[] args) {
        String[] memory = {"object15", null, null, "object2", null, null, null, "object32", null, "object4"};
        executeDefragmentation(memory);
        System.out.println(Arrays.toString(memory));
    }

    public static void executeDefragmentation(String[] array) {
        //напишите тут ваш код
        String[] a = new String[array.length];
        int b = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i]!=null){
                a[b] = array[i];
                b++;
            }

        }
        for (int i = 0; i < array.length; i++) {
            array[i] = null;
        }
        for (int i = 0; i < a.length; i++) {
            array[i] = a[i];
        }

    }
}
