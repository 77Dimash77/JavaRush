package com.javarush.task.task18.task1810;

import java.io.*;
import java.util.Scanner;

/* 
DownloadException
*/

public class Solution {
    public static void main(String[] args) throws DownloadException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true)
        {
            FileInputStream file = new FileInputStream(reader.readLine());

            if (file.available()<1000)
            {
                file.close();
                reader.close();
                throw new DownloadException();
            }
        }

    }

    public static class DownloadException extends Exception{

    }
}