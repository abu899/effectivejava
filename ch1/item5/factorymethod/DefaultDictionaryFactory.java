package com.study.effectivejava.ch1.item5.factorymethod;

import com.study.effectivejava.ch1.item5.common.DefaultDictionary;
import com.study.effectivejava.ch1.item5.common.Dictionary;

public class DefaultDictionaryFactory implements DictionaryFactory {
    @Override
    public Dictionary getDictionary() {
        return new DefaultDictionary();
    }
}
