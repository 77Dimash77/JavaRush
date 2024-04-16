package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    private List<Horse> horses;

   public static Hippodrome game;
    public Hippodrome(List horses){
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public Horse getWinner(){
        Horse horseW = horses.get(0);
        for (Horse horse: horses){
            if(horse.getDistance() > horseW.getDistance()){
                horseW = horse;
            }
        }
        return horseW;
    }
    public void printWinner(){
        System.out.println("Winner is " + getWinner().getName() + "!");
    }


    public void move(){
    for (Horse horse: horses){
        horse.move();
    }
    }
    public void print(){
        for (Horse horse: horses){
            horse.print();

        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
    }
    public void run() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }



    public static void main(String[] args) throws InterruptedException {
    List<Horse> horses = new ArrayList<>();
        Horse a = new Horse("one",3,0);
        Horse b = new Horse("two",3,0);
        Horse c = new Horse("three",3,0);
        horses.add(a);
        horses.add(b);
        horses.add(c);
        Hippodrome hippodrome = new Hippodrome(horses);
        game = hippodrome;
        game.run();
        game.printWinner();


    }
}
