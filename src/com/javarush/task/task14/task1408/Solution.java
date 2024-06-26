package com.javarush.task.task14.task1408;

/* 
Куриная фабрика
*/

public class Solution {
    public static void main(String[] args) {
        Hen hen = HenFactory.getHen(Country.BELARUS);
        hen.getCountOfEggsPerMonth();
    }

    static class HenFactory {

        static Hen getHen(String country) {
            Hen hen = null;
            switch (country){
                case RussianHen.RUSSIA: hen = new RussianHen();
                        break;
                case UkrainianHen.UKRAINE: hen = new UkrainianHen();
                break;
                case MoldovanHen.MOLDOVA: hen = new MoldovanHen();
                break;
                case BelarusianHen.BELARUS: hen = new BelarusianHen();
                break;
            }
            return hen;
        }
    }


}
