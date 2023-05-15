package com.study.effectivejava.ch1.item5.factorymethod;

import com.study.effectivejava.ch1.item5.common.Dictionary;
import com.study.effectivejava.ch1.item5.common.MockDictionary;

public class MockDictionaryFactory implements DictionaryFactory {
    @Override
    public Dictionary getDictionary() {
        return new MockDictionary();
    }
}
