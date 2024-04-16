package com.javarush.task.task31.task3106;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* 
Разархивируем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 1; i < args.length; i ++){
            list.add(args[i]);
        }
        Collections.sort(list);

        ArrayList<InputStream> streams = new ArrayList<>();
        for (String s : list){
            streams.add(new FileInputStream(s));
        }

        FileOutputStream fos = new FileOutputStream(args[0]);
        ZipInputStream zis = new ZipInputStream(new SequenceInputStream(Collections.enumeration(streams)));
        byte[] bytes = new byte[1024];
        int len;

        while (zis.getNextEntry() != null){
            while ((len = zis.read(bytes)) > -1 ){
                fos.write(bytes, 0, len);
            }
        }

        zis.close();
        fos.close();
    }
}
