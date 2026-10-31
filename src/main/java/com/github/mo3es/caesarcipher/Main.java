package com.github.mo3es.caesarcipher;


import com.github.mo3es.caesarcipher.controller.ArgsProcessor;
import com.github.mo3es.caesarcipher.controller.CommandLineProcessor;

public class Main {
    public static void main(String[] args) {
        if(args.length == 4 || args.length == 3){
            new ArgsProcessor().start(args);
        } else {
            new CommandLineProcessor().start();
        }
    }
}