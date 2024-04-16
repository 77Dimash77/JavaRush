package com.javarush.task.pro.task17.task1715;

import java.util.ArrayList;
import java.util.List;

/* 
Вилларибо и Виллабаджо.
*/

public class Solution {
    static List<MusicalInstrument> orchestra = new ArrayList<>();

    public static void main(String[] args) {
        createKeyboardOrchestra();
        createStringedOrchestra();
        playOrchestra();
    }

    public static void createKeyboardOrchestra() {
        //напишите тут ваш код
        MusicalInstrument org = new Organ();
        MusicalInstrument pia1 = new Piano();
        MusicalInstrument pia2 = new Piano();
        MusicalInstrument pia3 = new Piano();
        orchestra.add(org);
        orchestra.add(pia1);
        orchestra.add(pia2);
        orchestra.add(pia3);
    }

    public static void createStringedOrchestra() {
        //напишите тут ваш код
        MusicalInstrument v1 = new Violin();
        MusicalInstrument v2 = new Violin();
        MusicalInstrument g1 = new Guitar();

        orchestra.add(v1);
        orchestra.add(v2);
        orchestra.add(g1);

    }

    public static void playOrchestra() {
        for (MusicalInstrument instrument: orchestra){
            instrument.play();
        }
    }
}
