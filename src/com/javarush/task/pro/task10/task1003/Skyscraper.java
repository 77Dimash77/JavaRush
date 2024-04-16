package com.javarush.task.pro.task10.task1003;

/* 
Построим новый бизнес-комплекс JavaRush Business Center
*/

public class Skyscraper {
    private int floorsCount;
    private String developer;
    public Skyscraper(int a, String b){
        floorsCount = a;
        developer = b;
    }
    public Skyscraper(){
    floorsCount = 5;
    developer = "JavaRushDevelopment";
    }

    //напишите тут ваш код

    public static void main(String[] args) {
        Skyscraper skyscraper = new Skyscraper();
        Skyscraper skyscraperUnknown = new Skyscraper(50, "Неизвестно");
    }
}
