package com.javarush.task.task31.task3110.command;

import com.javarush.task.task31.task3110.ConsoleHelper;
import com.javarush.task.task31.task3110.ZipFileManager;
import com.javarush.task.task31.task3110.exception.PathIsNotFoundException;
import com.javarush.task.task31.task3110.exception.WrongZipFileException;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ZipExtractCommand extends ZipCommand {
    @Override
    public void execute() throws Exception {
        try {
            ConsoleHelper.writeMessage("Распаковка архива.");

            ZipFileManager zipFileManager = getZipFileManager();

            ConsoleHelper.writeMessage("Введите путь для распаковки:");
            Path sourcePath = Paths.get(ConsoleHelper.readString());
            zipFileManager.extractAll(sourcePath);

            ConsoleHelper.writeMessage("Архив был распакован.");

        } catch (WrongZipFileException e) {
            ConsoleHelper.writeMessage("Неверный путь для распаковки.");
        }
    }
}
