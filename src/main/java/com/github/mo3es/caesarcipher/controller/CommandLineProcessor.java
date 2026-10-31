package com.github.mo3es.caesarcipher.controller;

import java.util.Scanner;

public class CommandLineProcessor {

    private final String[] agreeChoice = {"y", "yes"};
    private final String[] disagreeChoice = {"n", "no"};

    private final String MODE_REQUEST = """
            Type in operating mode:
            [e, encrypt] - encryption with given key;
            [d, decrypt] - decryption with given key;
            [b, brute] - decryption by brute-force;
            [f, freq] - decryption by frequency analysis
            """;
    private final String SRC_REQUEST = "Type in path to source file: ";
    private final String DEST_REQUEST = "Type in path to destination file: ";
    private final String KEY_REQUEST = "Type in the key: ";

    private final String[] REQUESTS = {MODE_REQUEST, SRC_REQUEST, DEST_REQUEST, KEY_REQUEST};
    private final Scanner sc = new Scanner(System.in);
    private final String[] ARGS = new String[REQUESTS.length];

    private String getAnswer(String request) {
        System.out.println(request);
        return sc.nextLine().trim();
    }

    private void isContinueInCLI() {
        while (true) {
            String cliRequest = """
                    You didn't give needed arguments while starting application.
                    Do you want to proceed in CLI mode? [y, yes / n, no]:
                    """;
            System.out.println(cliRequest);
            String result = sc.nextLine().trim().toLowerCase();

            if (result.equals(agreeChoice[0]) || result.equals(agreeChoice[1])) {
                break;
            }
            if (result.equals(disagreeChoice[0]) || result.equals(disagreeChoice[1])) {
                System.out.println("Exiting application...");
                System.exit(0);
            }
            System.out.println("Incorrect input. Please try again.");
        }
    }

    private void setParameters() {
        isContinueInCLI();
        for (int i = 0; i < ARGS.length; i++) {
            ARGS[i] = getAnswer(REQUESTS[i]);
        }
    }

    public void start() {
        setParameters();
        System.out.println("Parameters collected successfully!");
        new ArgsProcessor().start(ARGS);
    }
}