package com.javarush.task.task16.task1617;

/* 
Отсчет на гонках
*/

public class Solution {
    public static volatile int numSeconds = 3;

    public static void main(String[] args) throws InterruptedException {
        RacingClock clock = new RacingClock();
        Thread.sleep(3500);
        clock.interrupt();
        //add your code here - добавь код тут
    }

    public static class RacingClock extends Thread {
        public RacingClock() {
            start();
        }

        public void run() {
            //add your code here - добавь код тут
            try {
                while (numSeconds > 0) {
                    System.out.printf(numSeconds + " ");
                    Thread.sleep(1000);
                    numSeconds--;
                }
            } catch (InterruptedException e) {
                System.out.printf("Прервано!");
                return;
            }
            System.out.printf("Марш!");
        }
    }
}
