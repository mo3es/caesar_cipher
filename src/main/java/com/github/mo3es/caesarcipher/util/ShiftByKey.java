package com.github.mo3es.caesarcipher.util;

public class ShiftByKey {

    public static String start(String srcText, String alphabet, int key){

        StringBuilder builder = new StringBuilder();
        int alphabetSize = alphabet.length();
        key = (key % alphabetSize + alphabetSize) % alphabetSize;

        for(int i = 0; i < srcText.length(); i++){
            char currentChar = srcText.charAt(i);
            boolean isUpper = Character.isUpperCase(currentChar);
            char lowerCurrentChar = Character.toLowerCase(currentChar);
            int index = alphabet.indexOf(lowerCurrentChar);
            if(index != -1){
                currentChar = alphabet.charAt((index + key) % alphabetSize);
                if(isUpper) currentChar = Character.toUpperCase(currentChar);
            }
            builder.append(currentChar);
        }
        return builder.toString();
    }
}
