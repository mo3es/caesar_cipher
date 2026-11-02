package com.github.mo3es.caesarcipher.util;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ShiftByKeyTest {

    private final String alphabet = "abcdefghijklmnopqrstuvwxyz";

    @Test
    void testEncryptPositiveKey() {
        String result = ShiftByKey.start("abc", alphabet, 1);
        assertEquals("bcd", result);
    }

    @Test
    void testDecryptPositiveKey() {
        String result = ShiftByKey.start("bcd", alphabet, -1);
        assertEquals("abc", result);
    }

    @Test
    void testWrapAroundAlphabet() {
        String result = ShiftByKey.start("xyz", alphabet, 3);
        assertEquals("abc", result);
    }

    @Test
    void testCasePreservation() {
        String result = ShiftByKey.start("AbC", alphabet, 1);
        assertEquals("BcD", result);
    }

    @Test
    void testSpecialCharactersUnaffected() {
        String result = ShiftByKey.start("Hello, World!", alphabet, 2);
        assertEquals("Jgnnq, Yqtnf!", result);
    }

    @Test
    void testLargeKeyHandling() {
        String result = ShiftByKey.start("abc", alphabet, 27);
        assertEquals("bcd", result);
    }
}