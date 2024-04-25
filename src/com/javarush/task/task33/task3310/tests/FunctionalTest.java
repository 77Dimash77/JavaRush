package com.javarush.task.task33.task3310.tests;

import com.javarush.task.task33.task3310.Shortener;
import com.javarush.task.task33.task3310.strategy.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FunctionalTest {
    private String[] testStringsSet;

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }


    public void testStorage(Shortener shortener) {
        String string1 = "Nelly";
        String string2 = "NDKJFDOIfUISD";
        String string3 = "Nelly";
        Long id1 = shortener.getId(string1);
        Long id2 = shortener.getId(string2);
        Long id3 = shortener.getId(string3);

        Assert.assertNotEquals(id2, id1);
        Assert.assertEquals(id1, id3);

        String s1 = shortener.getString(id1);
        String s2 = shortener.getString(id2);
        String s3 = shortener.getString(id3);

        Assert.assertEquals(s1, string1);
        Assert.assertEquals(s2, string2);
        Assert.assertEquals(s3, string3);
    }


    @Test
    public void testHashMapStorageStrategy() {
        Shortener shortener = new Shortener(new HashMapStorageStrategy());
        testStorage(shortener);
    }

    @Test
    public void testOurHashMapStorageStrategy() {
        Shortener shortener = new Shortener(new OurHashMapStorageStrategy());
        testStorage(shortener);
    }

    @Test
    public void testFileStorageStrategy() {
        Shortener shortener = new Shortener(new FileStorageStrategy());
        testStorage(shortener);
    }

    @Test
    public void testHashBiMapStorageStrategy() {
        Shortener shortener = new Shortener(new HashBiMapStorageStrategy());
        testStorage(shortener);
    }

    @Test
    public void testDualHashBidiMapStorageStrategy() {
        Shortener shortener = new Shortener(new DualHashBidiMapStorageStrategy());
        testStorage(shortener);
    }

    @Test
    public void testOurHashBiMapStorageStrategy() {
        Shortener shortener = new Shortener(new OurHashBiMapStorageStrategy());
        testStorage(shortener);
    }
}
