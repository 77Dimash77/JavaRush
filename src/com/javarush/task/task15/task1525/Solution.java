package com.javarush.task.task15.task1525;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/* 
Файл в статическом блоке
*/

public class Solution {
    public static List<String> lines = new ArrayList<String>();
    static {
        try{
            Path path = Paths.get(Statics.FILE_NAME);
            lines = Files.readAllLines(path);
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        System.out.println(lines);
    }
}
