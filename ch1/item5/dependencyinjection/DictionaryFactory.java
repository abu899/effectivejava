package com.study.effectivejava.ch1.item5.dependencyinjection;

import com.study.effectivejava.ch1.item5.common.DefaultDictionary;

public class DictionaryFactory {
    public static DefaultDictionary get() {
        return new DefaultDictionary();
    }
}
