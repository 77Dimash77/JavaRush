package com.javarush.task.task17.task1711;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        switch (args[0]){
            case "-c":
                synchronized (allPeople){
                    int i = 1;
                    while (args.length > i) {
                        String name = args[i];
                        i++;
                        if (args[i].equals("м")){
                            i++;
                            Date date = sdf.parse(args[i]);
                            allPeople.add(Person.createMale(name, date));
                        } else {
                            i++;
                            Date date = sdf.parse(args[i]);
                            allPeople.add(Person.createFemale(name, date));
                        }
                        System.out.println(allPeople.size() - 1);
                        i++;
                    }
                }
                break;

            case "-u":
                synchronized (allPeople){
                    int i = 1;
                    int index;
                    while (args.length > i){
                        index = Integer.parseInt(args[i]);
                        i++;
                        allPeople.get(index).setName(args[i]);
                        i++;
                        if (args[i].equals("м")) {
                            allPeople.get(index).setSex(Sex.MALE);
                        } else {
                            allPeople.get(index).setSex(Sex.FEMALE);
                        }
                        i++;
                        Date date = sdf.parse(args[i]);
                        allPeople.get(index).setBirthDate(date);
                        i++;
                    }
                }
                break;

            case "-d":
                synchronized (allPeople){
                    for (int i = 1; i < args.length; i++) {
                        int index = Integer.parseInt(args[i]);
                        allPeople.get(index).setName(null);
                        allPeople.get(index).setSex(null);
                        allPeople.get(index).setBirthDate(null);
                    }
                }
                break;

            case "-i":
                SimpleDateFormat sdfForI = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        int index = Integer.parseInt(args[i]);
                        System.out.print(allPeople.get(index).getName()+" ");
                        if (allPeople.get(index).getSex().equals(Sex.MALE)){
                            System.out.print("м ");
                        } else {
                            System.out.print("ж ");
                        }
                        System.out.print((sdfForI.format(allPeople.get(index).getBirthDate()))+" ");
                    }
                    break;
                }
        }
    }
}