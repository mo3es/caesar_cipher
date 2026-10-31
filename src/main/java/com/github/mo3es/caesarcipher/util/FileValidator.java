package com.github.mo3es.caesarcipher.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileValidator {

    public static boolean validatePath(String pathString, boolean isSource) {
        Path path = Path.of(pathString);

        if (!Files.exists(path) && isSource) {
            System.out.println("Error: File does not exist -> " + pathString);
            return false;
        }
        else if (!Files.exists(path) && !isSource){
            boolean isCreate = createDestinationFile(path);
            if(!isCreate) return false;
        }

        if (!Files.isRegularFile(path)) {
            System.out.println("Error: Target is not a valid file -> " + pathString);
            return false;
        }
        if (isSource && !Files.isReadable(path)) {
            System.out.println("Error: File is not readable (permission denied) -> " + pathString);
            return false;
        }
        else if (!isSource && !Files.isWritable(path)){
            System.out.println("Error: Can not write to destination file (permission denied) -> " + pathString);
            return false;
        }
        return true;
    }

    private static boolean createDestinationFile(Path path) {
        try {
            if (path.getParent() != null && !Files.exists(path.getParent())) {
                Files.createDirectories(path.getParent());
            }
            Files.createFile(path);
            return true;
        } catch (IOException e) {
            System.out.println("Error: Could not create destination file -> " + e.getMessage());
            return false;
        }
    }
}
