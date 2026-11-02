package com.github.mo3es.caesarcipher.util;

import com.github.mo3es.caesarcipher.model.Language;

public class LanguageDetector {


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
            // латинські країно-специфічні маркери
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
            // загальна латинка (a-z)
            else if (c >= 'a' && c <= 'z') {
                latinCount++;
            }
            // загальна кирилиця
            else if (c >= '\u0400' && c <= '\u04FF') {
                cyrillicCount++;

                // українські маркери
                if (c == 'і' || c == 'ї' || c == 'є' || c == 'ґ') {
                    ukrainianSpecific++;
                }
                // російські маркери
                if (c == 'ы' || c == 'э' || c == 'ё' || c == 'ъ') {
                    russianSpecific++;
                }
            }
        }

        if (polishSpecific > 0) return Language.POLISH;
        if (spanishSpecific > 0) return Language.SPANISH;
        if (germanSpecific > 0) return Language.GERMAN;
        if (frenchSpecific > 0) return Language.FRENCH;

        if (ukrainianSpecific > 0) return Language.UKRAINIAN;
        if (russianSpecific > 0) return Language.RUSSIAN;

        if (cyrillicCount > latinCount) {

            return Language.UKRAINIAN;
        } else if (latinCount > 0) {
            return Language.ENGLISH;
        }
        return Language.UNKNOWN;
    }
}