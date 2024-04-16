package com.javarush.task.task19.task1921;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();



    public static void main(String[] args) throws IOException, ParseException {
        FileReader fr = new FileReader(args[0]);
        BufferedReader br = new BufferedReader(fr);

        ArrayList<String> personInfo = new ArrayList<>();
        while (br.ready()) {
            personInfo.add(br.readLine());
        }
        fr.close();
        br.close();


        for (int i = 0; i < personInfo.size(); i++) {
            PEOPLE.add(new Person(personInfo.get(i).substring(0, personInfo.get(i).replaceFirst("^(\\D+).*$", "$1").length() - 1), new SimpleDateFormat("dd MM yyyy").parse(personInfo.get(i).substring(personInfo.get(i).replaceFirst("^(\\D+).*$", "$1").length(), personInfo.get(i).length()))));
        }
    }
}