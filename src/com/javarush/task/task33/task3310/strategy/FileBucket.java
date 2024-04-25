package com.javarush.task.task33.task3310.strategy;

import com.javarush.task.task33.task3310.ExceptionHandler;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileBucket  {
    private Path path;

    public FileBucket() {
        try {
            path = Files.createTempFile(null, null);
            Files.deleteIfExists(path);
            Files.createFile(path);
        } catch (IOException e) {
            ExceptionHandler.log(e);
        }
        path.toFile().deleteOnExit();
    }

    public long getFileSize() {
        try {
            return Files.size(path);
        } catch (IOException e) {
            ExceptionHandler.log(e);
            return 0;
        }
    }

    public void putEntry(Entry entry) {
        try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(path))) {
            while (entry != null) {
                oos.writeObject(entry);
                entry = entry.next;
            }
        } catch (IOException e) {
            ExceptionHandler.log(e);
        }
    }

    public Entry getEntry() {
        if (getFileSize() == 0) return null;
        Entry entry = null;

        try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(path))) {
            entry = (Entry) ois.readObject();
            Entry tmp = entry.next;
            while (tmp != null) {
                tmp = (Entry) ois.readObject();
                tmp = tmp.next;
            }
        } catch (IOException e) {
            ExceptionHandler.log(e);
        } catch (ClassNotFoundException e) {
            ExceptionHandler.log(e);
        }

        return entry;
    }

    public void remove() {
        try {
            Files.delete(path);
        } catch (IOException e) {
            ExceptionHandler.log(e);
        }
    }
}
