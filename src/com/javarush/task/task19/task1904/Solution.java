package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner {
private Scanner fileScanner;
PersonScannerAdapter(Scanner scanner){
    this.fileScanner = scanner;
}

        @Override
        public Person read() throws IOException, ParseException {
            String[] line = fileScanner.nextLine().split(" ");

            Calendar calendar = new GregorianCalendar(Integer.parseInt(line[5]),
                    Integer.parseInt(line[4]) - 1, Integer.parseInt(line[3]));

            return new Person(line[1], line[2], line[0], calendar.getTime());
        }

        @Override
        public void close() throws IOException {
fileScanner.close();
        }
    }
}
