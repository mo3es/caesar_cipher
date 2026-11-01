package com.github.mo3es.caesarcipher.service;

import com.github.mo3es.caesarcipher.model.CipherMode;
import java.nio.file.Path;

public class CaesarEncoderDecoder {
    CipherMode mode;
    Path srcPath;
    Path destPath;
    int key;

    public CaesarEncoderDecoder(CipherMode mode, Path srcPath, Path destPath, int key){
        this.mode = mode;
        this.srcPath = srcPath;
        this.destPath = destPath;
        this.key = key;
    }

    public void start(){

    }
}
