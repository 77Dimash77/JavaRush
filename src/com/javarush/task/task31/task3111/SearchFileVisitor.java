package com.javarush.task.task31.task3111;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {
    private String partOfName;
    private String partOfContent;
    private int minSize;
    private int maxSize;
    private List<Path> foundFiles = new ArrayList<>();

    public void setPartOfName(String partOfName) {
        this.partOfName = partOfName;
    }

    public void setPartOfContent(String partOfContent) {
        this.partOfContent = partOfContent;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public List<Path> getFoundFiles() {
        return foundFiles;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        boolean nameMatched = true;
        boolean contentMatched = true;
        boolean sizeMatched = true;

        // Check if part of name is specified and if the file name contains it
        if (partOfName != null && !file.getFileName().toString().contains(partOfName)) {
            nameMatched = false;
        }

        // Check if part of content is specified and if the file content contains it
        if (partOfContent != null && !new String(Files.readAllBytes(file)).contains(partOfContent)) {
            contentMatched = false;
        }

        // Check if file size is within the specified range
        long fileSize = Files.size(file);
        if ((minSize > 0 && fileSize < minSize) || (maxSize > 0 && fileSize > maxSize)) {
            sizeMatched = false;
        }

        // If all criteria are matched, add the file to the list of found files
        if (nameMatched && contentMatched && sizeMatched) {
            foundFiles.add(file);
        }

        return FileVisitResult.CONTINUE;
    }
}