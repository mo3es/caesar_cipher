package com.github.mo3es.caesarcipher.model;

public enum LanguageMode {
    UKRAINIAN("ua", "ukr", "ukrainian", "укр", "українська"),
    POLISH("pl", "polish", "pol", "polska"),
    RUSSIAN("ru", "rus", "russian", "ру", "рус", "русский"),
    SPANISH("sp", "spanish", "esp", "español"),
    GERMAN("ge", "ger", "german", "de", "deutsche"),
    FRENCH("fr", "french", "français"),
    ENGLISH("en", "eng", "english"),
    UNKNOWN("");

        private final String[] aliases;

        LanguageMode(String... aliases) {
            this.aliases = aliases;
        }

        public static Language fromString(String text) {
            if (text == null || text.isBlank()) return Language.UNKNOWN;
            String lowerText = text.trim().toLowerCase();

            for (LanguageMode mode : values()) {
                for (String alias : mode.aliases) {
                    if (alias.equals(lowerText)) {
                        return Language.valueOf(mode.name());
                    }
                }
            }
            return Language.UNKNOWN;
        }
}
