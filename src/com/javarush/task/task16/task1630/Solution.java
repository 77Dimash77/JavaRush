package com.javarush.task.task16.task1630;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Последовательный вывод файлов
*/

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    static {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReadFileInterface f1 = new ReadFileThread();
        f1.setFileName(firstFileName);
        f1.start();
        f1.join();

        ReadFileInterface f2 = new ReadFileThread();
        f2.setFileName(secondFileName);
        f2.start();
        f2.join();

        systemOutPrintln(f1);
        systemOutPrintln(f2);
    }

    public static void systemOutPrintln(ReadFileInterface f) throws InterruptedException {
        f.join();
        System.out.println(f.getFileContent());
    }

    public static class ReadFileThread extends Thread implements ReadFileInterface {
        private String fileName;
        private StringBuilder fileContent = new StringBuilder();

        @Override
        public void setFileName(String fullFileName) {
            this.fileName = fullFileName;
        }

        @Override
        public String getFileContent() {
            return fileContent.toString();
        }

        @Override
        public void run() {
            try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    fileContent.append(line).append(" ");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void start() {
            super.start();
        }
    }

    public interface ReadFileInterface {
        void setFileName(String fullFileName);
        String getFileContent();
        void join() throws InterruptedException;
        void start();
    }
}