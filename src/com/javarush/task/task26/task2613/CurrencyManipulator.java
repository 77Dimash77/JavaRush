package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.exception.NotEnoughMoneyException;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class CurrencyManipulator {
    private String currencyCode;
    private Map<Integer, Integer> denominations = new HashMap<>();

    public CurrencyManipulator(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void addAmount(int denomination, int count){
        if (denominations.containsKey(denomination)){
            count = count + denominations.get(denomination);
        }
        denominations.put(denomination, count);
    }

    public int getTotalAmount(){
        int sum = 0;
        for (Map.Entry e: denominations.entrySet()
        ) {
            sum += ((Integer) e.getKey())* ((Integer) e.getValue());
        }
        return sum;
    }
    public boolean hasMoney(){
        return denominations.size()!=0;
    }
    public boolean isAmountAvailable(int expectedAmount){
        return expectedAmount <= getTotalAmount();
    }
    public Map<Integer, Integer> withdrawAmount(int expectedAmount) throws NotEnoughMoneyException {
        int amount = expectedAmount;
        TreeMap<Integer, Integer> tree = new TreeMap<>(Collections.reverseOrder());
        tree.putAll(denominations);
        TreeMap<Integer, Integer> res = new TreeMap<>(Collections.reverseOrder());
        for (Map.Entry<Integer, Integer> val : tree.entrySet()) {
            int current = 0;
            int nominal = val.getKey();
            if (nominal <= amount) {
                int count = val.getValue();
                for (int i = 1; i <= count; i++) {
                    if (nominal * i <= amount) {
                        current = nominal * i;
                        res.put(nominal, i);
                    }
                }
                amount -= current;
            }
        }
        if (amount == 0)
            res.forEach((k, v) -> {
                int a = denominations.get(k);
                a -= v;
                denominations.put(k, a);
            });
        else throw new NotEnoughMoneyException();
        return res;
    }
}


