package com.github.mo3es.caesarcipher.service;

import com.github.mo3es.caesarcipher.model.Language;
import com.github.mo3es.caesarcipher.model.LanguageMode;
import com.github.mo3es.caesarcipher.util.LanguageDetector;

import java.util.Scanner;


public class LanguageSelector {


    public static Language selectLanguage(){
        System.out.println("""
                          Select language of encoded / decoded text
                          (UA - Ukrainian
                          PL - Polish
                          EN - English
                          GE - German
                          FR - French
                          SP - Spanish
                          or press ENTER to autodetect
                          """);
        Scanner sc = new Scanner(System.in);
        String languageChoice = sc.nextLine();
        return LanguageMode.fromString(languageChoice);
    }
}
