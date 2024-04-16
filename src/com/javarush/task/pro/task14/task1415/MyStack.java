package com.javarush.task.pro.task14.task1415;

import java.util.LinkedList;
import java.util.List;

/* 
Стек в домашних условиях
*/

public class MyStack {

    private final List<String> storage = new LinkedList<>();

    public void push(String s) {
        //напишите тут ваш код
        storage.add(0,s);
    }

    public String pop() {
        //напишите тут ваш код
        String o = storage.get(0);
        storage.remove(0);
        return o;
    }

    public String peek() {
        //напишите тут ваш код
        return storage.get(0);
    }

    public boolean empty() {
        //напишите тут ваш код

        return storage.isEmpty();
    }

    public int search(String s) {
        if(storage.contains(s)){
            return storage.indexOf(s);
        } else {
            return -1;
        }


    }
}
