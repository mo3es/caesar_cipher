package com.github.mo3es.caesarcipher.util;

import com.github.mo3es.caesarcipher.model.Language;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CaesarBruteForceTest {

    @Test
    void testBruteForceFindsCorrectKey() {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        String originalText = "the quick brown fox jumps over the lazy dog";

        int expectedKey = 3;
        String encryptedText = ShiftByKey.start(originalText, alphabet, expectedKey);

        String analysisResult = CaesarBruteForce.start(encryptedText, alphabet, Language.ENGLISH);

        assertNotNull(analysisResult);

        assertTrue(analysisResult.contains("key=3") || analysisResult.contains("the quick brown fox"));
    }
}