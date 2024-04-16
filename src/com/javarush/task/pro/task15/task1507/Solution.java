package com.javarush.task.pro.task15.task1507;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

/* 
Пропускаем не всех
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        Scanner scanner = new Scanner(System.in);
        String file = scanner.nextLine();
        Path path = Paths.get(file);
        try {
            List<String> list =  Files.readAllLines(path);


            for (int i = 0; i <list.size(); i += 2) {
                System.out.println(list.get(i));
            }

//            int count = 1;
//            while (!list.isEmpty()){
//                for(String s: list){
//                    if(count %2 == 0){
//                        System.out.println(s);
//                        count++;
//                    } else {
//                        count++;
//                    }
//                }
//            }

        } catch (Exception e){
            e.printStackTrace();
        }

    }
}

