package com.github.mo3es.caesarcipher.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import java.nio.file.Files;
import java.nio.file.Path;
import static org.junit.jupiter.api.Assertions.*;

class PathCheckerTest {

    @TempDir
    Path tempDir;

    @Test
    void testCheckExistingFile() throws Exception {
        Path existingFile = tempDir.resolve("test.txt");
        Files.writeString(existingFile, "some content");

        assertTrue(PathChecker.checkPath(existingFile, false));
        assertTrue(PathChecker.checkPath(existingFile, true));
    }

    @Test
    void testCheckNonExistingDestinationFile() {
        Path newFile = tempDir.resolve("output_result.txt");

        assertTrue(PathChecker.checkPath(newFile, true));
        assertTrue(Files.exists(newFile));
    }

    @Test
    void testCheckNonExistingSourceFile() {
        Path missingFile = tempDir.resolve("ghost.txt");

        assertFalse(PathChecker.checkPath(missingFile, false));
    }
}
