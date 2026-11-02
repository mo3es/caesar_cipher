package com.github.mo3es.caesarcipher.dao;

public class FrequencyReader {

    public static String[] getWordFrequency(String language){
        return MyFileProcessor.getFrequentWordsOrLetters(language, "frequent_words.csv");
    }

    public static String[] getCharFrequencies(String language){
        return MyFileProcessor.getFrequentWordsOrLetters(language,"letter_frequencies.csv");
    }
}
