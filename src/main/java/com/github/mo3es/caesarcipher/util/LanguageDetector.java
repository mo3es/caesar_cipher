package com.github.mo3es.caesarcipher.util;

public class LanguageDetector {

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

    public static Language detectLanguage(String text) {
        if (text == null || text.isBlank()) {
            return Language.UNKNOWN;
        }

        int latinCount = 0;
        int cyrillicCount = 0;

        int ukrainianSpecific = 0;
        int russianSpecific = 0;
        int polishSpecific = 0;
        int spanishSpecific = 0;
        int germanSpecific = 0;
        int frenchSpecific = 0;

        String lowerText = text.toLowerCase();

        for (char c : lowerText.toCharArray()) {
            // 1. Перевірка європейських латинських маркерів
            if (c == 'ñ') {
                spanishSpecific++;
                latinCount++;
            } else if (c == 'ą' || c == 'ć' || c == 'ę' || c == 'ł' ||
                    c == 'ń' || c == 'ó' || c == 'ś' || c == 'ź' || c == 'ż') {
                polishSpecific++;
                latinCount++;
            } else if (c == 'ä' || c == 'ö' || c == 'ü' || c == 'ß') {
                germanSpecific++;
                latinCount++;
            } else if (c == 'ç' || c == 'à' || c == 'â' || c == 'é' ||
                    c == 'è' || c == 'ê' || c == 'ë' || c == 'î' || c == 'ï' || c == 'ô' || c == 'ù' || c == 'û') {
                frenchSpecific++;
                latinCount++;
            }
            // 2. Звичайна латиниця (a-z)
            else if (c >= 'a' && c <= 'z') {
                latinCount++;
            }
            // 3. Кирилиця (загальна)
            else if (c >= '\u0400' && c <= '\u04FF') {
                cyrillicCount++;

                // Українські маркери
                if (c == 'і' || c == 'ї' || c == 'є' || c == 'ґ') {
                    ukrainianSpecific++;
                }
                // Російські маркери
                if (c == 'ы' || c == 'э' || c == 'ё' || c == 'ъ') {
                    russianSpecific++;
                }
            }
        }

        // Визначення за пріоритетом специфічних маркерів
        if (polishSpecific > 0) return Language.POLISH;
        if (spanishSpecific > 0) return Language.SPANISH;
        if (germanSpecific > 0) return Language.GERMAN;
        if (frenchSpecific > 0) return Language.FRENCH;

        if (ukrainianSpecific > 0) return Language.UKRAINIAN;
        if (russianSpecific > 0) return Language.RUSSIAN;

        // Якщо специфічних знаків немає, оцінюємо загальні групи
        if (cyrillicCount > latinCount) {
            // Якщо кирилиця є, але маркери не спрацювали, за замовчуванням ближче до української/російської
            return Language.UKRAINIAN;
        } else if (latinCount > 0) {
            return Language.ENGLISH; // Базова латиниця без акцентів за замовчуванням — англійська
        }

        return Language.UNKNOWN;
    }
}