package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.StatisticAdvertisementManager;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

public class DirectorTablet {
    /**
     * 1. какую сумму заработали на рекламе, сгруппировать по дням;
     * 2. загрузка (рабочее время) повара, сгруппировать по дням;
     * 3. список активных роликов и оставшееся количество показов по каждому;
     * 4. список неактивных роликов (с оставшемся количеством показов равным нулю).
     */


    //3. Начнем с логики метода printAdvertisementProfit в классе DirectorTablet.
    //Используя метод из предыдущего пункта вывести в консоль в убывающем порядке даты и суммы.
    //Для каждой даты из хранилища событий, для которой есть показанная реклама, должна выводится сумма прибыли за показы рекламы для этой даты.
    //В конце вывести слово Total и общую сумму.
    //
    //Пример:
    //14-May-2013 - 2.50
    //13-May-2013 - 1.02
    //12-May-2013 - 543.98
    //Total - 547.50

    void printAdvertisementProfit() {
        TreeMap<Date, Long> result = StatisticManager.getInstance().getVideoStatistic();

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
        long total = 0;
        for (Map.Entry<Date, Long> item : result.entrySet()) {
            ConsoleHelper.writeMessage((sdf.format(item.getKey()) + " - " + new BigDecimal(item.getValue()).movePointLeft(2)));
            total += item.getValue();
        }
        ConsoleHelper.writeMessage("Total - " + new BigDecimal(total).movePointLeft(2));
    }


    //Пример:
    //14-May-2013
    //Ivanov - 60 min
    //Petrov - 35 min
    //
    //13-May-2013
    //Ivanov - 129 min
    //
    //12-May-2013
    //Ivanov - 6 min
    //Petrov - 5 min

    void printCookWorkloading() {
        TreeMap<Date, TreeMap<String, Integer>> result = StatisticManager.getInstance().getCookStatistic();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");

        for (Map.Entry<Date, TreeMap<String, Integer>> item : result.entrySet()) {
            ConsoleHelper.writeMessage(sdf.format(item.getKey()));
            for (Map.Entry<String, Integer> data : item.getValue().entrySet()) {
                ConsoleHelper.writeMessage(data.getKey() + " - " + data.getValue() / 60 + " min");
            }
            ConsoleHelper.writeMessage("");
        }
    }

    //4. Реализуй логику методов printActiveVideoSet и printArchivedVideoSet в классе DirectorTablet.
    //Используй методы/метод, созданные в предыдущем пункте.
    //Сортировать по имени видео-ролика в алфавитном порядке
    //Сначала английские, потом русские.
    //
    //Пример вывода для printActiveVideoSet:
    //First Video - 100
    //Second video - 10
    //Third Video - 2
    //четвертое видео - 4
    //
    //Через 50 показов пример вывода для printArchivedVideoSet:
    //Second video
    //Third Video
    //четвертое видео


    void printActiveVideoSet() {
        for (Map.Entry<String, Integer> item : StatisticAdvertisementManager.getInstance().getActiveVideo().entrySet()) {
            ConsoleHelper.writeMessage(item.getKey() + " - " + item.getValue());
        }
    }

    void printArchivedVideoSet() {
        for (String list : StatisticAdvertisementManager.getInstance().getArhivedVideo()) {
            ConsoleHelper.writeMessage(list);
        }
    }

}
