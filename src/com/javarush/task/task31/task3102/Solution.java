package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Stack;

/* 
Находим все файлы
*/

public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        List<String> fileList = new ArrayList<>();
        Stack<File> stack = new Stack<>();
        stack.push(new File(root));

        while (!stack.isEmpty()) {
            File currentDir = stack.pop();
            File[] files = currentDir.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        stack.push(file);
                    } else {
                        fileList.add(file.getAbsolutePath());
                    }
                }
            }
        }

        return fileList;
    }

    public static void main(String[] args) {
        String rootDirectory = "/path/to/your/root/directory";
        try {
            List<String> fileTree = getFileTree(rootDirectory);
            for (String filePath : fileTree) {
                System.out.println(filePath);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}