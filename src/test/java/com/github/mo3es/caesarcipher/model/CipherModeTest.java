package com.github.mo3es.caesarcipher.model;

import com.github.mo3es.caesarcipher.model.CipherMode;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CipherModeTest {

    @Test
    void testFromStringValidAliases() {
        assertEquals(CipherMode.ENCRYPT, CipherMode.fromString("e"));
        assertEquals(CipherMode.ENCRYPT, CipherMode.fromString("encrypt"));
        assertEquals(CipherMode.DECRYPT, CipherMode.fromString("decryption"));
        assertEquals(CipherMode.BRUTE_FORCE, CipherMode.fromString("brute"));
        assertEquals(CipherMode.FREQUENCY_ANALYSIS, CipherMode.fromString("freq"));
    }

    @Test
    void testFromStringCaseInsensitive() {
        assertEquals(CipherMode.ENCRYPT, CipherMode.fromString("ENCRYPT"));
        assertEquals(CipherMode.DECRYPT, CipherMode.fromString("d"));
    }

    @Test
    void testFromStringInvalidOrNull() {
        assertNull(CipherMode.fromString(null));
        assertNull(CipherMode.fromString(""));
        assertNull(CipherMode.fromString("unknown_mode"));
    }
}