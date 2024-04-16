package com.javarush.task.task18.task1826;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
Шифровка
*/

public class Solution {
    public static void main(String[] args) throws IOException {
String file1read = args[1];
String file2write = args[2];
FileInputStream fileInputStream = new FileInputStream(file1read);
FileOutputStream fileOutputStream = new FileOutputStream(file2write);
byte[]buffer = new byte[fileInputStream.available()];
if(args[0].equals("-e")){
    int a = fileInputStream.read(buffer);
for (byte b: buffer){
    fileOutputStream.write(b + 1);
}
} else if (args[0].equals("-d")) {
    int a = fileInputStream.read(buffer);
    for (byte b: buffer){
        fileOutputStream.write(b - 1);
}} fileInputStream.close();
fileOutputStream.close();

    }

}
