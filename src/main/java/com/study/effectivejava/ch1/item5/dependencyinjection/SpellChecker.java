package com.study.effectivejava.ch1.item5.dependencyinjection;

import com.study.effectivejava.ch1.item5.common.Dictionary;

import java.util.List;
import java.util.function.Supplier;

public class SpellChecker {

    private final Dictionary dictionary;

    public SpellChecker(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    // 한번 더 추상화
//    public SpellChecker(Supplier<Dictionary> dictionarySupplier) {
    public SpellChecker(Supplier<? extends Dictionary> dictionarySupplier) { // 타입 한정자
        this.dictionary = dictionarySupplier.get();
    }

    public boolean isValid(String word) {
        // TODO 여기 SpellChecker 코드
        return dictionary.contains(word);
    }

    public List<String> suggestions(String typo) {
        // TODO 여기 SpellChecker 코드
        return dictionary.closeWordsTo(typo);
    }
}
