package com.study.effectivejava.ch1.item5.common;

import org.springframework.stereotype.Component;

import java.util.List;

public class DefaultDictionary implements Dictionary{

    @Override
    public boolean contains(String word) {
        return false;
    }

    @Override
    public List<String> closeWordsTo(String typo) {
        return null;
    }
}
