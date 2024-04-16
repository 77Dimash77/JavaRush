package com.javarush.task.pro.task11.task1109;

/* 
Объекты внутренних и вложенных классов
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Outer a = new Outer();
        Outer.Inner b = a.new Inner();
        Outer.Nested c = new Outer.Nested();
    }
}
