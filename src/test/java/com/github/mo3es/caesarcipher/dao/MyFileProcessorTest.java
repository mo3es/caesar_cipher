package com.github.mo3es.caesarcipher.dao;

import com.github.mo3es.caesarcipher.dao.MyFileProcessor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import java.nio.file.Path;
import static org.junit.jupiter.api.Assertions.*;

class MyFileProcessorTest {

    @TempDir
    Path tempDir;

    @Test
    void testWriteAndReadText() {
        Path file = tempDir.resolve("io_test.txt");
        String testString = "Hello, Caesar Cipher Project!";

        boolean isWritten = MyFileProcessor.write(file, testString);
        assertTrue(isWritten);

        String readResult = MyFileProcessor.read(file);
        assertEquals(testString, readResult);
    }

    @Test
    void testGetAlphabetFromResources() {
        String alphabet = MyFileProcessor.getAlphabet("ENGLISH");
        assertNotNull(alphabet);
        assertEquals("abcdefghijklmnopqrstuvwxyz", alphabet);
    }
}
