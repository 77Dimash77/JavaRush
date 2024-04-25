package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.HashMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.StorageStrategy;

import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public static Set<Long> getIds(Shortener shortener, Set<String> strings) {
       Set<Long> set = new HashSet<>();
        for (String s : strings) {
        set.add(shortener.getId(s));

        }
        return set;
    }
   public static Set<String> getStrings(Shortener shortener, Set<Long> keys){
        Set<String> str = new HashSet<>();
        for (Long k: keys){
            str.add(shortener.getString(k));
        }
        return str;

   }
   public static void testStrategy(StorageStrategy strategy, long elementsNumber){
       Helper.printMessage(strategy.getClass().getSimpleName());
       Set<String> strings = new HashSet<>();
       for (long i = 0; i < elementsNumber; i++) {
           strings.add(Helper.generateRandomString());
       }
       Shortener shortener = new Shortener(strategy);
       Long time1 = new Date().getTime();
       Set<Long> keys = getIds(shortener, strings);
       Long time2 = new Date().getTime();
       Long duration = time2 - time1;
       Helper.printMessage(duration.toString());
       Long time3 = new Date().getTime();
       Set<String> stringsSet = getStrings(shortener, keys);
       Long time4 = new Date().getTime();
       Long duration2 = time4 - time3;
       Helper.printMessage(duration2.toString());
       if (stringsSet.equals(strings)) Helper.printMessage("Тест пройден.");
       else Helper.printMessage("Тест не пройден.");
    }


    public static void main(String[] args) {
        StorageStrategy strategy1 = new HashMapStorageStrategy();
        testStrategy(strategy1, 10000);

    }


}
