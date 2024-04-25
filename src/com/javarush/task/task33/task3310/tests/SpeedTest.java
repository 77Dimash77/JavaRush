package com.javarush.task.task33.task3310.tests;

import com.javarush.task.task33.task3310.Helper;
import com.javarush.task.task33.task3310.Shortener;
import com.javarush.task.task33.task3310.strategy.HashBiMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.HashMapStorageStrategy;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class SpeedTest extends Assert {
    public long getTimeToGetIds(Shortener shortener, Set<String> strings, Set<Long> ids) {

        Long startTime = System.nanoTime()/ 1000;
        strings.forEach(str -> ids.add(shortener.getId(str)));
        Long endTime = System.nanoTime()/ 1000;
        return endTime - startTime;
    }

    public long getTimeToGetStrings(Shortener shortener, Set<Long> ids, Set<String> strings) {
        Long startTime = System.nanoTime()/ 1000;
        ids.forEach(id -> strings.add(shortener.getString(id)));
        Long endTime = System.nanoTime()/ 1000;
        return endTime - startTime;
    }

    @Test
    public void testHashMapStorage() {
        Shortener shortener1 = new Shortener(new HashMapStorageStrategy());
        Shortener shortener2 = new Shortener(new HashBiMapStorageStrategy());
        HashSet <String> origStrings = new HashSet<>();
        for (int i = 0; i < 1000; i++) {
            origStrings.add(Helper.generateRandomString());
        }
        Set <Long> ids = new HashSet<>();
        long firstStrategyTime = getTimeToGetIds(shortener1, origStrings, ids);
        long secondStrategyTime = getTimeToGetIds(shortener2, origStrings, ids);
        Assert.assertTrue((firstStrategyTime - secondStrategyTime) > 0);

        long firstTime = getTimeToGetStrings(shortener1, ids, origStrings);
        long secondTime = getTimeToGetStrings(shortener2, ids, origStrings);
        Assert.assertEquals(firstTime, secondTime, 30);
    }
}
