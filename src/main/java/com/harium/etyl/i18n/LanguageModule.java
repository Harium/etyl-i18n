package com.harium.etyl.i18n;

import com.harium.etyl.commons.context.Context;
import com.harium.etyl.commons.event.GUIEvent;
import com.harium.etyl.commons.event.KeyEvent;
import com.harium.etyl.commons.event.PointerEvent;
import com.harium.etyl.commons.graphics.Graphics;
import com.harium.etyl.commons.module.Module;

import java.util.ArrayList;
import java.util.List;

public class LanguageModule implements Module {

    private Language language = Language.ENGLISH_US;

    private List<LanguageChangeListener> listeners = new ArrayList<LanguageChangeListener>();

    private static LanguageModule instance;

    private LanguageModule() {
        super();
    }

    public static LanguageModule getInstance() {
        if (instance == null) {
            instance = new LanguageModule();
        }

        return instance;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public void addListener(LanguageChangeListener listener) {
        listeners.add(listener);
    }

    public void removeListener(LanguageChangeListener listener) {
        listeners.remove(listener);
    }

    @Override
    public void updateMouse(PointerEvent event) {

    }

    @Override
    public void updateKeyboard(KeyEvent event) {

    }

    @Override
    public void updateGuiEvent(GUIEvent event) {
        if (event == GUIEvent.LANGUAGE_CHANGED) {
            changeLanguage(language);
        }
    }

    public void changeLanguage(Language language) {
        LanguageModule.getInstance().setLanguage(language);
        for (LanguageChangeListener listener : listeners) {
            listener.changeLanguage(language);
        }
    }

    @Override
    public void init(Context context) {

    }

    @Override
    public void dispose(Context context) {
        listeners.clear();
    }

    @Override
    public void draw(Graphics g) {

    }

    @Override
    public void update(long now) {

    }
}
