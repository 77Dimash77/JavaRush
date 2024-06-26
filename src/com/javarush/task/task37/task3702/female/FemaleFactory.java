package com.javarush.task.task37.task3702.female;

import com.javarush.task.task37.task3702.AbstractFactory;
import com.javarush.task.task37.task3702.Human;
import com.javarush.task.task37.task3702.male.KidBoy;
import com.javarush.task.task37.task3702.male.Man;
import com.javarush.task.task37.task3702.male.TeenBoy;

public class FemaleFactory implements AbstractFactory {
    public Human getPerson (int age){
        if(age < KidGirl.MAX_AGE + 1){
            return new KidGirl();
        } else if (age > KidGirl.MAX_AGE && age < TeenGirl.MAX_AGE + 1) {
            return new TeenGirl();
        } else if (age>TeenGirl.MAX_AGE) {
            return new Woman();
        }
        return null;
    }
}
