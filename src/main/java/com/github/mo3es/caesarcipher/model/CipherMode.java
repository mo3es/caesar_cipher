package com.github.mo3es.caesarcipher.model;

public enum CipherMode {
    ENCRYPT("e", "encrypt", "encryption"),
    DECRYPT("d", "decrypt", "decryption"),
    BRUTE_FORCE("b", "brute", "brute-force"),
    FREQUENCY_ANALYSIS("f", "freq", "frequency", "analysis");

    private final String[] aliases;

    CipherMode(String... aliases) {
        this.aliases = aliases;
    }

    // перетворення текстового аргументу на константу enum
    public static CipherMode fromString(String text) {
        if (text == null) return null;
        String lowerText = text.toLowerCase();

        for (CipherMode mode : values()) {
            for (String alias : mode.aliases) {
                if (alias.equals(lowerText)) {
                    return mode;
                }
            }
        }
        return null; // Повертає null, якщо режим не знайдено
    }
}