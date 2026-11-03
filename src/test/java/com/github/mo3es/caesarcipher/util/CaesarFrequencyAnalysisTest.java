package com.github.mo3es.caesarcipher.util;

import com.github.mo3es.caesarcipher.model.Language;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CaesarFrequencyAnalysisTest {

    @Test
    void testFrequencyAnalysisExecution() {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        String originalText = "eeeeeeeeeeeeeeeeeeee quick brown fox jumps over the lazy dog aaaaaaaaaaaa";

        String encryptedText = ShiftByKey.start(originalText, alphabet, 4);

        String result = CaesarFrequencyAnalysis.start(encryptedText, alphabet, "ENGLISH");

        assertNotNull(result);
        assertTrue(result.contains("Results by Frequency analysis"));
        assertTrue(result.contains("Most probable result"));
    }
}
