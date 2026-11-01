package com.github.mo3es.caesarcipher.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileCreator {
    public static boolean createFile(Path path){
        try {
            if (path.getParent() != null && !Files.exists(path.getParent())) {
                Files.createDirectories(path.getParent());
            }
            Files.createFile(path);
            return true;
        }
        catch (IOException e){
            System.out.printf("File %s was not created\napplication will be finished\n", path);

        }
        return false;
    }
}
