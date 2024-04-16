package com.javarush.task.task19.task1909;

import java.io.*;
import java.util.ArrayList;

/* 
Замена знаков
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        //File readers
        BufferedReader in=new BufferedReader(new FileReader(reader.readLine()));
        BufferedWriter out=new BufferedWriter(new FileWriter(reader.readLine()));
        while (in.ready()){
            int a = in.read();
            if((char)a == '.'){
                out.write("!");
            }else {
                out.write(a);
            }

        }
        reader.close();
        in.close();
        out.close();
    }
}
