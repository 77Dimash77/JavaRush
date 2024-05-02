package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);

        if (args.length > 0) {
            switch (args[0]) {
                case "-c":
                    try {
                        String name = args[1];
                        Sex sex = args[2].equals("м") ? Sex.MALE : Sex.FEMALE;
                        Date birthDate = format.parse(args[3]);
                        synchronized (allPeople) {
                            allPeople.add(sex == Sex.MALE ? Person.createMale(name, birthDate) : Person.createFemale(name, birthDate));
                            System.out.println(allPeople.size() - 1);
                        }
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    break;
                case "-r":
                    synchronized (allPeople) {
                        int id = Integer.parseInt(args[1]);
                        Person person = allPeople.get(id);
                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                        String formattedDate = dateFormat.format(person.getBirthDate());
                        System.out.println(person.getName() + " " + (person.getSex() == Sex.MALE ? "м" : "ж") + " " + formattedDate);
                    }
                    break;
                case "-u":
                    try {
                        synchronized (allPeople) {
                            int id = Integer.parseInt(args[1]);
                            String name = args[2];
                            Sex sex = args[3].equals("м") ? Sex.MALE : Sex.FEMALE;
                            Date birthDate = format.parse(args[4]);
                            Person person = allPeople.get(id);
                            person.setName(name);
                            person.setSex(sex);
                            person.setBirthDate(birthDate);
                        }
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    break;
                case "-d":
                    synchronized (allPeople) {
                        int id = Integer.parseInt(args[1]);
                        Person person = allPeople.get(id);
                        person.setName(null);
                        person.setSex(null);
                        person.setBirthDate(null);
                    }
                    break;
            }
        }
    }
}