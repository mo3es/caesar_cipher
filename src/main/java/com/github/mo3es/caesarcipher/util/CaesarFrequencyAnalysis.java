package com.github.mo3es.caesarcipher.util;

import com.github.mo3es.caesarcipher.dao.FrequencyReader;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;


public class CaesarFrequencyAnalysis {
    public static String start(String srcText, String alphabet, String language){
        String[] charFrequencies = FrequencyReader.getCharFrequencies(language);
        Map<Character, Integer> currentFrequencies = new HashMap<>();
        int counter = 0;
        int delta = 0;
        final int precisionBorder = 5;
        for(int i = 0; i < srcText.length(); i++){
            char currentChar = srcText.charAt(i);
            if(Character.isAlphabetic(currentChar)){
                currentChar = Character.toLowerCase(currentChar);
                if(currentFrequencies.containsKey(currentChar)){
                    currentFrequencies.put(currentChar, currentFrequencies.get(currentChar) + 1);
                }
                else currentFrequencies.put(currentChar, 1);
            }
        }
        var sortedFrequencies = currentFrequencies.entrySet()
                .stream()
                .sorted(Map.Entry.<Character, Integer>comparingByValue(Comparator.reverseOrder()))
                .toList();

        for(Map.Entry<Character, Integer> entry : sortedFrequencies){
            String [] currentFrequency = charFrequencies[counter].trim().split(":");
            char currentChar = currentFrequency[0].charAt(0);
            delta += Math.abs(alphabet.indexOf(entry.getKey()) - alphabet.indexOf(currentChar));
            counter += 1;
            if(counter == precisionBorder) break;
        }
        delta = (int)(Math.round((1.0 * delta) / counter));
        return String.format(
                "Results by Frequency analysis:%n" +
                        "Most probable result (obtained with key=%d) is presented below:%n%n%s", delta, ShiftByKey.start(srcText, alphabet, alphabet.length() - delta));
    }
}
