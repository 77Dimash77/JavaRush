package com.javarush.task.pro.task10.task1005;

/* 
Многосерийный предприниматель
*/

public class Building {
    private String type ;



    //напишите тут ваш код

    public static void main(String[] args) {
        Building building = new Building();
        building.initialize("Барбершоп");
    }

    public void initialize(String a) {
        this.type = a;
    }
}
