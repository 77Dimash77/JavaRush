package com.javarush.task.task22.task2211;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* 
Смена кодировки
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = new FileInputStream(args[0]);
        OutputStream outputStream = new FileOutputStream(args[1]);
        byte[]buff = new byte[1000];
        Charset windows1251 = Charset.forName("Windows-1251");
        Charset UTF = Charset.forName("UTF-8");
        while (inputStream.available()>0){
          inputStream.read(buff);
          String s = new String(buff,windows1251);
          buff = s.getBytes(UTF);
          outputStream.write(buff);
        }

    }
}
