package com.javarush.task.pro.task14.task1401;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Поработай обработчиком
*/

public class Solution {

    public static final String INPUT_NAME = "\nВведите имя: ";
    public static final String INPUT_AGE = "Введите возраст пользователя '%s': ";

    public static final String CANNOT_BE_NULL = "Имя не может быть null.";
    public static final String CANNOT_BE_EMPTY = "Имя не может быть пустым.";
    public static final String CANNOT_CONTAIN_DIGIT = "Имя не может содержать цифры.";
    public static final String CANNOT_BE_NEGATIVE = "Возраст не может быть меньше 0.";
    public static final String CANNOT_BE_TOO_BIG = "Возраст не может быть больше 150.";
    public static final String UNKNOWN_ERROR = "Неизвестная ошибка.";

    public static final String FOUND = "\nПользователь '%s' найден под индексом %d.\n";
    public static final String NOT_FOUND = "\nПользователь '%s' не найден.\n";

    static List<User> users = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            addUser(new User());
        }

        User userToSearch = new User();
        userToSearch.setName("Рафаэль");

        findUserIndex(userToSearch);
    }

    static void addUser(User user) {
        System.out.print(INPUT_NAME);
        String name = scanner.nextLine();
        int setNameResult = user.setName(name);
        switch (setNameResult) {
            case -1:
                System.out.println(CANNOT_BE_NULL);
                return;
            case -2:
                System.out.println(CANNOT_BE_EMPTY);
                return;
            case -3:
                System.out.println(CANNOT_CONTAIN_DIGIT);
                return;
            case 0:
                break;
            default:
                System.out.println(UNKNOWN_ERROR);
                return;
        }

        System.out.printf(INPUT_AGE, name);
        int age;
        try {
            age = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println(CANNOT_BE_NEGATIVE);
            return;
        }
        int setAgeResult = user.setAge(age);
        switch (setAgeResult) {
            case -1:
                System.out.println(CANNOT_BE_NEGATIVE);
                return;
            case -2:
                System.out.println(CANNOT_BE_TOO_BIG);
                return;
            case 0:
                break;
            default:
                System.out.println(UNKNOWN_ERROR);
                return;
        }

        users.add(user);
    }

    static void findUserIndex(User user) {
        int index = users.indexOf(user);
        if (index != -1) {
            System.out.printf(FOUND, user.getName(), index);
        } else {
            System.out.printf(NOT_FOUND, user.getName());
        }
    }
}
