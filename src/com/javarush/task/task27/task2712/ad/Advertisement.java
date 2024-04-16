package com.javarush.task.task27.task2712.ad;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.LinkedBlockingQueue;

public class Advertisement {
    private Object content; //видео
    private String name;
    private long initialAmount; //начальная сумма, стоимость рекламы в копейках
    private int hits; // количество показов
    private int duration; // продолжительность в секундах

    private long amountPerOneDisplaying; // стоимость одного показа рекламного объявления в копейках

    public Advertisement(Object content, String name, long initialAmount, int hits, int duration) {
        this.content = content;
        this.name = name;
        this.initialAmount = initialAmount;
        this.hits = hits;
        this.duration = duration;

        this.amountPerOneDisplaying = initialAmount / hits;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public int getHits() {
        return hits;
    }

    public long getAmountPerOneDisplaying() {
        return amountPerOneDisplaying;
    }

    public void revalidate() {
        if (hits <= 0) {
            throw new UnsupportedOperationException();
            //throw new NoVideoAvailableException();
        }
        hits--;
    }
}

//
//package com.javarush.task.task27.task2712;
//
//import com.javarush.task.task27.task2712.kitchen.Cook;
//import com.javarush.task.task27.task2712.kitchen.Order;
//import com.javarush.task.task27.task2712.statistic.StatisticManager;
//
//import java.util.Observable;
//import java.util.Observer;
//import java.util.concurrent.LinkedBlockingQueue;
//
//public class OrderManager implements Observer {
//    StatisticManager statisticManager = StatisticManager.getInstance();
//    private LinkedBlockingQueue<Order> orderQueue = new LinkedBlockingQueue<>();
//
//    public OrderManager() {
//
//        StatisticManager statisticManager = StatisticManager.getInstance();
//        Thread demon = new Thread( () ->
//        {
//            try {
//                while (true) {
//                    while (orderQueue.isEmpty())
//                        Thread.sleep( 10 );
//
//                    for (Cook cook : statisticManager.getCooks())
//                        if (!cook.isBusy())
//                            new Thread( () -> {
//                                if (!orderQueue.isEmpty())
//                                    cook.startCookingOrder( orderQueue.poll() );
//                            } ).start();
//                }
//            } catch (InterruptedException e) {
//            }
//        } );
//        demon.setDaemon( true );
//        demon.start();
//    }
//
//    @Override
//    public void update(Observable o, Object arg) {
//        Order order = (Order) arg;
//        try {
//            orderQueue.put(order);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//
//
//}
