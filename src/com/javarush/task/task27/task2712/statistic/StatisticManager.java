package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventType;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.text.SimpleDateFormat;
import java.util.*;

public class StatisticManager {
    private static StatisticManager ourInstance = new StatisticManager();
    private StatisticStorage statisticStorage = new StatisticStorage();
    private Set<Cook> cooks = new HashSet<>();

    private StatisticManager() {
    }

    public static StatisticManager getInstance() {
        return ourInstance;
    }

    public Set<Cook> getCooks() {
        return cooks;
    }

    public void register(EventDataRow data) {
        statisticStorage.put(data);
    }

    public void register(Cook cook) {
        cooks.add(cook);
    }

    public TreeMap<Date, Long> getVideoStatistic() {

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
        TreeMap<Date, Long> selectedData = new TreeMap<>(Collections.reverseOrder());

        for (EventDataRow event : statisticStorage.getVideoDataStorage()) {
            if (event instanceof VideoSelectedEventDataRow) {
                String date = sdf.format(event.getDate());
                Date data = new Date(date);
                if (selectedData.containsKey(data)) {
                    selectedData.put(data, selectedData.get(data) + ((VideoSelectedEventDataRow) event).getAmount());
                } else {
                    selectedData.put(data, ((VideoSelectedEventDataRow) event).getAmount());
                }
            }
        }
        return selectedData;
    }

    public TreeMap<Date, TreeMap<String, Integer>> getCookStatistic() {
        TreeMap<Date, TreeMap<String, Integer>> selectedData = new TreeMap<>(Collections.reverseOrder());
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");

        for (EventDataRow event : statisticStorage.getCookingDataStorage()) {
            if (event instanceof CookedOrderEventDataRow) {
                String date = sdf.format(event.getDate());
                Date data = new Date(date);

                String name = ((CookedOrderEventDataRow) event).getCookName();
                Integer time = event.getTime();
                if (selectedData.containsKey(data)) {
                    if (selectedData.get(data).containsKey(name)) {
                        time += selectedData.get(data).get(name);
                        selectedData.get(data).put(name, time);
                    } else {
                        selectedData.get(data).put(name, time);
                    }
                } else {
                    selectedData.put(data, new TreeMap<>());
                    selectedData.get(data).put(name, time);
                }
            }
        }
        return selectedData;
    }

    private class StatisticStorage {
        private Map<EventType, List<EventDataRow>> storage = new HashMap<>();

        private StatisticStorage() {
            for (EventType event : EventType.values()) {
                storage.put(event, new ArrayList<>());
            }
        }

        private void put(EventDataRow data) {
            storage.get(data.getType()).add(data);
        }


        private List<EventDataRow> getVideoDataStorage() {
            return storage.get(EventType.SELECTED_VIDEOS);
        }

        private List<EventDataRow> getCookingDataStorage() {
            return storage.get(EventType.COOKED_ORDER);
        }

    }
}
