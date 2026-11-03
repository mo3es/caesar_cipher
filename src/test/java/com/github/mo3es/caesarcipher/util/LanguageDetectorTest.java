package com.github.mo3es.caesarcipher.util;

import com.github.mo3es.caesarcipher.model.Language;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LanguageDetectorTest {

    @Test
    void testDetectEnglish() {
        Language lang = LanguageDetector.detectLanguage("This is a simple english text for testing.");
        assertEquals(Language.ENGLISH, lang);
    }

    @Test
    void testDetectUkrainianSpecific() {
        Language lang = LanguageDetector.detectLanguage("Привіт світ, це тестовий рядок з літерами ї, є, і, ґ.");
        assertEquals(Language.UKRAINIAN, lang);
    }

    @Test
    void testDetectPolishSpecific() {
        Language lang = LanguageDetector.detectLanguage("Zażółć gęślą jaźń ąęćłńóśźż");
        assertEquals(Language.POLISH, lang);
    }

    @Test
    void testDetectNullOrEmpty() {
        assertEquals(Language.UNKNOWN, LanguageDetector.detectLanguage(null));
        assertEquals(Language.UNKNOWN, LanguageDetector.detectLanguage("   "));
    }
}