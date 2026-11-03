package com.github.mo3es.caesarcipher.service;

import com.github.mo3es.caesarcipher.dao.MyFileProcessor;
import com.github.mo3es.caesarcipher.model.CipherMode;
import com.github.mo3es.caesarcipher.model.Language;
import com.github.mo3es.caesarcipher.util.CaesarBruteForce;
import com.github.mo3es.caesarcipher.util.CaesarFrequencyAnalysis;
import com.github.mo3es.caesarcipher.util.LanguageDetector;
import com.github.mo3es.caesarcipher.util.ShiftByKey;
import java.nio.file.Path;


public class CaesarProcessor {
    CipherMode mode;
    Path srcPath;
    Path destPath;
    int key;

    public CaesarProcessor(CipherMode mode, Path srcPath, Path destPath, int key){
        this.mode = mode;
        this.srcPath = srcPath;
        this.destPath = destPath;
        this.key = key;
    }

    public void start(){
        Language language = LanguageSelector.selectLanguage();
        String srcText = MyFileProcessor.read(srcPath);
        if(language == Language.UNKNOWN){
            language = LanguageDetector.detectLanguage(srcText);
        }
        if(language == Language.UNKNOWN){
            System.out.println("Can not recognize language, processing will be stopped");
            System.exit(0);
        }
        String currentAlphabet = MyFileProcessor.getAlphabet(language.name());
        if (currentAlphabet == null){
            System.out.printf("Alphabet for %s language not found, application will be stopped", language.name());
            System.exit(-1);
        }
        String processedText = null;
        switch (mode){
            case ENCRYPT -> processedText = ShiftByKey.start(srcText, currentAlphabet, key);
            case DECRYPT -> processedText = ShiftByKey.start(srcText, currentAlphabet, -key);
            case BRUTE_FORCE -> processedText = CaesarBruteForce.start(srcText, currentAlphabet, language);
            case FREQUENCY_ANALYSIS -> processedText = CaesarFrequencyAnalysis.start(srcText, currentAlphabet, language.name());
            default -> {
                System.out.println("Can not invoke appropriate encryption / decryption method, application will be stopped.");
                System.exit(-1);
            }
        }
        boolean isWritten = MyFileProcessor.write(destPath, processedText);
        if(!isWritten) {
            System.out.printf("As results was not written to file %s, results will be output to console:%n%n%n%s", destPath.toString(), processedText);
        }
        else{
            System.out.printf("Results was written to file %s; additionally results will be output to console:%n%n%n%s", destPath.toString(), processedText);
        }
    }
}
