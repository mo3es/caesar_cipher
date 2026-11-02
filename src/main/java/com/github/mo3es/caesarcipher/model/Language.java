package com.github.mo3es.caesarcipher.model;


public enum Language {
        UKRAINIAN(33),
        RUSSIAN(33),
        POLISH(32),
        SPANISH(27),
        GERMAN(30), // або 26 без умлаутів
        FRENCH(26),
        ENGLISH(26),
        UNKNOWN(26);

        private final int alphabetSize;

        Language(int alphabetSize) {
            this.alphabetSize = alphabetSize;
        }

        public int getAlphabetSize() {
            return alphabetSize;
        }
}

