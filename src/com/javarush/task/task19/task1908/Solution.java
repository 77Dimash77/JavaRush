package com.javarush.task.task19.task1908;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/* 
Выделяем числа
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        //File readers
        BufferedReader in=new BufferedReader(new FileReader(reader.readLine()));
        BufferedWriter out=new BufferedWriter(new FileWriter(reader.readLine()));
        //Processing
        while(in.ready())
            for(String string:in.readLine().split(" "))
                if(checkString(string)) out.write(string+" ");
        in.close();;
        out.close();
        reader.close();
    }
    public static boolean checkString(String str){
        if(str==null||str.length()==0)return false;
        try{
            Integer.parseInt(str);
            return true;
        }catch (NumberFormatException ex){
            return false;
        }
    }
}

