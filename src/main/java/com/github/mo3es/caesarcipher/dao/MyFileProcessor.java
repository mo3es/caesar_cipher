package com.github.mo3es.caesarcipher.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class MyFileProcessor {
    public static String read(Path srcPath){
        try {
            return Files.readString(srcPath, StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.out.printf("Can not read source file: %s;%n application will be aborted%n", e.getMessage());
            System.exit(-1);
        }
        return null;
    }

    public static boolean write(Path destPath, String text){
        try {
            Files.writeString(destPath, text, StandardCharsets.UTF_8,StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.CREATE);
            return true;
        } catch (Exception e) {
            System.out.printf("Can not save result: %s%n", e.getMessage());
            return false;
        }
    }

    public static  String getAlphabet(String language) {
        List<String> alphabets;
        try (InputStream inputStream = MyFileProcessor.class.getClassLoader().getResourceAsStream("alphabets.csv")) {
            if (inputStream == null) {
                throw new RuntimeException("File alphabets.csv not found in resources!");
            }
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
                alphabets = reader.lines().toList();
            } catch (IOException e) {
                throw new RuntimeException(String.format("File alphabets.csv was found but can not read: %s%n", e.getMessage()));
            }
        } catch (IOException e) {
            throw new RuntimeException(String.format("File alphabets.csv was found but can not read: %s%n", e.getMessage()));
        }
        for (String alphabetLine : alphabets) {
            String[] parts = alphabetLine.split(",");
            if (parts.length >= 3 && parts[0].trim().equalsIgnoreCase(language)) {
                return parts[2].trim();
            }
        }
        return null;
    }
    public static  String[] getFrequentWordsOrLetters(String language, String fileName) {
        List<String> frequentWords;
        try (InputStream inputStream = MyFileProcessor.class.getClassLoader().getResourceAsStream(fileName)) {
            if (inputStream == null) {
                throw new RuntimeException(String.format("File %s not found in resources!", fileName));
            }
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
                frequentWords = reader.lines().toList();
            } catch (IOException e) {
                throw new RuntimeException(String.format("File %s was found but can not read: %s%n", fileName, e.getMessage()));
            }
        } catch (IOException e) {
            throw new RuntimeException(String.format("File %s was found but can not read: %s%n", fileName, e.getMessage()));
        }
        for(String words : frequentWords){
            if (!words.startsWith(language)) continue;
            String[] parts = words.split(",");
            if (parts.length >= 2 && parts[0].trim().equalsIgnoreCase(language)) {
                return parts[1].trim().split(" ");
            }
        }
        return null;
    }
}