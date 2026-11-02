package com.github.mo3es.caesarcipher.controller;

import com.github.mo3es.caesarcipher.model.CipherMode;
import com.github.mo3es.caesarcipher.service.CaesarProcessor;
import com.github.mo3es.caesarcipher.service.PathChecker;
import java.nio.file.Path;

public class ArgsProcessor {

    private final String USAGE_MESSAGE = """
            Usage: start_app_name mode path_to_source_file path_to_destination_file {key}
                mode   -  [e, encrypt, encryption / d, decrypt, decryption / b, brute, brute-force / f, freq, frequency, analysis]
                path_to_source_file - string representing absolute or relative path to existing source file
                path_to_destination_file - string representing path to destination file (will be created if not exists)
                key  -  key for encryption or decryption operations (optional for brute-force / frequency analysis)
            """;

    public void start(String... args) {

        CipherMode mode = CipherMode.fromString(args[0]);
        if (mode == null) {
            System.out.printf("Incorrect mode chosen: %s\n", args[0]);
            System.out.println(USAGE_MESSAGE);
            System.exit(-1);
        }

        Path srcPath = null;
        Path destPath = null;
        int key = 0;

        if (PathChecker.checkPath(Path.of(args[1]), false)) {
            srcPath = Path.of(args[1]);
        } else {
            System.out.printf("Incorrect source file given: %s does not exist or is not readable\n", args[1]);
            System.out.println(USAGE_MESSAGE);
            System.exit(-1);
        }

        if (PathChecker.checkPath(Path.of(args[2]), true)) {
            destPath = Path.of(args[2]);
        } else {
            System.out.printf("Incorrect destination file given: %s is not a valid file or could not be created\n", args[2]);
            System.out.println(USAGE_MESSAGE);
            System.exit(-1);
        }

        if (mode == CipherMode.ENCRYPT || mode == CipherMode.DECRYPT) {
            if (args.length < 4 || args[3].isBlank()) {
                System.out.println("Incorrect arguments - encryption/decryption key needed but was not given");
                System.out.println(USAGE_MESSAGE);
                System.exit(-1);
            }
            try {
                key = Integer.parseInt(args[3]);
            } catch (NumberFormatException e) {
                System.out.printf("Incorrect key format - '%s' is not a valid integer\n", args[3]);
                System.out.println(USAGE_MESSAGE);
                System.exit(-1);
            }
        }

        CaesarProcessor ced = new CaesarProcessor(mode, srcPath, destPath, key);
        ced.start();
    }
}