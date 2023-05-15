package com.study.effectivejava.ch1.item5.singleton;

import com.study.effectivejava.ch1.item5.common.DefaultDictionary;
import com.study.effectivejava.ch1.item5.common.Dictionary;

import java.util.List;

public class SpellChecker {

    private final Dictionary dictionary = new DefaultDictionary();

    private SpellChecker() {}

    public static final SpellChecker INSTANCE = new SpellChecker();

    public boolean isValid(String word) {
        return dictionary.contains(word);
    }

    public List<String> suggestions(String typo) {
        return dictionary.closeWordsTo(typo);
    }
}
