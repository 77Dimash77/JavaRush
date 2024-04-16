package com.javarush.task.task27.task2712.ad;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

public class StatisticAdvertisementManager {
    private static StatisticAdvertisementManager ourInstance = new StatisticAdvertisementManager();
    private AdvertisementStorage advertisementStorage = AdvertisementStorage.getInstance();


    private StatisticAdvertisementManager() {
    }

    public static StatisticAdvertisementManager getInstance() {
        return ourInstance;
    }

    //Пример вывода для printActiveVideoSet:
    //First Video - 100
    //Second video - 10
    //Third Video - 2
    //четвертое видео - 4

    public TreeMap<String, Integer> getActiveVideo() {
        TreeMap<String, Integer> result = new TreeMap<>();

        for (Advertisement video : advertisementStorage.list()) {
            if (video.getHits() > 0) {
                result.put(video.getName(), video.getHits());
            }
        }
        return result;
    }

    public List<String> getArhivedVideo() {
        ArrayList<String> list = new ArrayList<>();
        for (Advertisement video : advertisementStorage.list()) {
            if (video.getHits() == 0) {
                list.add(video.getName());
            }
        }
        list.sort(String::compareToIgnoreCase);

        return list;
    }


}
