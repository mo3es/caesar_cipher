package com.github.mo3es.caesarcipher;


import com.github.mo3es.caesarcipher.controller.ArgsProcessor;
import com.github.mo3es.caesarcipher.controller.CommandLineProcessor;

public class Main {
    public static void main(String[] args) {
        if(args == null || (args.length != 4 && args.length != 3)){
            new CommandLineProcessor().start();
        } else {
            new ArgsProcessor().start(args);
        }
    }
}