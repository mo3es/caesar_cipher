package com.github.mo3es.caesarcipher.controller;

import java.util.Map;

public class ArgsProcessor {

    private final Map<String, String[]> MODES = Map.of(
            "encryption", new String[]{"e", "encrypt", "encryption"},
            "decryption", new String[]{"d", "decrypt", "decryption"},
            "brute-force", new String[]{"b", "brute", "brute-force"},
            "frequency-analysis", new String[]{"f", "freq", "frequency", "analysis"}
    );


    public void start(String ... args){

    }
}
