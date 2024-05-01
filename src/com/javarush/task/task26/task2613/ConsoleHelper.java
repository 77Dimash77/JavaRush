package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.ResourceBundle;


public class ConsoleHelper {
    private static BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));
    private static ResourceBundle res = ResourceBundle.getBundle(CashMachine.class.getPackage().getName() + ".resources.common_en");

    /**
     * Будет писать в консоль наше сообщение.
     *
     * @param message принимает сообщение и выводит в консоль
     */
    public static void writeMessage(String message) {
        System.out.println(message);
    }

    /**
     * Будет считывать с консоли строку и возвращать ее.
     * Если возникнет какое-то исключение при работе с консолью, то перехватим его и не будем обрабатывать.
     * Кстати, создадим только один экземпляр BufferedReader-а, в статическом поле bis.
     *
     * @return Строку с консоли
     */
    public static String readString() throws InterruptOperationException {
        try {
            String s = bis.readLine();
            if (s.toUpperCase().equalsIgnoreCase("EXIT")) throw new InterruptOperationException();
            return s;
        } catch (IOException e) {
        }
        return "";
    }

    /**
     * Этот метод должен предлагать пользователю ввести код валюты, проверять, что код содержит 3 символа.
     * Если данные некорректны, то сообщить об этом пользователю и повторить.
     * Если данные валидны, то перевести код в верхний регистр и вернуть.
     *
     * @return 3-значный код валюты в верхнем регистре
     */
    public static String askCurrencyCode() throws InterruptOperationException {
        while (true) {
            writeMessage("Введите 3-значный код валюты, например USB RUB BYN");
            String code = readString();
            if (code.length() == 3) return code.toUpperCase();
            writeMessage("Неверный код валюты");
        }
    }

    /**
     * Этот метод должен предлагать пользователю ввести два целых положительных числа.
     * Первое число - номинал, второе - количество банкнот.
     * Никаких валидаторов на номинал нет. Т.е. 1200 - это нормальный номинал.
     * Если данные некорректны, то сообщить об этом пользователю и повторить.
     *
     * @param currencyCode код валюты
     * @return массив строк с числами
     */
    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException {
        writeMessage("Введите номинал и количество разделенные пробелом");
        String[] input;
        while (true) {
            input = readString().split(" ");
            int denomination = 0;
            int count = 0;
            try {
                denomination = Integer.parseInt(input[0]);
                count = Integer.parseInt(input[1]);
            } catch (Exception e) {
                writeMessage("Введите 2 корректных числа разделенных пробелом");
                continue;
            }
            if (denomination < 0 || count < 0) {
                writeMessage("Введите 2 корректных числа разделенных пробелом");
                continue;
            }
            break;
        }
        return input;
    }

    public static Operation askOperation() throws InterruptOperationException {
        Operation operation;
        writeMessage("Введите номер операции");
        while (true) {
            try {
                String input = readString();
                int n = Integer.parseInt(input);
                operation = Operation.getAllowableOperationByOrdinal(n);
            } catch (IllegalArgumentException e) {
                writeMessage("Введите корректный номер операции");
                continue;
            }
            break;
        }
        return operation;
    }

    public static void printExitMessage() {
        writeMessage(res.getString("the.end"));
    }
}
