package com.github.mo3es.caesarcipher.util;

import com.github.mo3es.caesarcipher.dao.FrequencyReader;
import com.github.mo3es.caesarcipher.model.Language;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CaesarBruteForce {

    public static String start(String srcText, String alphabet, Language language) {
        String[] frequentWords = FrequencyReader.getWordFrequency(language.name());
        List<int[]> quantityByKey = new ArrayList<>();

        for (int i = 0; i < language.getAlphabetSize(); i++) {
            String result = ShiftByKey.start(srcText, alphabet, i);
            int currentCount = getEqualityCount(result, frequentWords);
            quantityByKey.add(new int[]{currentCount, i});
        }

        quantityByKey.sort(Comparator.comparingInt((int[] pair) -> pair[0]).reversed());

        int bestKey = quantityByKey.get(0)[1];
        int secondKey = quantityByKey.size() > 1 ? quantityByKey.get(1)[1] : 0;
        int thirdKey = quantityByKey.size() > 2 ? quantityByKey.get(2)[1] : 0;
        int fourthKey = quantityByKey.size() > 3 ? quantityByKey.get(3)[1] : 0;

        String decryptedText = ShiftByKey.start(srcText, alphabet, bestKey);

        return String.format(
                "Results by Brute-force analysis:%n" +
                        "Most probable result (obtained with key=%d) is presented below.%n" +
                        "If this result is insufficient, you can try decryption with other likely keys: 2nd place - %d, 3rd place - %d, 4th place - %d; or try Frequency Analysis.%n%n" +
                        "Most probable result is:%n%n%s",
                bestKey, secondKey, thirdKey, fourthKey, decryptedText
        );
    }

    private static int getEqualityCount(String text, String[] frequentWords) {
        String[] wordsInProcessedText = text.split("\\s+");
        int countOfEquality = 0;

        for (String word : wordsInProcessedText) {
            String cleaned = cleanedWord(word);
            if (cleaned.isEmpty()) continue;

            for (String targetWord : frequentWords) {
                if (targetWord.equalsIgnoreCase(cleaned)) {
                    countOfEquality++;
                }
            }
        }
        return countOfEquality;
    }

    private static String cleanedWord(String word) {
        if (word == null || word.isEmpty()) {
            return "";
        }
        return word.replaceAll("^[^\\p{L}\\p{Nd}]+|[^\\p{L}\\p{Nd}]+$", "").toLowerCase();
    }
}