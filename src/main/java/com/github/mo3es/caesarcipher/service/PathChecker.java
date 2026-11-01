package com.github.mo3es.caesarcipher.service;

import java.nio.file.Files;
import java.nio.file.Path;

public class PathChecker {
    private static boolean checkIsFile(Path path){
        return Files.isRegularFile(path);

    }
    private static boolean checkIsDirectory(Path path){
        return Files.isDirectory(path);
    }

    public static boolean checkPath(Path path, boolean isDestinationFilePath){
        if(checkIsFile(path)) return true;
        if(!checkIsDirectory(path) && isDestinationFilePath){
            return FileCreator.createFile(path);
        }
        return false;
    }
}
