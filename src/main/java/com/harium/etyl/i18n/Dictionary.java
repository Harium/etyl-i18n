package com.harium.etyl.i18n;

import java.util.HashMap;
import java.util.Map;

public class Dictionary {

    protected Language defaultLanguage = Language.ENGLISH_US;

    protected Map<Language, Map<String, String>> sentences;

    public Dictionary() {
        sentences = new HashMap<Language, Map<String, String>>();
    }

    public void addLanguage(Language language) {
        addLanguage(language, new HashMap<String, String>());
    }

    public void addLanguage(Language language, Map<String, String> vocabulary) {
        sentences.put(language, vocabulary);
    }

    public void addWord(Language language, String key, String value) {
        if (!sentences.containsKey(language)) {
            addLanguage(language);
        }

        Map<String, String> words = sentences.get(language);
        words.put(key, value);
    }

    public void setDefaultLanguage(Language language) {
        this.defaultLanguage = language;
    }

    public Map<String, String> getSentences(Language language) {
        return sentences.get(language);
    }

    public void clear() {
        sentences.clear();
    }

    public String getText(Language language, String key) {
        Map<String, String> words;

        if (sentences.containsKey(language)) {
            words = sentences.get(language);
        } else {
            words = sentences.get(defaultLanguage);
        }

        return words.get(key);
    }

    public Language getDefaultLanguage() {
        return defaultLanguage;
    }

}
