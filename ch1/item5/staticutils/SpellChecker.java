package com.study.effectivejava.ch1.item5.staticutils;

import com.study.effectivejava.ch1.item5.common.DefaultDictionary;
import com.study.effectivejava.ch1.item5.common.Dictionary;

import java.util.List;

public class SpellChecker {

    private static final Dictionary dictionary = new DefaultDictionary(); // 자원을 직접 명시한다

    private SpellChecker() {}

    public static boolean isValid(String word) {
        // TODO 여기 SpellChecker 코드
        return dictionary.contains(word);
    }

    public static List<String> suggestions(String typo) {
        // TODO 여기 SpellChecker 코드
        return dictionary.closeWordsTo(typo);
    }
}
